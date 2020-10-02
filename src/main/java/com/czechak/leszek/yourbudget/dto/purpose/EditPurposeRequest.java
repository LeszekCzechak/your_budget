package com.czechak.leszek.yourbudget.dto.purpose;

import lombok.Data;

@Data
public class EditPurposeRequest {

    private Long accountId;
    private String description;
    private Boolean active;
    private Long categoryId;

}
