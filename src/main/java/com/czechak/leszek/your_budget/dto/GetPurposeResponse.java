package com.czechak.leszek.your_budget.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetPurposeResponse {

    List<Purpose> userPurpose;

}
