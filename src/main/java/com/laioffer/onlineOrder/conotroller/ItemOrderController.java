package com.laioffer.onlineOrder.conotroller;

import com.laioffer.onlineOrder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class ItemOrderController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/order/{menueId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addMenuItemTroCart(@PathVariable("menueId") int method){
        orderItemService.saveOrderItem(method);
    }
}
