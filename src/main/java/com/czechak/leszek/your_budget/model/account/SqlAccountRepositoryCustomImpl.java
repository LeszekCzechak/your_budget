package com.czechak.leszek.your_budget.model.account;

import com.czechak.leszek.your_budget.repository.AccountEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
public class SqlAccountRepositoryCustomImpl implements SqlAccountRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AccountEntity> getAccountsForUserId(Long id) {
        List resultList = entityManager.createNativeQuery("select * from accounts where user userId = " + id).getResultList();
        //tutaj jeszcze mapowanie itd;
        return Collections.emptyList();
    }
}
