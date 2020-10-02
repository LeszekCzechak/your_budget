package com.czechak.leszek.yourbudget.controller;


import com.czechak.leszek.yourbudget.dto.account.CreateAccountRequest;
import com.czechak.leszek.yourbudget.dto.account.GetAccountsResponse;
import com.czechak.leszek.yourbudget.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/accounts",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
  // TODO why there is an ERROR?
    @ApiOperation(value = "Creates account for User", notes = "Provide RequestBody to create account")
    public ResponseEntity<Void> createAccount(@RequestBody CreateAccountRequest newAccount) {
        accountService.createAccount(newAccount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/accounts")
    public ResponseEntity<GetAccountsResponse> getAccounts() {
        return ResponseEntity.ok(accountService.getAllUserAccounts());
    }



}
