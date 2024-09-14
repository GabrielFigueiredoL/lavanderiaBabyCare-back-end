package com.gabrielfigueiredol.lavanderiababycare.repositories;

import com.gabrielfigueiredol.lavanderiababycare.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query("SELECT e FROM Expense e WHERE FUNCTION('MONTH', e.createdAt) = :month AND FUNCTION('YEAR', e.createdAt) = :year")
    List<Expense> findExpensesByMonthAndYear(@Param("month") String month, @Param("year") String year);

}
