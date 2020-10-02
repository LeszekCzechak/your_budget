package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.dto.account.PaymentOnAccountRequest;
import com.czechak.leszek.yourbudget.dto.purpose.SpendOnPurposeRequest;
import com.czechak.leszek.yourbudget.dto.account.TransferFromAccountRequest;
import com.czechak.leszek.yourbudget.exception.PurposeException;
import com.czechak.leszek.yourbudget.repository.account.AccountRepository;
import com.czechak.leszek.yourbudget.repository.transfer.TransferRepository;
import com.czechak.leszek.yourbudget.repository.user.UserRepository;
import com.czechak.leszek.yourbudget.model.AccountEntity;
import com.czechak.leszek.yourbudget.model.PurposeEntity;
import com.czechak.leszek.yourbudget.model.TransferEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final UserContext userContext;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CurrencyExchangeService currencyExchangeService;

    public TransferService(TransferRepository transferRepository, UserContext userContext, AccountRepository accountRepository, UserRepository userRepository, CurrencyExchangeService currencyExchangeService) {
        this.transferRepository = transferRepository;
        this.userContext = userContext;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.currencyExchangeService = currencyExchangeService;
    }

    @Transactional
    public void transferFromAccount(TransferFromAccountRequest transferRequest) {


        Optional<AccountEntity> selectedAccountOptional = accountRepository.findById(transferRequest.getSelectedAccountId());
        AccountEntity sourceAccount = selectedAccountOptional.get();

        Optional<AccountEntity> targetAccountOptional = accountRepository.findById(transferRequest.getTargetAccountId());
        AccountEntity targetAccount = targetAccountOptional.get();

        if (sourceAccount instanceof PurposeEntity) {
            throw new PurposeException("Can't transfer from that account");
        }

        boolean sameUser = targetAccount.getUserEntity().equals(sourceAccount.getUserEntity());

        boolean enoughCash = (sourceAccount.getAmount()
                .subtract(transferRequest.getAmount()))
                .compareTo(BigDecimal.ZERO)
                >= 0;

        boolean sourceAccountActive = sourceAccount.getActive();
        boolean targetAccountActive = targetAccount.getActive();
        boolean sameCurrency = sourceAccount.getCurrency().equals(targetAccount.getCurrency());

        BigDecimal amountToTransfer= transferRequest.getAmount();

        if (!sameCurrency){
            amountToTransfer= currencyExchangeService.exchangeCurrencyDuringTransfer(sourceAccount.getCurrency()
                    ,targetAccount.getCurrency()
                    , amountToTransfer);
        }

        if (sameUser
                && enoughCash
                && sourceAccountActive
                && targetAccountActive
                ) {

            TransferEntity transferEntity = new TransferEntity();

            transferCashBetweenAccount(amountToTransfer,transferRequest,sourceAccount,targetAccount);

            transferEntity.setTransferData(LocalDateTime.now());
            transferEntity.setUserEntity(userContext.getCurrentUser());
            transferEntity.setSelectedAccount(sourceAccount);
            transferEntity.setTargetAccount(targetAccount);
            transferEntity.setAmount(transferRequest.getAmount());
            transferEntity.setDescription(transferRequest.getDescription());
            transferRepository.save(transferEntity);
        }
    }

    @Transactional
    public void SpendOnPurpose(SpendOnPurposeRequest spendOnPurposeRequest) {

        Optional<AccountEntity> sourceAccountOptional = accountRepository.findById(spendOnPurposeRequest.getSourceAccountId());
        AccountEntity sourceAccount = sourceAccountOptional.get();

        Optional<AccountEntity> targetAccountOptional = accountRepository.findById(spendOnPurposeRequest.getTargetAccountId());
        AccountEntity targetAccount = targetAccountOptional.get();

        boolean enoughCash = (sourceAccount.getAmount()
                .subtract(spendOnPurposeRequest.getAmount())
                .compareTo(BigDecimal.ZERO)
                >= 0);


        boolean sourceAccountActive = sourceAccount.getActive();
        boolean targetAccountActive = targetAccount.getActive();
        boolean sourceAccountExpense = sourceAccount.getExpense();
        boolean targetAccountExpense = targetAccount.getExpense();
        boolean sameCurrency = sourceAccount.getCurrency().equals(targetAccount.getCurrency());

        if (enoughCash
                && sourceAccountActive
                && targetAccountActive
                && !sourceAccountExpense
                && targetAccountExpense
                && sameCurrency
        ) {
            TransferEntity transferEntity = new TransferEntity();

            sourceAccount.setAmount(sourceAccount.getAmount().subtract(spendOnPurposeRequest.getAmount()));
            sourceAccount.setUpdatedOn(LocalDateTime.now());

            targetAccount.setAmount(targetAccount.getAmount().add(spendOnPurposeRequest.getAmount()));
            targetAccount.setUpdatedOn(LocalDateTime.now());


            transferEntity.setTransferData(LocalDateTime.now());
            transferEntity.setUserEntity(userContext.getCurrentUser());
            transferEntity.setSelectedAccount(sourceAccount);
            transferEntity.setTargetAccount(targetAccount);
            transferEntity.setAmount(spendOnPurposeRequest.getAmount());
            transferEntity.setDescription(spendOnPurposeRequest.getDescription());
            transferRepository.save(transferEntity);

        }

    }

    private void transferCashBetweenAccount(BigDecimal amount, TransferFromAccountRequest transferRequest, AccountEntity sourceAccount, AccountEntity targetAccount) {
        sourceAccount.setAmount(sourceAccount.getAmount().subtract(transferRequest.getAmount()));
        sourceAccount.setUpdatedOn(LocalDateTime.now());

        targetAccount.setAmount(targetAccount.getAmount().add(amount));
        targetAccount.setUpdatedOn(LocalDateTime.now());
    }

    @Transactional
    public void paymentOnAccount(PaymentOnAccountRequest paymentOnAccount) {

        Optional<AccountEntity> accountEntityOptional = accountRepository.findById(paymentOnAccount.getTargetAccountId());
        AccountEntity accountEntity = accountEntityOptional.get();

        if (accountEntity instanceof PurposeEntity) {
            throw new PurposeException("You can't transfer to that account");
        }

        accountEntity.setAmount(accountEntity.getAmount().add(paymentOnAccount.getAmount()));
        accountEntity.setUpdatedOn(LocalDateTime.now());

        TransferEntity transferEntity = new TransferEntity();

        transferEntity.setDescription(paymentOnAccount.getDescription());
        transferEntity.setAmount(paymentOnAccount.getAmount());
        transferEntity.setTargetAccount(accountEntity);
        transferEntity.setTransferData(LocalDateTime.now());
        transferEntity.setUserEntity(userContext.getCurrentUser());
        transferEntity.setSelectedAccount(accountEntity);
        transferRepository.save(transferEntity);

    }
}
