package com.czechak.leszek.your_budget.dto.purpose;

import com.czechak.leszek.your_budget.dto.category.CategoryResponse;
import com.czechak.leszek.your_budget.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purpose {

    private Long accountId;
    private Long userId;
    private String description;
    private BigDecimal amount;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private CategoryResponse categoryResponse;
    private Currency currency;

}
