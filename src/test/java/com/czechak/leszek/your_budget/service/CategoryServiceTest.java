package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.repository.category.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UserContext userContext;

    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryService(categoryRepository,userContext);
    }

    @Test
    void ShouldCreateCategory() {

    }

    @Test
    void getCategories() {
    }

    @Test
    void getCategory() {
    }

    @Test
    void getCategoryResponseById() {
    }
}