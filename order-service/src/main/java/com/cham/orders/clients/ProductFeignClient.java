package com.cham.orders.clients;

import com.cham.orders.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cwijayasundara on 27/01/2017.
 */

@FeignClient("productservice")
public interface ProductFeignClient {
    @RequestMapping(
            method= RequestMethod.GET,
            value="/v1/products/{productid}",
            consumes="application/json")
    Product getProduct(@PathVariable("productid") String productId);
}