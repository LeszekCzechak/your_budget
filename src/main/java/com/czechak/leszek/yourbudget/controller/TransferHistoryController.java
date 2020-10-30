package com.czechak.leszek.yourbudget.controller;

import com.czechak.leszek.yourbudget.dto.transfers.AllTransfersByAccountIdResponse;
import com.czechak.leszek.yourbudget.dto.transfers.TransferHistorySearchRequest;
import com.czechak.leszek.yourbudget.service.QueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @PostMapping("/transfer/search")
    public ResponseEntity<AllTransfersByAccountIdResponse> searchQuery(@RequestBody TransferHistorySearchRequest query){
        queryService.advancedQuery(query);
    }

}
