package com.czechak.leszek.your_budget.dto.purpose;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
public class EditPurposeRequest {

    private Long accountId;
    private String description;
    private Boolean active;
    private Long categoryId;

}
