package com.czechak.leszek.your_budget.dto;

import com.czechak.leszek.your_budget.repository.AccountEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse {

    // lista accountEntity
    // TODO: Co powinno być w tej klasie? jakaś lista account? Po co?
    List<Account> userAccounts;


}
