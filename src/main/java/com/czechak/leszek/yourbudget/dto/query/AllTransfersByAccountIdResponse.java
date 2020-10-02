package com.czechak.leszek.yourbudget.dto.query;

import lombok.Data;

import java.util.List;


@Data
public class AllTransfersByAccountIdResponse {

    List<AllTransfersByAccountId> transferEntities;


}
