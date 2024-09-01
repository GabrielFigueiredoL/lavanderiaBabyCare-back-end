package com.gabrielfigueiredol.lavanderiababycare.services;

import com.gabrielfigueiredol.lavanderiababycare.entities.Product;
import com.gabrielfigueiredol.lavanderiababycare.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public Product insert(Product product) {
            String uuid = UUID.randomUUID().toString();
            Timestamp updated_at = new Timestamp(System.currentTimeMillis());
            product.setId(uuid);
            product.setUpdated_at(updated_at);
            return productRepository.save(product);
    }

    public Product update(String id, Product product) {
        Product productReference = productRepository.getReferenceById(id);
        updateData(productReference, product);
        return productRepository.save(productReference);
    }

    public void updateData(Product productReference, Product product) {
        productReference.setName(product.getName());
        productReference.setPrice(product.getPrice());
        productReference.setUpdated_at(new Timestamp(System.currentTimeMillis()));
    }
}
