package com.czechak.leszek.yourbudget.controller;

import com.czechak.leszek.yourbudget.dto.category.CategoryToEdit;
import com.czechak.leszek.yourbudget.dto.category.CreateCategoryRequest;
import com.czechak.leszek.yourbudget.dto.category.GetCategoryResponse;
import com.czechak.leszek.yourbudget.model.CategoryEntity;
import com.czechak.leszek.yourbudget.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
