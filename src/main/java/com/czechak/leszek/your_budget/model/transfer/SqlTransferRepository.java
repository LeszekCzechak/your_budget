package com.czechak.leszek.your_budget.model.transfer;

import com.czechak.leszek.your_budget.repository.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTransferRepository extends TransferRepository, JpaRepository<TransferEntity, Long> {

    @Query("SELECT transfer FROM TransferEntity transfer WHERE transfer.selectedAccount = :accountId OR transfer.targetAccount = :accountId")
    List<TransferEntity> getAllTransferByAccountId(Long accountId);

}
