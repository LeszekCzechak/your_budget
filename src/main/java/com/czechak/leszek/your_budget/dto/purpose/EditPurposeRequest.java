package com.czechak.leszek.your_budget.dto.purpose;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
public class EditPurposeRequest {


    private Long accountId;
    @NaturalId
    private String description;
    private Boolean active;

}
