package com.ojan.backend.inventaris.controllers;

import com.ojan.backend.inventaris.dto.CategoryDTO;
import com.ojan.backend.inventaris.models.Category;
import com.ojan.backend.inventaris.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public void createCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.addCategory(categoryDTO);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getCategories();
    }


}
