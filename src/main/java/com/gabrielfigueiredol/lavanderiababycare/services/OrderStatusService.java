package com.gabrielfigueiredol.lavanderiababycare.services;

import com.gabrielfigueiredol.lavanderiababycare.entities.OrderStatus;
import com.gabrielfigueiredol.lavanderiababycare.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public List<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }

    public OrderStatus getOrderStatusById(Integer id) {
        return orderStatusRepository.findById(id).orElseThrow(() -> new RuntimeException("Status de serviço não encontrado"));
    }
}
