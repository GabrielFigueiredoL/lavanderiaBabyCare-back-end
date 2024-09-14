package com.gabrielfigueiredol.lavanderiababycare.services;

import com.gabrielfigueiredol.lavanderiababycare.entities.*;
import com.gabrielfigueiredol.lavanderiababycare.exceptions.OrderNotFoundException;
import com.gabrielfigueiredol.lavanderiababycare.repositories.ExpenseRepository;
import com.gabrielfigueiredol.lavanderiababycare.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusService orderStatus;

    @Autowired
    private ExpenseRepository expenseRepository;

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

    public MonthMetrics MonthFinancesOverview(String month, String year) {
        List<Order> monthOrders = orderRepository.findOrdersByMonthAndYear(month, year);
        MonthMetrics monthMetrics = new MonthMetrics();
        monthMetrics.setId(month + "/" + year);
        monthMetrics.setTotalOrders(monthOrders.size());
        Integer revenues = 0;
        Integer expenses = 0;
        for (Order order : monthOrders) {
            revenues +=order.getTotal();
        }
        monthMetrics.setRevenues(revenues);
        monthMetrics.setExpenses(expenseRepository.findExpensesByMonthAndYear(month, year));
        return monthMetrics;
    }

    public Map<String, List<DistrictAmountPerDay>> findDistrictAmountPerDay() {
        List<Order> dailyOrders = orderRepository.findDailyOrders(LocalDate.now());

        List<Order> deliveryOrders = dailyOrders.stream()
                .filter(order -> order.getDeliveryDate() != null && order.getDeliveryDate().isEqual(LocalDate.now()))
                .collect(Collectors.toList());

        List<Order> pickupOrders = dailyOrders.stream()
                .filter(order -> order.getPickupDate() != null && order.getPickupDate().isEqual(LocalDate.now()))
                .collect(Collectors.toList());

        Map<String, Long> deliveryAddressCountMap = deliveryOrders.stream()
                .collect(Collectors.groupingBy(Order::getDistrict, Collectors.counting()));

        Map<String, Long> pickupAddressCountMap = pickupOrders.stream()
                .collect(Collectors.groupingBy(Order::getDistrict, Collectors.counting()));

        List<DistrictAmountPerDay> deliveryDistrictAmountPerDayList = deliveryAddressCountMap.entrySet().stream()
                .map(entry -> new DistrictAmountPerDay(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());

        List<DistrictAmountPerDay> pickupDistrictAmountPerDayList = pickupAddressCountMap.entrySet().stream()
                .map(entry -> new DistrictAmountPerDay(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());

        return Map.of(
                "deliveryOrders", deliveryDistrictAmountPerDayList,
                "pickupOrders", pickupDistrictAmountPerDayList
        );
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
