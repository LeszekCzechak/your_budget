package com.czechak.leszek.your_budget.dto.query;

import com.czechak.leszek.your_budget.repository.TransferEntity;
import lombok.Data;

import java.util.List;


@Data
public class AllTransfersByAccountIdResponse {

    List<AllTransfersByAccountId> transferEntities;


}
