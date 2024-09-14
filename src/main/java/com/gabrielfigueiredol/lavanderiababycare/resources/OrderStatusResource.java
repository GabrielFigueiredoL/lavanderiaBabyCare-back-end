package com.gabrielfigueiredol.lavanderiababycare.resources;

import com.gabrielfigueiredol.lavanderiababycare.entities.OrderStatus;
import com.gabrielfigueiredol.lavanderiababycare.services.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order-status")
@CrossOrigin(origins = "*")
public class OrderStatusResource {
    @Autowired
    private OrderStatusService orderStatus;

    @GetMapping
    public ResponseEntity<List<OrderStatus>> findAll() {
        List<OrderStatus> orderStatusList = orderStatus.findAll();
        return ResponseEntity.ok().body(orderStatusList);
    }
}
