package com.czechak.leszek.yourbudget.dto.category;

import lombok.Data;

@Data
public class CreateCategoryRequest {

    private String name;
    private String description;

}
