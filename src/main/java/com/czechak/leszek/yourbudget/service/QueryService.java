package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.dto.transfers.AllTransfersByAccountId;
import com.czechak.leszek.yourbudget.dto.transfers.AllTransfersByAccountIdResponse;
import com.czechak.leszek.yourbudget.dto.transfers.TransferHistorySearchRequest;
import com.czechak.leszek.yourbudget.repository.transfer.TransferRepository;
import com.czechak.leszek.yourbudget.repository.user.UserRepository;
import com.czechak.leszek.yourbudget.model.TransferEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
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
                .map(mapEntityToDto())
                .collect(Collectors.toList());

        AllTransfersByAccountIdResponse response = new AllTransfersByAccountIdResponse();
        response.setTransferEntities(res);

        return response;
    }

    @NotNull
    private Function<TransferEntity, AllTransfersByAccountId> mapEntityToDto() {
        return x -> {
            AllTransfersByAccountId transfers = new AllTransfersByAccountId();
            transfers.setTransferId(x.getTransferId());
            transfers.setUserId(x.getUserEntity().getId());
            transfers.setSourceAccountId(x.getSelectedAccount().getAccountId());
            transfers.setSourceAccountDescription(x.getSelectedAccount().getDescription());
            transfers.setTargetAccountId(x.getTargetAccount().getAccountId());
            transfers.setTargetAccountDescription(x.getTargetAccount().getDescription());
            transfers.setTransferAmount(x.getAmount());
            transfers.setTransferData(x.getTransferData());
            transfers.setTransferDescription(x.getDescription());
            return transfers;

        };
    }

//
//    public Set<AllTransfersByAccountIdResponse> advancedQuery(TransferHistorySearchRequest query) {
//        transferRepository.
//    }
}
