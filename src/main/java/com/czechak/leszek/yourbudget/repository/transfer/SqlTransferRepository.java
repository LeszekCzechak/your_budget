package com.czechak.leszek.yourbudget.repository.transfer;

import com.czechak.leszek.yourbudget.model.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTransferRepository extends TransferRepository, JpaRepository<TransferEntity, Long> {

    @Query("SELECT transfer FROM TransferEntity transfer WHERE transfer.selectedAccount.accountId = :accountId OR transfer.targetAccount.accountId = :accountId")
    List<TransferEntity> getAllTransferByAccountId(@Param("accountId")Long accountId);

}
