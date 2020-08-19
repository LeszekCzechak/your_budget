package com.czechak.leszek.your_budget.repository.purpose;

import com.czechak.leszek.your_budget.model.PurposeEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurposeRepository {

    List<PurposeEntity> findPurposesByUser(@Param("userId") Long userId);

    PurposeEntity findPurposeById(@Param("accountId") Long accountId);

}
