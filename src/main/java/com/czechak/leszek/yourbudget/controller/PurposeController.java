package com.czechak.leszek.yourbudget.controller;

import com.czechak.leszek.yourbudget.dto.purpose.CreatePurposeRequest;
import com.czechak.leszek.yourbudget.dto.purpose.EditPurposeRequest;
import com.czechak.leszek.yourbudget.dto.purpose.GetPurposesResponse;
import com.czechak.leszek.yourbudget.service.PurposeService;
import com.czechak.leszek.yourbudget.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurposeController {

    TransferService transferService;
    PurposeService purposeService;

    public PurposeController(TransferService transferService, PurposeService purposeService) {
        this.transferService = transferService;
        this.purposeService = purposeService;
    }

    @PostMapping("/purpose")
    public ResponseEntity<Void> createPurpose(@RequestBody CreatePurposeRequest newPurpose) {
        purposeService.createPurpose(newPurpose);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/purpose")
    public ResponseEntity<GetPurposesResponse> getAllUserPurposes() {
        GetPurposesResponse allUserPurposes = purposeService.getAllUserPurposes();
        return ResponseEntity.ok(allUserPurposes);
    }


    @PutMapping("/purpose")
    public ResponseEntity<Void> editPurpose (@RequestBody EditPurposeRequest editPurposeRequest){
       purposeService.editPurpose(editPurposeRequest);
        return ResponseEntity.ok(null);
    }
}
