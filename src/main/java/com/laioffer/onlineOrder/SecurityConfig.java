package com.laioffer.onlineOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//https://docs.spring.io/spring-security/site/docs/5.5.5/reference/html5/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HttpSecurity http: 做authorize的
        http
                .csrf().disable()
                .formLogin()// 成功后跳转到home页面
                .failureForwardUrl("/login?error=true");
        http
                .authorizeRequests()
                .antMatchers("/order/*", "/cart", "/checkout").hasAuthority("ROLE_USER")
                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //AuthenticationManagerBuilder auth: 链接数据库，具体到table，获得用户和密码等，请求近来后filter根据配置链接数据库，query数据库获得数据后
        // match，request里的用户名密码等
        auth
                .jdbcAuthentication() // 通过jdbc连接数据库
                .dataSource(dataSource) //设置DataSource
                .passwordEncoder(passwordEncoder) // 输入的密码需要加密后和数据库里找回来的match
                // 以下语句实现通过用户名去数据库拿到email和密码，然后和前端query中输入的用户名和密码匹配
                // security里的query 用sql语句而不是orm，框架是这么写的
                .usersByUsernameQuery("SELECT email, password, enabled FROM customers WHERE email=?")// enabled 意义用户登录进去后enabled是否true
                // 以下语句实现拿到authority，在上面的configure里order，checkout等都要用到
                .authoritiesByUsernameQuery("SELECT email, authorities FROM authorities WHERE email=?");
    }
}
