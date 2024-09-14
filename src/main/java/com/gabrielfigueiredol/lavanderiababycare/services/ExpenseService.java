package com.gabrielfigueiredol.lavanderiababycare.services;

import com.gabrielfigueiredol.lavanderiababycare.entities.Expense;
import com.gabrielfigueiredol.lavanderiababycare.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository  expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense insert(Expense expense) {
        String uuid = UUID.randomUUID().toString();
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        expense.setId(uuid);
        expense.setCreatedAt(createdAt);
        return expenseRepository.save(expense);
    }
}
