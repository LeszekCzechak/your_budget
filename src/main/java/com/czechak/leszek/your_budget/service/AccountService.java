package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.Account;
import com.czechak.leszek.your_budget.dto.CreateAccountRequest;
import com.czechak.leszek.your_budget.dto.GetAccountsResponse;
import com.czechak.leszek.your_budget.model.account.AccountRepository;
import com.czechak.leszek.your_budget.repository.AccountEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    AccountRepository repository;
    UserContext userContext;

    public AccountService(AccountRepository repository, UserContext userContext) {

        this.repository = repository;
        this.userContext = userContext;
    }

    public void createAccount(CreateAccountRequest requestAccount) {

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setDescription(requestAccount.getDescription());
        accountEntity.setUserEntity(userContext.getCurrentUser());
        accountEntity.setAmount(BigDecimal.ZERO);
        accountEntity.setCratedOn(LocalDateTime.now());
        accountEntity.setUpdatedOn(LocalDateTime.now());
        repository.save(accountEntity);
    }

    @Transactional
    public GetAccountsResponse getAllUserAccounts() {

        List<AccountEntity> accountEntitiesByUserEntity = repository.findAccountEntitiesByUserEntity(userContext.getCurrentUser());

        GetAccountsResponse getAccountsResponse = new GetAccountsResponse();

        getAccountsResponse.setUserAccounts(accountEntitiesByUserEntity
                .stream()
                .map(x -> {
                    Account account = new Account();
                    account.setAccountId(x.getAccountId());
                    account.setAmount(x.getAmount());
                    account.setCratedOn(x.getCratedOn());
                    account.setDescription(x.getDescription());
                    account.setUpdatedOn(x.getUpdatedOn());
                    account.setUserId(x.getUserEntity().getUserId());
                    return account;
                })
        .collect(Collectors.toList()));

        return getAccountsResponse;

    }


}
