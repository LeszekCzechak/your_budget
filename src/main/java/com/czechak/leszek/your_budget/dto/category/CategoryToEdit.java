package com.czechak.leszek.your_budget.dto.category;


import lombok.Data;

@Data
public class CategoryToEdit {

    private Long categoryId;
    private Long userId;
    private String name;
    private String description;

}
