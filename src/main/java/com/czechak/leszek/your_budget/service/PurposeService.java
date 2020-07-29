package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.CreatePurposeRequest;
import com.czechak.leszek.your_budget.dto.GetPurposeResponse;
import com.czechak.leszek.your_budget.dto.Purpose;
import com.czechak.leszek.your_budget.model.account.AccountRepository;
import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.PurposeEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurposeService {

    AccountRepository repository;
    UserContext userContext;

    public PurposeService(AccountRepository repository, UserContext userContext) {
        this.repository = repository;
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
        purposeEntity.setUserEntity(userContext.getCurrentUser());
        repository.save(purposeEntity);
    }

    public GetPurposeResponse getAllUserPurposes() {

        List<AccountEntity> accountEntitiesByUserEntity = repository.findAccountEntitiesByUserEntity(userContext.getCurrentUser());
        GetPurposeResponse getPurposeResponse = new GetPurposeResponse();


        getPurposeResponse.setUserPurpose(
                accountEntitiesByUserEntity.stream()
                        .filter(AccountEntity::getExpense)
                        .filter(AccountEntity::getActive)
                        .map(x -> {
                            Purpose purpose = new Purpose();
                            purpose.setAccountId(x.getAccountId());
                            purpose.setAmount(x.getAmount());
                            purpose.setCreatedOn(x.getCratedOn());
                            purpose.setDescription((x.getDescription()));
                            purpose.setUpdatedOn(x.getUpdatedOn());
                            purpose.setUserId(x.getUserEntity().getUserId());
                            return purpose;
                        })
                        .collect(Collectors.toList())
        );
        return getPurposeResponse;
    }

}

