package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.category.CategoryResponse;
import com.czechak.leszek.your_budget.dto.category.CreateCategoryRequest;
import com.czechak.leszek.your_budget.dto.category.GetCategoryResponse;
import com.czechak.leszek.your_budget.repository.category.CategoryRepository;
import com.czechak.leszek.your_budget.model.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private UserContext userContext;


    public void createCategory(CreateCategoryRequest newCategory) {

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setName(newCategory.getName());
        categoryEntity.setDescription(newCategory.getDescription());
        categoryEntity.setUserId(userContext.getCurrentUser().getId());
        categoryRepository.save(categoryEntity);
    }


    public GetCategoryResponse getCategories() {

        List<CategoryEntity> categoryEntitiesByUserId = categoryRepository.findCategoryByUser(userContext.getCurrentUser().getId());

        List<CategoryResponse> categoryResponses = categoryEntitiesByUserId
                .stream()
                .map(x -> {
                    CategoryResponse categoryResponse = new CategoryResponse();
                    categoryResponse.setCategoryId(x.getCategoryId());
                    categoryResponse.setName(x.getName());
                    categoryResponse.setDescription(x.getDescription());
                    return categoryResponse;
                })
                .collect(Collectors.toList());

        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        getCategoryResponse.setCategories(categoryResponses);

        return getCategoryResponse;
    }

    public CategoryEntity getCategory(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findCategoryByCategoryId(categoryId);
        return categoryEntity;
    }

    public CategoryResponse getCategoryResponseById(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findCategoryByCategoryId(categoryId);

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryId(categoryEntity.getCategoryId());
        categoryResponse.setName(categoryEntity.getName());
        categoryResponse.setDescription(categoryEntity.getDescription());

        return categoryResponse;
    }
}
