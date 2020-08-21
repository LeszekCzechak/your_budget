package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.account.CreateAccountRequest;
import com.czechak.leszek.your_budget.model.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AccountServiceTest {


    private AccountService accountService;

    @BeforeEach
    void setUp(){

    }

    @Test
    void shouldCreateNewAccount(){

        //given
        CreateAccountRequest accountRequest= new CreateAccountRequest();
        accountRequest.setDescription("TestingAccount");
        accountRequest.setCurrency(Currency.PLN);

        //when
        accountService.createAccount(accountRequest);

        //then



    }

}