package com.laioffer.onlineOrder;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.laioffer.onlineOrder.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!123!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        第一个例子
//        response.setContentType("text/html");
//
//        // Hello
//        String customer = request.getParameter("customer");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Hello: " + customer + "</h1>");
//        out.println("</body></html>");
        // 第二个例子
//        response.setContentType("application/json");
//        JSONObject customer = new JSONObject();
//        customer.put("email", "123@gmail.com");
//        customer.put("name","jianghua");
//        customer.put("age","18");
//        response.getWriter().print(customer);
        // 第三个例子
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setEmail("123@gmail.com");
        customer.setFirstName("j");
        customer.setLastName("f");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
       JSONObject jsonRequest = new JSONObject(IOUtils.toString(req.getReader()));
       String email = jsonRequest.getString("email");
       int age = jsonRequest.getInt("age");

       JSONObject jsonResponse = new JSONObject();
       jsonResponse.put("status", "ok");
       resp.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}