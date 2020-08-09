package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.query.AllTransfersByAccountIdResponse;
import com.czechak.leszek.your_budget.dto.query.GetAllTransfersByAccountIdRequest;
import com.czechak.leszek.your_budget.service.QueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/transfer")
    public ResponseEntity<AllTransfersByAccountIdResponse> getAllTransfersByAccountId(GetAllTransfersByAccountIdRequest request) {

        AllTransfersByAccountIdResponse response = queryService.getAllTransfersByAccountId(request);
        return ResponseEntity.ok(response);
    }

}
