package com.czechak.leszek.your_budget.model.transfer;

import com.czechak.leszek.your_budget.repository.TransferEntity;

import java.util.List;

public interface TransferRepository {

    TransferEntity save(TransferEntity transferEntity);

    //TODO: sprawdzić co zdziała ta metoda
    List<TransferEntity> getAllTransferByAccountId(Long accountId);

}
