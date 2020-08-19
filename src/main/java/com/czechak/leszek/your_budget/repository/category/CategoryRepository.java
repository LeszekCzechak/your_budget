package com.czechak.leszek.your_budget.repository.category;

import com.czechak.leszek.your_budget.model.CategoryEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository {

    List<CategoryEntity> findCategoryByUser(@Param("userId") Long userId);

    CategoryEntity save(CategoryEntity categoryEntity);

    CategoryEntity findCategoryByCategoryId(Long categoryId);
}
