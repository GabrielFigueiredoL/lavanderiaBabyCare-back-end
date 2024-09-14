package com.gabrielfigueiredol.lavanderiababycare.services;

import com.gabrielfigueiredol.lavanderiababycare.entities.Category;
import com.gabrielfigueiredol.lavanderiababycare.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}