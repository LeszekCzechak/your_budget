package com.czechak.leszek.your_budget.dto;

import com.czechak.leszek.your_budget.repository.AccountEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse {

    List<Account> userAccounts;


}
