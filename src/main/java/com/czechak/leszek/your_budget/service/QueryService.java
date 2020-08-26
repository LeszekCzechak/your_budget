package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.query.AllTransfersByAccountId;
import com.czechak.leszek.your_budget.dto.query.AllTransfersByAccountIdResponse;
import com.czechak.leszek.your_budget.repository.transfer.TransferRepository;
import com.czechak.leszek.your_budget.repository.user.UserRepository;
import com.czechak.leszek.your_budget.model.TransferEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

        List<AllTransfersByAccountId> res = allTransfersByAccountId.stream()
                .map(x -> {
                    AllTransfersByAccountId transfers = new AllTransfersByAccountId();
                    transfers.setTransferId(x.getTransferId());
                    transfers.setUserId(x.getUserEntity().getUserId());
                    transfers.setSourceAccountId(x.getSelectedAccount().getAccountId());
                    transfers.setSourceAccountDescription(x.getSelectedAccount().getDescription());
                    transfers.setTargetAccountId(x.getTargetAccount().getAccountId());
                    transfers.setTargetAccountDescription(x.getTargetAccount().getDescription());
                    transfers.setTransferAmount(x.getAmount());
                    transfers.setTransferData(x.getTransferData());
                    transfers.setTransferDescription(x.getDescription());
                    return transfers;

                })
                .collect(Collectors.toList());

        AllTransfersByAccountIdResponse response = new AllTransfersByAccountIdResponse();
        response.setTransferEntities(res);

        return response;
    }


}
