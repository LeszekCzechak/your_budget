package com.czechak.leszek.your_budget.model.category;

import com.czechak.leszek.your_budget.repository.CategoryEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository {

    List<CategoryEntity> findCategoryByUser(@Param("userId") Long userId);

    CategoryEntity save(CategoryEntity categoryEntity);

    CategoryEntity findCategoryById(Long categoryId);
}
