package com.laioffer.onlineOrder.conotroller;
import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
public class SignUpController {
    private CustomerService customerService;
    @Autowired
    public SignUpController(CustomerService customerService){
        this.customerService = customerService;
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public void signUp(@RequestBody Customer customer, HttpServletResponse response) throws IOException {
//        response.setStatus(201);
//        try{
//            customerService.signUp(customer);
//        }catch(Exception ex){
//            response.setStatus(500);
//        }
//        // exception

//        response.setStatus(500);
//        // successful
//        response.setStatus(201);
//        response.getWriter().print("Successful signUp!");
//    }
}
