package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.CreatePurposeRequest;
import com.czechak.leszek.your_budget.model.account.AccountRepository;
import com.czechak.leszek.your_budget.repository.PurposeEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PurposeService {

    AccountRepository accountRepository;
    UserContext userContext;

    public PurposeService(AccountRepository accountRepository, UserContext userContext) {
        this.accountRepository = accountRepository;
        this.userContext = userContext;
    }

    public void createPurpose(CreatePurposeRequest createPurposeRequest) {
        PurposeEntity purposeEntity = new PurposeEntity();

        purposeEntity.setDescription(createPurposeRequest.getDescription());
        purposeEntity.setAmount(BigDecimal.ZERO);
        purposeEntity.setActive(true);
        purposeEntity.setExpense(true);
        purposeEntity.setIsExpensePurposeEntity(true);
        purposeEntity.setCratedOn(LocalDateTime.now());
        purposeEntity.setUpdatedOn(LocalDateTime.now());
        //TODO: Czy faktycznie uzupełniać poniższe?
        purposeEntity.setUserEntity(userContext.getCurrentUser());
        accountRepository.save(purposeEntity);
    }

}

