package com.ojan.backend.inventaris.services;

import com.ojan.backend.inventaris.dto.CategoryDTO;
import com.ojan.backend.inventaris.models.Category;
import com.ojan.backend.inventaris.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id " + id + " not found")
        );
    }

    public void addCategory(CategoryDTO categoryDTO){
        categoryRepo.save(Category.builder().name(categoryDTO.name()).build());
    }
}
