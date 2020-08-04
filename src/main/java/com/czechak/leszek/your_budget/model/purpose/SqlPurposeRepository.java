package com.czechak.leszek.your_budget.model.purpose;

import com.czechak.leszek.your_budget.repository.PurposeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SqlPurposeRepository extends PurposeRepository, JpaRepository<PurposeEntity, Long> {

    @Query("select purpose from PurposeEntity purpose where purpose.userEntity.userId = :userId" )
    List<PurposeEntity> findPurposesByUser(@Param("userId") Long userId);

    @Query("select purpose from PurposeEntity purpose where purpose.accountId = :accountId" )
    PurposeEntity findPurposeById(@Param("accountId") Long accountId);

}
