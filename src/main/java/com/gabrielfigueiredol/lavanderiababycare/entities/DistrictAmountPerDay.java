package com.gabrielfigueiredol.lavanderiababycare.entities;

import java.io.Serializable;
import java.util.Objects;

public class DistrictAmountPerDay implements Serializable {
    private String district;
    private Integer amount;

    public DistrictAmountPerDay() {}

    public DistrictAmountPerDay(String district, Integer amount) {
        this.amount = amount;
        this.district = district;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictAmountPerDay that = (DistrictAmountPerDay) o;
        return Objects.equals(amount, that.amount) && Objects.equals(district, that.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, district);
    }
}
