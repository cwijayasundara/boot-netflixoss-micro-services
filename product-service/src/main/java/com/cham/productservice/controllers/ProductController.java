package com.cham.productservice.controllers;

import com.cham.productservice.model.Product;
import com.cham.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
@RestController
@RequestMapping(value="v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/{productid}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("productid") String productId) {
        System.out.println("inside the ProductService.getProduct()" + productId + "*****");
        return productService.getProduct(productId);
    }

    @RequestMapping(value="/{productid}",method = RequestMethod.PUT)
    public void updateProduct( @PathVariable("productid") String productId, @RequestBody Product product) {
        productService.updateProduct(product);
    }

    @RequestMapping(value="/{productid}",method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @RequestMapping(value="/{productid}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct( @PathVariable("productid") String productid,  @RequestBody Product product) {
        productService.deleteProduct( product );
    }
}
