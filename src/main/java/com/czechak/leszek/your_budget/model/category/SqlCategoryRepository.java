package com.czechak.leszek.your_budget.model.category;

import com.czechak.leszek.your_budget.repository.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SqlCategoryRepository extends CategoryRepository, JpaRepository<CategoryEntity, Long> {

    @Query("select category from CategoryEntity category where category.userId = :userId" )
    List<CategoryEntity> findCategoryByUser(@Param("userId") Long userId);

    CategoryEntity findCategoryByCategoryId(Long categoryId);

}
