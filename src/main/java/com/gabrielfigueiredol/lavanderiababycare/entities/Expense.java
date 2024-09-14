package com.gabrielfigueiredol.lavanderiababycare.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "expense")
public class Expense implements Serializable {
    @Id
    private String id;
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Expense() {};

    public Expense(String id, Integer price, Timestamp createdAt, String description, Category category) {
        this.id = id;
        this.price = price;
        this.createdAt = createdAt;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
