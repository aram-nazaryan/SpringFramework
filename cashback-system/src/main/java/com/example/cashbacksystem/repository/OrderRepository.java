package com.example.cashbacksystem.repository;

import com.example.cashbacksystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUserUuid(String userUuid);

    @Query("select sum(o.paymentAmount) from Order as o where o.user.uuid = ?1")
    Double getSum(String uuid);

}
