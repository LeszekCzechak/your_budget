package com.czechak.leszek.yourbudget.repository.purpose;

import com.czechak.leszek.yourbudget.model.PurposeEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurposeRepository {

    List<PurposeEntity> findPurposesByUser(@Param("userId") Long userId);

    PurposeEntity findPurposeById(@Param("accountId") Long accountId);

}
