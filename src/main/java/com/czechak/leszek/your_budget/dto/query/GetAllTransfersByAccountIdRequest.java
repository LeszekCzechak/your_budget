package com.czechak.leszek.your_budget.dto.query;


import lombok.Data;

@Data
public class GetAllTransfersByAccountIdRequest {

    private Long accountId;

}
