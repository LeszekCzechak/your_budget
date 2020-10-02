package com.czechak.leszek.yourbudget.repository.transfer;

import com.czechak.leszek.yourbudget.model.TransferEntity;

import java.util.List;

public interface TransferRepository {

    TransferEntity save(TransferEntity transferEntity);

    List<TransferEntity> getAllTransferByAccountId(Long accountId);

}
