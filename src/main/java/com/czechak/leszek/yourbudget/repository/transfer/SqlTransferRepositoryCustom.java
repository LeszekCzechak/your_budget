package com.czechak.leszek.yourbudget.repository.transfer;

import com.czechak.leszek.yourbudget.dto.transfers.TransferHistorySearchRequest;
import com.czechak.leszek.yourbudget.model.TransferEntity;

import java.util.List;

public interface SqlTransferRepositoryCustom {

    List<TransferEntity> searchByCriteria(TransferHistorySearchRequest searchRequest);

}
