package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.CategoryRepository;
import com.dawidp.warehousemanagementsystem.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Category save(Category category) {
        return repository.save(category);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findCategoryByName(String categoryName) {
        return repository.findCategoryByCategoryName(categoryName);
    }
}
