package com.czechak.leszek.yourbudget.repository.category;

import com.czechak.leszek.yourbudget.model.CategoryEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository {

    List<CategoryEntity> findCategoryByUser(@Param("userId") Long userId);

    CategoryEntity save(CategoryEntity categoryEntity);

    CategoryEntity findCategoryByCategoryId(Long categoryId);
}
