package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.category.CategoryResponse;
import com.czechak.leszek.your_budget.dto.category.CategoryToEdit;
import com.czechak.leszek.your_budget.dto.category.CreateCategoryRequest;
import com.czechak.leszek.your_budget.dto.category.GetCategoryResponse;
import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.CategoryEntity;
import com.czechak.leszek.your_budget.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<Void> createCategory (@RequestBody CreateCategoryRequest newCategory){
       categoryService.createCategory(newCategory);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/category")
    public ResponseEntity<GetCategoryResponse> getCetegories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.getCategory(categoryId));

    }

    @PutMapping("/category")
    public ResponseEntity<Void> editCetegory(@RequestBody CategoryToEdit newCategory){
        //TODO dopisać metodę do edytowania
        return ResponseEntity.ok(null);
    }

}
