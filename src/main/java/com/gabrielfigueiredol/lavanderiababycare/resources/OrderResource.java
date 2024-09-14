package com.gabrielfigueiredol.lavanderiababycare.resources;

import com.gabrielfigueiredol.lavanderiababycare.entities.DistrictAmountPerDay;
import com.gabrielfigueiredol.lavanderiababycare.entities.MonthMetrics;
import com.gabrielfigueiredol.lavanderiababycare.entities.Order;
import com.gabrielfigueiredol.lavanderiababycare.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
@CrossOrigin(origins = "*")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orderList = orderService.findAll();
        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @GetMapping(value = "/daily-orders")
    public ResponseEntity<List<Order>> findDailyOrders() {
        List<Order> filteredOrderList = orderService.findDailyOrders();
        return ResponseEntity.ok().body(filteredOrderList);
    }

    @GetMapping(value = "/finances/{monthAndYear}")
    public ResponseEntity<MonthMetrics> MonthFinancesOverview(@PathVariable String monthAndYear) {
        String [] date = monthAndYear.split("-");

        return ResponseEntity.ok().body(orderService.MonthFinancesOverview(date[0], date[1]));
    }

    @GetMapping(value = "/status/{id}")
    public ResponseEntity<List<Order>> findByStatusId(@PathVariable Integer id) {
        List<Order> filteredOrderList = orderService.findByStatusId(id);
        return ResponseEntity.ok().body(filteredOrderList);
    }

    @GetMapping(value = "/daily-orders/districts")
    public ResponseEntity<Map<String, List<DistrictAmountPerDay>>> findDistrictAmountPerDay() {
        Map<String, List<DistrictAmountPerDay>> filteredList = orderService.findDistrictAmountPerDay();
        return ResponseEntity.ok().body(filteredList);
    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order order) {
        order = orderService.insert(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Order> update(@PathVariable String id, @RequestBody Order order){
        order = orderService.update(id, order);
        return ResponseEntity.ok().body(order);
    }
}
