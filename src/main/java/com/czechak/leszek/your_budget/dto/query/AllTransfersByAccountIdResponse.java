package com.czechak.leszek.your_budget.dto.query;

import lombok.Data;

import java.util.List;


@Data
public class AllTransfersByAccountIdResponse {

    List<AllTransfersByAccountId> transferEntities;


}
