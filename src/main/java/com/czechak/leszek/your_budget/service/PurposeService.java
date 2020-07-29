package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.purpose.CreatePurposeRequest;
import com.czechak.leszek.your_budget.dto.purpose.EditPurposeRequest;
import com.czechak.leszek.your_budget.dto.purpose.GetPurposesResponse;
import com.czechak.leszek.your_budget.dto.purpose.Purpose;
import com.czechak.leszek.your_budget.model.account.AccountRepository;
import com.czechak.leszek.your_budget.model.purpose.PurposeRepository;
import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.PurposeEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurposeService {

    AccountRepository repository;
    PurposeRepository purposeRepository;
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

    public GetPurposesResponse getAllUserPurposes() {

        List<PurposeEntity> purposeEntityList = purposeRepository.findPurposesByUser(userContext.getCurrentUser().getUserId());

//        List<AccountEntity> accountEntitiesByUserEntity = repository.findAccountEntitiesByUserEntity(userContext.getCurrentUser());
        GetPurposesResponse getPurposesResponse = new GetPurposesResponse();


        getPurposesResponse.setUserPurpose(
               purposeEntityList.stream()
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
        return getPurposesResponse;
    }


    public void editPurpose(EditPurposeRequest purposeRequest) {

        PurposeEntity purposeEntity = purposeRepository.findPurposeById(purposeRequest.getAccountId());
//
//        Optional<AccountEntity> optionalAccountEntity = repository.findById(purposeRequest.getAccountId());
//        AccountEntity accountEntity = optionalAccountEntity.get();

//        PurposeEntity purposeEntity= new PurposeEntity();
        purposeEntity.setAccountId(purposeRequest.getAccountId());
        purposeEntity.setActive(purposeRequest.getActive());
        purposeEntity.setDescription(purposeRequest.getDescription());
        purposeEntity.setAmount(purposeEntity.getAmount());
        purposeEntity.setCratedOn(purposeEntity.getCratedOn());
        purposeEntity.setExpense(true);
        purposeEntity.setUpdatedOn(LocalDateTime.now());
        purposeEntity.setUserEntity(userContext.getCurrentUser());
        repository.save(purposeEntity);

    }

}

