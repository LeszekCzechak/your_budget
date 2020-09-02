package com.czechak.leszek.your_budget.repository.transfer;

import com.czechak.leszek.your_budget.model.TransferEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferRepository {

    TransferEntity save(TransferEntity transferEntity);

    List<TransferEntity> getAllTransferByAccountId(Long accountId);

}
