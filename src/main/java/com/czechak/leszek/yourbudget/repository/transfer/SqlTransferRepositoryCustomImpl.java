package com.czechak.leszek.yourbudget.repository.transfer;

import com.czechak.leszek.yourbudget.dto.transfers.TransferHistorySearchRequest;
import com.czechak.leszek.yourbudget.model.TransferEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class SqlTransferRepositoryCustomImpl implements SqlTransferRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<TransferEntity> searchByCriteria(TransferHistorySearchRequest searchRequest) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TransferEntity> query = criteriaBuilder.createQuery(TransferEntity.class);


        return null;
    }
}
