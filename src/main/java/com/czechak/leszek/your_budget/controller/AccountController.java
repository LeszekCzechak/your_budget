package com.czechak.leszek.your_budget.controller;


import com.czechak.leszek.your_budget.dto.CreateAccountRequest;
import com.czechak.leszek.your_budget.dto.GetAccountsResponse;
import com.czechak.leszek.your_budget.service.AccountService;
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

    @PostMapping("/accounts")
    public ResponseEntity<Void> createAccount(@RequestBody CreateAccountRequest newAccount) {
        accountService.createAccount(newAccount);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/accounts")
    public ResponseEntity<GetAccountsResponse> getAccounts() {
        return ResponseEntity.ok(accountService.getAllUserAccounts());
    }

}
