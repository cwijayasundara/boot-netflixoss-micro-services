package com.cham.orders.controllers;

import com.cham.orders.services.OrderService;
import com.cham.orders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cwijayasundara on 26/01/2017.
 */

@RestController
@RequestMapping(value="v1/products/{productid}/orders")
public class OrderServiceController {

    @Autowired
    private OrderService orderService;

    /*@Autowired
    private ServiceConfig serviceConfig;*/

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Order> getOrders(@PathVariable("productid") String productId) {
        System.out.println("Inside OrderServiceController --> getOrders()  ++++++: NO WS CALL BUT HYSTRIX" + productId);
        return orderService.getOrdersByProduct(productId);
    }

    @RequestMapping(value="/{orderid}",method = RequestMethod.GET)
    public Order getOrder( @PathVariable("productid") String productId,
                           @PathVariable("orderid") String orderId) {
        System.out.println("Inside OrderServiceController --> getOrder()  ++++++: REST Call" + productId);
        return orderService.getOrder(orderId, productId);
    }

    @RequestMapping(value="{orderid}",method = RequestMethod.PUT)
    public void updateOrder( @PathVariable("orderid") String orderId, @RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @RequestMapping(value="{orderid}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder( @PathVariable("orderid") String orderId, @RequestBody Order order) {
        orderService.deleteOrder(order);
    }
}
