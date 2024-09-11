package com.gabrielfigueiredol.lavanderiababycare.services;

import com.gabrielfigueiredol.lavanderiababycare.entities.Order;
import com.gabrielfigueiredol.lavanderiababycare.entities.OrderItem;
import com.gabrielfigueiredol.lavanderiababycare.exceptions.OrderNotFoundException;
import com.gabrielfigueiredol.lavanderiababycare.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusService orderStatus;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByStatusId(Integer id) {
        return orderRepository.findByStatusId(id);
    }

    public Optional<Order> findById(String id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException();
        }
        return orderRepository.findById(id);
    }

    public List<Order> findDailyOrders() {
        LocalDate today = LocalDate.now();
        return orderRepository.findDailyOrders(today);
    }

    public Order insert(Order order) {
        String uuid = UUID.randomUUID().toString();
        Timestamp updated_at = new Timestamp(System.currentTimeMillis());
        order.setId(uuid);
        for (OrderItem item : order.getSelectedItems()) {
            item.setOrder(order);
        }

        return orderRepository.save(order);
    }

    public void delete(String id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException();
        }
        orderRepository.deleteById(id);
    }

    public Order update(String id, Order order) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException();
        }
        Order orderReference = orderRepository.getReferenceById(id);
        updateData(orderReference, order);
        return orderRepository.save(orderReference);
    }

    public void updateData(Order orderReference, Order order) {
        orderReference.setClientName(order.getClientName());
        orderReference.setClientPhone(order.getClientPhone());
        orderReference.setPickupDate(order.getPickupDate());
        orderReference.setDeliveryDate(order.getDeliveryDate());
        orderReference.setCep(order.getCep());
        orderReference.setAddress(order.getAddress());
        orderReference.setDistrict(order.getDistrict());
        orderReference.setNumber(order.getNumber());
        orderReference.setComplement(order.getComplement());
        orderReference.setShipping(order.getShipping());
        orderReference.setDiscount(order.getDiscount());
        orderReference.setStatus(order.getStatus());
    }
}
