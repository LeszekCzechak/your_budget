package com.czechak.leszek.your_budget.dto.account;

import com.czechak.leszek.your_budget.dto.account.Account;
import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse {

    List<Account> userAccounts;


}
