package com.project.repository;

import com.project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IOrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Query(value = "insert into order_mart (quantity, product_id, transaction_id) values (:quantity, :product, :transaction)", nativeQuery =true)
    void createOrder(@Param("quantity") int quantity,
                     @Param("product") int product,
                     @Param("transaction") int transaction);

    @Query(value = "select * from order_mart ", nativeQuery =true)
    List<Order> getListOrder();


}
