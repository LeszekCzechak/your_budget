package com.czechak.leszek.your_budget.dto.category;

import lombok.Data;

@Data
public class CategoryResponse {

    private Long categoryId;
    private String name;
    private String description;

}
