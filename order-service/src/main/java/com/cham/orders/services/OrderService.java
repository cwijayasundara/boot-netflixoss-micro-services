package com.cham.orders.services;

import com.cham.orders.clients.ProductFeignClient;
import com.cham.orders.clients.ProductRestTemplateClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.cham.orders.model.Order;
import com.cham.orders.model.Product;
import com.cham.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /*@Autowired
    ServiceConfig config;*/

    @Autowired
    private ProductRestTemplateClient productRestTemplateClient;

    @Autowired
    private ProductFeignClient productFeignClient;

    public Order getOrder(String orderId, String productId) {
        Order order = orderRepository.findByOrderIdAndProductId(orderId, productId);

        Product prod = getProduct(productId);
        // set 2 values from the rest call others from the DB
        if (prod != null) {
            order.withProductId(prod.getId())
                    .withProductName(prod.getName());
        }
        return order;
    }

    @HystrixCommand
    private Product getProduct(String productId) {
        System.out.println("REST Call to the product service..");
        //return productRestTemplateClient.getProduct(productId);
        return productFeignClient.getProduct(productId);
    }

    private void randomlyRunLong(){
        Random rand = new Random();

        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        if (randomNum==3) sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @HystrixCommand(fallbackMethod = "buildFallbackOrderList",
            threadPoolKey = "licenseByOrgThreadPool",
            threadPoolProperties =
                    {@HystrixProperty(name = "coreSize",value="30"),
                            @HystrixProperty(name="maxQueueSize", value="10")},
            commandProperties={
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
                    @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),
                    @HystrixProperty(name="metrics.rollingStats.numBuckets", value="5")}
    )
    public List<Order> getOrdersByProduct(String productId){
        randomlyRunLong();
        return orderRepository.findByProductId(productId);
    }

    private List<Order> buildFallbackOrderList(String orderId){
        List<Order> fallbackList = new ArrayList<>();
        Order order = new Order()
                .withOrderId("ord-xxx")
                .withProductId("prod-xx" )
                .withProductName("Sorry no product information currently available");

        fallbackList.add(order);
        return fallbackList;
    }

    public void saveOrder(Order order){
        order.withOrderId( UUID.randomUUID().toString());

        orderRepository.save(order);
    }

    public void updateOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(Order order){
        orderRepository.delete(order.getOrderId());
    }
}
