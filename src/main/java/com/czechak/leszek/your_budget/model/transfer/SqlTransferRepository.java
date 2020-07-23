package com.czechak.leszek.your_budget.model.transfer;

import com.czechak.leszek.your_budget.repository.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlTransferRepository extends TransferRepository, JpaRepository<TransferEntity, Long> {
}
