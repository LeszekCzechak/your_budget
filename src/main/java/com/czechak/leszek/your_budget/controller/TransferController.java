package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.account.PaymentOnAccountRequest;
import com.czechak.leszek.your_budget.dto.purpose.SpendOnPurposeRequest;
import com.czechak.leszek.your_budget.dto.account.TransferFromAccountRequest;
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

    @PostMapping("/transferToPurpose")
    public ResponseEntity<Void> spendOnPurpose (@RequestBody SpendOnPurposeRequest spendOnPurposeRequest){
       transferService.SpendOnPurpose(spendOnPurposeRequest);
        return ResponseEntity.ok(null);
    }



}
