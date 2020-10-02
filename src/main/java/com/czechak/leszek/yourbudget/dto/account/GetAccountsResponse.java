package com.czechak.leszek.yourbudget.dto.account;

import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse {

    List<Account> userAccounts;


}
