package com.czechak.leszek.your_budget.dto.purpose;

import lombok.Data;

import java.util.List;

@Data
public class GetPurposesResponse {

    List<Purpose> userPurpose;

}
