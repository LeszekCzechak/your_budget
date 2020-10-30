package com.czechak.leszek.yourbudget.dto.transfers;

import lombok.Data;

import java.util.List;


@Data
public class AllTransfersByAccountIdResponse {

    List<AllTransfersByAccountId> transferEntities;


}
