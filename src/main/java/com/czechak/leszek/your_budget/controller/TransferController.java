package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.PaymentOnAccountRequest;
import com.czechak.leszek.your_budget.dto.SpendOnPurpose;
import com.czechak.leszek.your_budget.dto.TransferFromAccountRequest;
import com.czechak.leszek.your_budget.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transferFromAccountToAccount (@RequestBody TransferFromAccountRequest transferFromAccount){
        transferService.transferFromAccount(transferFromAccount);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/transferToAccount")
    public ResponseEntity<Void> paymentOnAccount(@RequestBody PaymentOnAccountRequest paymentOnAccount){
        transferService.paymentOnAccount(paymentOnAccount);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/transferToExpense")
    public ResponseEntity<Void> spendOnPurpose (@RequestBody SpendOnPurpose spendOnPurpose){
        // TODO uzupełnić ciało metody
        return ResponseEntity.ok(null);
    }

}