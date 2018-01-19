package com.cham.orders.clients;

import com.cham.orders.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
@Component
public class ProductRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    public Product getProduct(String productId){
        ResponseEntity<Product> restExchange =
                restTemplate.exchange(
                        "http://productservice/v1/products/{productid}",
                        HttpMethod.GET,
                        null, Product.class, productId);

        return restExchange.getBody();
    }
}
