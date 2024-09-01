package com.gabrielfigueiredol.lavanderiababycare.repositories;

import com.gabrielfigueiredol.lavanderiababycare.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
