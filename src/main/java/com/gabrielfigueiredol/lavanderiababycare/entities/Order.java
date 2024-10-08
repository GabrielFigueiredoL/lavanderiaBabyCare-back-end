package com.gabrielfigueiredol.lavanderiababycare.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "client_name")
    private String clientName;
    @Column(name = "client_phone")
    private String clientPhone;

    @Column(name = "pickup_date")
    private LocalDate pickupDate;
    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    private String cep;
    private String address;
    private String district;
    private String number;
    private String complement;

    private Integer shipping;
    private Integer discount;

    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL)
    private Set<OrderItem> selectedItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "status")
    private OrderStatus status;

    public Order(){}

    public Order(String id, String clientName, String clientPhone, LocalDate pickupDate, LocalDate deliveryDate, String cep, String address, String district, String number, String complement, Integer shipping, Integer discount, Integer orderStatusId) {
        this.id = id;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.pickupDate = pickupDate;
        this.deliveryDate = deliveryDate;
        this.cep = cep;
        this.address = address;
        this.district = district;
        this.number = number;
        this.complement = complement;
        this.shipping = shipping;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Set<OrderItem> getSelectedItems() {
        return selectedItems;
    }

    public Integer getItemsTotal() {
        Integer sum = 0;
        for (OrderItem item: selectedItems) {
            sum += item.getSubTotal();
        }

        return sum;
    }

    public Integer getTotal() {
        return getItemsTotal() + getShipping() - getDiscount();
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
