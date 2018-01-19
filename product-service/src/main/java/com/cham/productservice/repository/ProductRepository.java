package com.cham.productservice.repository;

import com.cham.productservice.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product,String> {
    Product findById(String productId);
}