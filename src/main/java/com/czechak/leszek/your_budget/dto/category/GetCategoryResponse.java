package com.czechak.leszek.your_budget.dto.category;

import com.czechak.leszek.your_budget.repository.CategoryEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetCategoryResponse {

    List<CategoryResponse> categories;

}
