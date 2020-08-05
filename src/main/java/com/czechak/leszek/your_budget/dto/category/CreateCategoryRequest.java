package com.czechak.leszek.your_budget.dto.category;

import lombok.Data;

@Data
public class CreateCategoryRequest {

    private String name;
    private String description;

}
