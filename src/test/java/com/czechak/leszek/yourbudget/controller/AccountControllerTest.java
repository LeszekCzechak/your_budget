package com.czechak.leszek.yourbudget.controller;

import com.czechak.leszek.yourbudget.dto.account.Account;
import com.czechak.leszek.yourbudget.dto.account.CreateAccountRequest;
import com.czechak.leszek.yourbudget.dto.account.GetAccountsResponse;
import com.czechak.leszek.yourbudget.model.Currency;
import com.czechak.leszek.yourbudget.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void shouldPassNewUserToCreateAccount() throws Exception {

        String requestBody = "{" +
                "    \"description\" : \"MainAccount2\"," +
                "    \"currency\" : \"EUR\"" +
                "}";

        mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody)
        )
                .andDo(print())
                .andExpect(status().isCreated());

        ArgumentCaptor<CreateAccountRequest> captor = ArgumentCaptor.forClass(CreateAccountRequest.class);
        verify(accountService).createAccount(captor.capture());

        assertEquals("MainAccount2", captor.getValue().getDescription());
        assertEquals(Currency.EUR, captor.getValue().getCurrency());
    }

    @Test
    void shouldReturnAllUserAccounts() throws Exception {

        //Given
        GetAccountsResponse response = new GetAccountsResponse();
        Account account = new Account();
        account.setAccountId(1L);
        account.setAmount(BigDecimal.valueOf(300));
        account.setCratedOn(LocalDateTime.now());
        account.setDescription("descr");
        response.setUserAccounts(Collections.singletonList(account));

        when(accountService.getAllUserAccounts()).thenReturn(response);

        //When/Then
        mockMvc.perform(get("/accounts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userAccounts[0].accountId", equalTo(1)));

    }

}
