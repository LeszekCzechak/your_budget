package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.query.AllTransfersByAccountIdResponse;
import com.czechak.leszek.your_budget.dto.query.GetAllTransfersByAccountIdRequest;
import com.czechak.leszek.your_budget.model.transfer.TransferRepository;
import com.czechak.leszek.your_budget.model.user.UserRepository;
import com.czechak.leszek.your_budget.repository.TransferEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QueryService {

    private final TransferRepository transferRepository;
    private final UserRepository userRepository;

    public QueryService(TransferRepository transferRepository, UserRepository userRepository) {
        this.transferRepository = transferRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public AllTransfersByAccountIdResponse getAllTransfersByAccountId(Long accountId){

        List<TransferEntity> allTransfersByAccountId = transferRepository.getAllTransferByAccountId(accountId);

        AllTransfersByAccountIdResponse response= new AllTransfersByAccountIdResponse();
        response.setTransferEntities(allTransfersByAccountId);

        return response;
    }


}
