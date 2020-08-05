package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.purpose.CreatePurposeRequest;
import com.czechak.leszek.your_budget.dto.purpose.EditPurposeRequest;
import com.czechak.leszek.your_budget.dto.purpose.GetPurposesResponse;
import com.czechak.leszek.your_budget.dto.purpose.Purpose;
import com.czechak.leszek.your_budget.model.account.AccountRepository;
import com.czechak.leszek.your_budget.model.category.CategoryRepository;
import com.czechak.leszek.your_budget.model.purpose.PurposeRepository;
import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.CategoryEntity;
import com.czechak.leszek.your_budget.repository.PurposeEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurposeService {

    private final AccountRepository accountRepository;
    private final PurposeRepository purposeRepository;
    private final CategoryRepository categoryRepository;
    private final UserContext userContext;

    public PurposeService(AccountRepository accountRepository, PurposeRepository purposeRepository, CategoryRepository categoryRepository, UserContext userContext) {
        this.accountRepository = accountRepository;
        this.purposeRepository = purposeRepository;
        this.categoryRepository = categoryRepository;
        this.userContext = userContext;
    }

    public void createPurpose(CreatePurposeRequest createPurposeRequest) {

        CategoryEntity category = categoryRepository.findCategoryById(createPurposeRequest.getCategoryId());
        if(category == null){
            //todo dodać defaultową ketegorię i tu ją przypisać.
        }


        PurposeEntity purposeEntity = new PurposeEntity();

        purposeEntity.setDescription(createPurposeRequest.getDescription());
        purposeEntity.setAmount(BigDecimal.ZERO);
        purposeEntity.setActive(true);
        purposeEntity.setExpense(true);
        purposeEntity.setCratedOn(LocalDateTime.now());
        purposeEntity.setUpdatedOn(LocalDateTime.now());
        purposeEntity.setUserEntity(userContext.getCurrentUser());
        purposeEntity.setCategory(category);
        accountRepository.save(purposeEntity);
    }

    public GetPurposesResponse getAllUserPurposes() {

        List<PurposeEntity> purposeEntityList = purposeRepository.findPurposesByUser(userContext.getCurrentUser().getUserId());

        GetPurposesResponse getPurposesResponse = new GetPurposesResponse();


        getPurposesResponse.setUserPurpose(
               purposeEntityList.stream()
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

        purposeEntity.setAccountId(purposeRequest.getAccountId());
        purposeEntity.setActive(purposeRequest.getActive());
        purposeEntity.setDescription(purposeRequest.getDescription());
        purposeEntity.setAmount(purposeEntity.getAmount());
        purposeEntity.setCratedOn(purposeEntity.getCratedOn());
        purposeEntity.setExpense(true);
        purposeEntity.setUpdatedOn(LocalDateTime.now());
        purposeEntity.setUserEntity(userContext.getCurrentUser());
        accountRepository.save(purposeEntity);

    }

}

