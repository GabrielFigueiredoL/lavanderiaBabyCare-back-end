package com.gabrielfigueiredol.lavanderiababycare.repositories;

import com.gabrielfigueiredol.lavanderiababycare.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByStatusId(Integer id);

    @Query("SELECT o FROM Order o WHERE o.pickupDate = :currentDate OR o.deliveryDate = :currentDate")
    List<Order> findDailyOrders(@Param("currentDate") LocalDate currentDate);

    @Query("SELECT o FROM Order o WHERE (FUNCTION('MONTH', o.deliveryDate) = :month AND FUNCTION('YEAR', o.deliveryDate) = :year)")
    List<Order> findOrdersByMonthAndYear(@Param("month") String month, @Param("year") String year);
}
