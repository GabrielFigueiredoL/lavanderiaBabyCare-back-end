package com.gabrielfigueiredol.lavanderiababycare.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MonthMetrics implements Serializable {
    private String id;
    private Integer totalOrders;
    private Integer revenues;
    private List<Expense> expenses = new ArrayList<>();

    public MonthMetrics() {
    }

    public MonthMetrics(String id, Integer totalOrders, Integer revenues) {
        this.id = id;
        this.totalOrders = totalOrders;
        this.revenues = revenues;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Integer getRevenues() {
        return revenues;
    }

    public void setRevenues(Integer revenues) {
        this.revenues = revenues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthMetrics that = (MonthMetrics) o;
        return Objects.equals(id, that.id) && Objects.equals(totalOrders, that.totalOrders) && Objects.equals(revenues, that.revenues) && Objects.equals(expenses, that.expenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalOrders, revenues, expenses);
    }
}
