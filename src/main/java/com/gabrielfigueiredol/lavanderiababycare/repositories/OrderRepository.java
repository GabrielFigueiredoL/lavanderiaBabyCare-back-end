package com.gabrielfigueiredol.lavanderiababycare.repositories;

import com.gabrielfigueiredol.lavanderiababycare.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByStatusId(Integer id);
}
