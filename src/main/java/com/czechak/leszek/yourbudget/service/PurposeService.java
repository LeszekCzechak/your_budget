package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.dto.purpose.CreatePurposeRequest;
import com.czechak.leszek.yourbudget.dto.purpose.EditPurposeRequest;
import com.czechak.leszek.yourbudget.dto.purpose.GetPurposesResponse;
import com.czechak.leszek.yourbudget.dto.purpose.Purpose;
import com.czechak.leszek.yourbudget.repository.account.AccountRepository;
import com.czechak.leszek.yourbudget.repository.category.CategoryRepository;
import com.czechak.leszek.yourbudget.repository.purpose.PurposeRepository;
import com.czechak.leszek.yourbudget.model.AccountEntity;
import com.czechak.leszek.yourbudget.model.CategoryEntity;
import com.czechak.leszek.yourbudget.model.PurposeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PurposeService {

    private AccountRepository accountRepository;
    private PurposeRepository purposeRepository;
    private CategoryRepository categoryRepository;
    private UserContext userContext;
    private CategoryService categoryService;


    public void createPurpose(CreatePurposeRequest createPurposeRequest) {

        CategoryEntity category = categoryRepository.findCategoryByCategoryId(createPurposeRequest.getCategoryId());
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
        purposeEntity.setCurrency(createPurposeRequest.getCurrency());
        accountRepository.save(purposeEntity);
    }

    public GetPurposesResponse getAllUserPurposes() {

        List<PurposeEntity> purposeEntityList = purposeRepository.findPurposesByUser(userContext.getCurrentUser().getId());

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
                            purpose.setUserId(x.getUserEntity().getId());
                            purpose.setCategoryResponse(categoryService.getCategoryResponseById(x.getCategory().getCategoryId()));
                            purpose.setCurrency(x.getCurrency());
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
        purposeEntity.setCategory(categoryService.getCategory(purposeRequest.getCategoryId()));
        accountRepository.save(purposeEntity);

    }

}

