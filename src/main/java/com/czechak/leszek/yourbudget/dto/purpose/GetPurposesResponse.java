package com.czechak.leszek.yourbudget.dto.purpose;

import lombok.Data;

import java.util.List;

@Data
public class GetPurposesResponse {

    List<Purpose> userPurpose;

}
