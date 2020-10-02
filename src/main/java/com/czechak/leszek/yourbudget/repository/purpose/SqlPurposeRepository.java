package com.czechak.leszek.yourbudget.repository.purpose;

import com.czechak.leszek.yourbudget.model.PurposeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SqlPurposeRepository extends PurposeRepository, JpaRepository<PurposeEntity, Long> {

    @Query("select purpose from PurposeEntity purpose where purpose.userEntity.id = :userId" )
    List<PurposeEntity> findPurposesByUser(@Param("userId") Long userId);

    @Query("select purpose from PurposeEntity purpose where purpose.accountId = :accountId" )
    PurposeEntity findPurposeById(@Param("accountId") Long accountId);

}
