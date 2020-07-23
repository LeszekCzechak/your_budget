package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.TransferFromAccountRequest;
import com.czechak.leszek.your_budget.model.account.AccountRepository;
import com.czechak.leszek.your_budget.model.transfer.TransferRepository;
import com.czechak.leszek.your_budget.model.user.UserRepository;
import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.TransferEntity;
import com.czechak.leszek.your_budget.repository.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransferService {

    TransferRepository transferRepository;
    UserContext userContext;
    AccountRepository accountRepository;
    UserRepository userRepository;

    public TransferService(TransferRepository transferRepository, UserContext userContext, AccountRepository accountRepository, UserRepository userRepository) {
        this.transferRepository = transferRepository;
        this.userContext = userContext;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    @Transactional // jeżeli któraś z komend się wysypie to wycofa wszystie działania
    public void transferFromAccount(TransferFromAccountRequest transferRequest) {


        Optional<AccountEntity> selectedAccountOptional = accountRepository.findById(transferRequest.getSelectedAccountId());
        AccountEntity sourceAccount = selectedAccountOptional.get();

        Optional<AccountEntity> targetAccountOptional = accountRepository.findById(transferRequest.getTargetAccountId());
        AccountEntity targetAccount = targetAccountOptional.get();

        boolean sameUser= targetAccount.getUserEntity().equals(sourceAccount.getUserEntity());

        boolean enoughCash= (sourceAccount.getAmount()
                .subtract(transferRequest.getAmount()))
                .compareTo(BigDecimal.ZERO)
                >=0;

        if(sameUser && enoughCash){

            TransferEntity transferEntity = new TransferEntity();

            transferCashBetweenAccount(transferRequest, sourceAccount, targetAccount);

            transferEntity.setTransferData(LocalDateTime.now());
            transferEntity.setUserEntity(userContext.getCurrentUser());
            transferEntity.setSelectedAccount(sourceAccount);
            transferEntity.setTargetAccount(targetAccount);
            transferEntity.setAmount(transferRequest.getAmount());
            transferRepository.save(transferEntity);
        }
    }

    private void transferCashBetweenAccount(TransferFromAccountRequest transferRequest, AccountEntity sourceAccount, AccountEntity targetAccount) {
        // zmniejszyć stan na selected account - zaktualizować datę
        sourceAccount.setAmount(sourceAccount.getAmount().subtract(transferRequest.getAmount()));
        sourceAccount.setUpdatedOn(LocalDateTime.now());

        // zwiekszyć stan na targeted account
        targetAccount.setAmount(targetAccount.getAmount().add(transferRequest.getAmount()));
        targetAccount.setUpdatedOn(LocalDateTime.now());
    }

}
