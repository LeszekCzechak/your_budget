package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.account.CreateAccountRequest;
import com.czechak.leszek.your_budget.model.AccountEntity;
import com.czechak.leszek.your_budget.model.Currency;
import com.czechak.leszek.your_budget.model.UserEntity;
import com.czechak.leszek.your_budget.repository.account.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private UserContext userContext;

//    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp(){
        accountService = new AccountService(accountRepository, userContext);
    }

    @Test
    void shouldCreateNewAccount(){

        //given
        CreateAccountRequest accountRequest= new CreateAccountRequest();
        accountRequest.setDescription("TestingAccount");
        accountRequest.setCurrency(Currency.PLN);

        UserEntity userEntity = new UserEntity();
        Mockito.when(userContext.getCurrentUser()).thenReturn(userEntity);

        //when
        accountService.createAccount(accountRequest);

        //then
        ArgumentCaptor<AccountEntity> argumentCaptor = ArgumentCaptor.forClass(AccountEntity.class);
        Mockito.verify(accountRepository).save(argumentCaptor.capture());
        AccountEntity entity = argumentCaptor.getValue();
        assertEquals("TestingAccount", entity.getDescription());
        assertEquals(Currency.PLN, entity.getCurrency());
        assertEquals(BigDecimal.ZERO, entity.getAmount());
        assertEquals(userEntity, entity.getUserEntity());
        assertEquals(true, entity.getActive());
        assertEquals(false, entity.getExpense());
        assertNotNull(entity.getCratedOn());
        assertNotNull(entity.getUpdatedOn());

    }

}
