package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.dto.account.CreateAccountRequest;
import com.czechak.leszek.yourbudget.dto.account.GetAccountsResponse;
import com.czechak.leszek.yourbudget.model.AccountEntity;
import com.czechak.leszek.yourbudget.model.Currency;
import com.czechak.leszek.yourbudget.model.UserEntity;
import com.czechak.leszek.yourbudget.model.UserRole;
import com.czechak.leszek.yourbudget.repository.account.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private UserContext userContext;

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService(accountRepository,userContext);
    }

    @Test
    void shouldCreateNewAccount() {

        //given
        CreateAccountRequest accountRequest = new CreateAccountRequest();
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

    @Test
    void getAllUserAccounts() {

        //given
        List<AccountEntity> accountEntitiesByUserEntity = new LinkedList<>();
        AccountEntity accountEntity = new AccountEntity(1L,
                new UserEntity(1L, "user", "user", "user@user.com", LocalDateTime.MAX,LocalDateTime.now(),"user", Set.of(UserRole.USER),true,true,true,true)
                , "accountEntity", BigDecimal.TEN, null, null, TRUE, FALSE, Currency.PLN);

        accountEntitiesByUserEntity.add(accountEntity);

        Mockito.when(accountRepository.findAccountEntitiesByUserEntity(userContext.getCurrentUser())).thenReturn(accountEntitiesByUserEntity);

        //when
        GetAccountsResponse allUserAccounts = accountService.getAllUserAccounts();

        //then
        assertEquals(1,allUserAccounts.getUserAccounts().size());
        assertEquals(1L,allUserAccounts.getUserAccounts().get(0).getAccountId());
        assertEquals(BigDecimal.TEN,allUserAccounts.getUserAccounts().get(0).getAmount());
        assertEquals(Currency.PLN,allUserAccounts.getUserAccounts().get(0).getCurrency());
        assertEquals("accountEntity",allUserAccounts.getUserAccounts().get(0).getDescription());
        assertNull(allUserAccounts.getUserAccounts().get(0).getCratedOn());
        assertNull(allUserAccounts.getUserAccounts().get(0).getUpdatedOn());

    }
}
