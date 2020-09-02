package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.query.AllTransfersByAccountId;
import com.czechak.leszek.your_budget.dto.query.AllTransfersByAccountIdResponse;
import com.czechak.leszek.your_budget.service.QueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransferHistoryController {

    QueryService queryService;

    public TransferHistoryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/transfer")
    public ResponseEntity<AllTransfersByAccountIdResponse> getAllTransfersByAccountId(@RequestParam("accountId") String accountId) {
        AllTransfersByAccountIdResponse response = queryService.getAllTransfersByAccountId(Long.parseLong(accountId));
        return ResponseEntity.ok(response);
    }

}
