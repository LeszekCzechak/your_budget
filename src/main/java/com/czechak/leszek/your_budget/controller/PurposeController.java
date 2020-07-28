package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.CreatePurposeRequest;
import com.czechak.leszek.your_budget.service.PurposeService;
import com.czechak.leszek.your_budget.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurposeController {

    TransferService transferService;
    PurposeService purposeService;


    @PostMapping("/purpose")
    public ResponseEntity<Void> createPurpose(@RequestBody CreatePurposeRequest newPurpose) {
        //TODO uzupełnić ciało metody
        return ResponseEntity.ok(null);
    }


}
