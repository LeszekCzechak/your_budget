package com.czechak.leszek.your_budget.model.account;

import com.czechak.leszek.your_budget.repository.AccountEntity;

import java.util.List;

public interface SqlAccountRepositoryCustom {

    List<AccountEntity> getAccountsForUserId(Long id);

}
