package com.czechak.leszek.your_budget.dto.category;

import lombok.Data;

import java.util.List;

@Data
public class GetCategoryResponse {

    List<CategoryResponse> categories;

}
