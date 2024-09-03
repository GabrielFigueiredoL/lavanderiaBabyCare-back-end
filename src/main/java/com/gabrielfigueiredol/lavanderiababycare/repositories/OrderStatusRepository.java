package com.gabrielfigueiredol.lavanderiababycare.repositories;

import com.gabrielfigueiredol.lavanderiababycare.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
