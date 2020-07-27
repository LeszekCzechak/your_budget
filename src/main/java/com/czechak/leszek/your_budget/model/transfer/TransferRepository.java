package com.czechak.leszek.your_budget.model.transfer;

import com.czechak.leszek.your_budget.repository.TransferEntity;

public interface  TransferRepository {

    TransferEntity save(TransferEntity transferEntity);
}
