package com.gabrielfigueiredol.lavanderiababycare.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String client_name;
    private String client_phone;

    private Timestamp pickup_date;
    private Timestamp delivery_date;

    private String cep;
    private String address;
    private String district;
    private String number;
    private String complement;

    private Integer shipping;
    private Integer discount;

    private String status;

    public Order(){}

    public Order(String id, String client_name, String client_phone, Timestamp pickup_date, Timestamp delivery_date, String cep, String address, String district, String number, String complement, Integer shipping, String status, Integer discount) {
        this.id = id;
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.pickup_date = pickup_date;
        this.delivery_date = delivery_date;
        this.cep = cep;
        this.address = address;
        this.district = district;
        this.number = number;
        this.complement = complement;
        this.shipping = shipping;
        this.status = status;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Timestamp getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Timestamp delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Timestamp getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Timestamp pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
