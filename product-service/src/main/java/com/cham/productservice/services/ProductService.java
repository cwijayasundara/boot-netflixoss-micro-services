package com.cham.productservice.services;

import com.cham.productservice.model.Product;
import com.cham.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(String prodId) {
        return productRepository.findById(prodId);
    }

    public void saveProduct(Product product){
        product.setId( UUID.randomUUID().toString());
        productRepository.save(product);

    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Product product){
        productRepository.delete( product.getId());
    }
}
