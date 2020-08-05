package com.czechak.leszek.your_budget.dto.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryResponse {

    private Long categoryId;
    private String name;
    private String description;

}
