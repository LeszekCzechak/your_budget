package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.CreatePurposeRequest;
import com.czechak.leszek.your_budget.model.account.AccountRepository;
import com.czechak.leszek.your_budget.repository.ExpensePurposeEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurposeService {

    AccountRepository accountRepository;
    UserContext userContext;

    public PurposeService(AccountRepository accountRepository, UserContext userContext) {
        this.accountRepository = accountRepository;
        this.userContext = userContext;
    }

    public void createPurpose(CreatePurposeRequest createPurposeRequest) {
        ExpensePurposeEntity expensePurposeEntity = new ExpensePurposeEntity();

        expensePurposeEntity.setDescription(createPurposeRequest.getDescription());
        expensePurposeEntity.setAmount(BigDecimal.ZERO);
        expensePurposeEntity.setActive(true);
        expensePurposeEntity.setExpense(true);
        expensePurposeEntity.setIsExpensePurposeEntity(true);
        expensePurposeEntity.setCratedOn(LocalDateTime.now());
        expensePurposeEntity.setUpdatedOn(LocalDateTime.now());
        //TODO: Czy faktycznie uzupełniać poniższe?
        expensePurposeEntity.setUserEntity(userContext.getCurrentUser());
        accountRepository.save(expensePurposeEntity);
    }

}

