package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.category.CreateCategoryRequest;
import com.czechak.leszek.your_budget.model.CategoryEntity;
import com.czechak.leszek.your_budget.model.UserEntity;
import com.czechak.leszek.your_budget.repository.category.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    UserContext userContext;

    CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryService(categoryRepository, userContext);

    }

    @Test
    void ShouldCreateCategory() {

        //given
        CreateCategoryRequest newCategory = new CreateCategoryRequest();
        newCategory.setName("newCategory");
        newCategory.setDescription("desc for test");

        when(userContext.getCurrentUser().getUserId()).thenReturn(1L);

        //when
        categoryService.createCategory(newCategory);

        //then
        ArgumentCaptor<CategoryEntity> argumentCaptor = ArgumentCaptor.forClass(CategoryEntity.class);
        Mockito.verify(categoryRepository).save(argumentCaptor.capture());
        CategoryEntity categoryEntity = argumentCaptor.capture();

        assertEquals("newCategory", categoryEntity.getName());
        assertEquals("desc for test", categoryEntity.getDescription());
        assertEquals(1L, categoryEntity.getUserId());
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