package com.czechak.leszek.yourbudget.dto.category;

import lombok.Data;

import java.util.List;

@Data
public class GetCategoryResponse {

    List<CategoryResponse> categories;

}
