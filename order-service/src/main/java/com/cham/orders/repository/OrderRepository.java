package com.cham.orders.repository;

import com.cham.orders.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cwijayasundara on 26/01/2017.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order,String> {
    List<Order> findByProductId(String productId);
    Order findByOrderIdAndProductId(String orderId,String productId);
}
