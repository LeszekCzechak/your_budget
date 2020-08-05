package com.czechak.leszek.your_budget.dto.account;

import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse {

    List<Account> userAccounts;


}
