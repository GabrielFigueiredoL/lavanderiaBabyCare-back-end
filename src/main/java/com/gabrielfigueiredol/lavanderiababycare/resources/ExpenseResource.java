package com.gabrielfigueiredol.lavanderiababycare.resources;

import com.gabrielfigueiredol.lavanderiababycare.entities.Expense;
import com.gabrielfigueiredol.lavanderiababycare.entities.Product;
import com.gabrielfigueiredol.lavanderiababycare.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/expenses")
@CrossOrigin(origins = "*")
public class ExpenseResource {
    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> findAll() {
        List<Expense> expensesList = expenseService.findAll();
        return ResponseEntity.ok().body(expensesList);
    }

    @PostMapping
    public ResponseEntity<Expense> insert(@RequestBody Expense expense) {
        expense = expenseService.insert(expense);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(expense.getId()).toUri();
        return ResponseEntity.created(uri).body(expense);
    }
}
