package com.laioffer.onlineOrder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String email;

    private String authorities;
    public Authorities() {}
    public Authorities(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
