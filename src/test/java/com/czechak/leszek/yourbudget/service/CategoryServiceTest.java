package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.dto.category.CategoryResponse;
import com.czechak.leszek.yourbudget.dto.category.CreateCategoryRequest;
import com.czechak.leszek.yourbudget.dto.category.GetCategoryResponse;
import com.czechak.leszek.yourbudget.model.CategoryEntity;
import com.czechak.leszek.yourbudget.model.UserEntity;
import com.czechak.leszek.yourbudget.repository.category.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        categoryService = new CategoryService(categoryRepository,userContext);

    }

    @Test
    void shouldCreateCategory() {

        //given
        CreateCategoryRequest newCategory = new CreateCategoryRequest();
        newCategory.setName("newCategory");
        newCategory.setDescription("desc for test");

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        when(userContext.getCurrentUser()).thenReturn(userEntity);

        //when
        categoryService.createCategory(newCategory);

        //then
        ArgumentCaptor<CategoryEntity> argumentCaptor = ArgumentCaptor.forClass(CategoryEntity.class);
        Mockito.verify(categoryRepository).save(argumentCaptor.capture());
        CategoryEntity categoryEntity = argumentCaptor.getValue();

        assertEquals("newCategory", categoryEntity.getName());
        assertEquals("desc for test", categoryEntity.getDescription());
        assertEquals(1L, categoryEntity.getUserId());
    }

    @Test
    void shouldReturnAllCategories() {

        //given
        List<CategoryEntity> categoryEntities = new LinkedList<>();
        CategoryEntity categoryEntity = new CategoryEntity(1L, 1L, "CategoryName", "CategoryDesc");
        categoryEntities.add(categoryEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        when(userContext.getCurrentUser()).thenReturn(userEntity);
        when(categoryRepository.findCategoryByUser(1L)).thenReturn(categoryEntities);

        //when
        GetCategoryResponse categories = categoryService.getCategories();

        //then
        assertEquals(1, categories.getCategories().size());
        assertEquals(1L, categories.getCategories().get(0).getCategoryId());
        assertEquals("CategoryName", categories.getCategories().get(0).getName());
        assertEquals("CategoryDesc", categories.getCategories().get(0).getDescription());

    }

    @Test
    void shouldReturnCategoryByCategoryId() {
        //given
        CategoryEntity categoryEntity = new CategoryEntity(1L, 3L,"CategoryName","CategoryDesc");

        when(categoryRepository.findCategoryByCategoryId(1L)).thenReturn(categoryEntity);

        //when
        CategoryEntity category = categoryService.getCategory(1L);

        //then
        assertEquals(1L, category.getCategoryId());
        assertEquals(3L, category.getUserId());
        assertEquals("CategoryName", category.getName());
        assertEquals("CategoryDesc", category.getDescription());

    }

    @Test
    void getCategoryResponseById() {
        //given
        CategoryEntity categoryEntity = new CategoryEntity(1L,3L,"CategoryName","CategoryDesc");

        when(categoryRepository.findCategoryByCategoryId(1L)).thenReturn(categoryEntity);

        //when
        CategoryResponse category = categoryService.getCategoryResponseById(1L);

        //then
        assertEquals(1L, category.getCategoryId());
        assertEquals("CategoryName", category.getName());
        assertEquals("CategoryDesc", category.getDescription());

    }
}
