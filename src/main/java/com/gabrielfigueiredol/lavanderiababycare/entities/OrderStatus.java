package com.gabrielfigueiredol.lavanderiababycare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_status")
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<Order> orders = new HashSet<>();

    public OrderStatus() {
    }

    public OrderStatus(Integer id) {
        this.id = id;
    }

    public OrderStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonIgnore
    public Set<Order> getOrders() {
        return orders;
    }
}
