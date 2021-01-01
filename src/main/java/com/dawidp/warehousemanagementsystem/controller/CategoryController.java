package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.exceptions.EmptyFieldException;
import com.dawidp.warehousemanagementsystem.model.Category;
import com.dawidp.warehousemanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("")
    public Category addCategory(@RequestBody Category category) throws EmptyFieldException {
        if (category.getCategoryName() == null) {
            throw new EmptyFieldException("Please provide category name.");
        }
        return service.save(category);
    }

    @GetMapping("")
    public List<Category> getCategories() {
        return service.findAll();
    }

    @GetMapping("/{categoryName}")
    public Category getCategoryByName(@PathVariable String categoryName) {
        return service.findCategoryByName(categoryName);
    }
}
