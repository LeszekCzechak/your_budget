package com.czechak.leszek.your_budget.repository.account;

import com.czechak.leszek.your_budget.model.AccountEntity;
import com.czechak.leszek.your_budget.model.UserEntity;
import com.czechak.leszek.your_budget.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Sql(statements = {
            "insert into users(user_id, login, password, mail) values(999, 'login', 'password', 'mail')",
            "INSERT INTO ACCOUNTS(DTYPE,ACCOUNT_ID,ACTIVE,AMOUNT,CRATED_ON,CURRENCY,DESCRIPTION,EXPENSE,UPDATED_ON,USER_ENTITY_USER_ID,CATEGORY_CATEGORY_ID) " +
                    "VALUES ('AccountEntity', 3, TRUE,0.00, null,8, 'MainAccount2','FALSE', null, 999, null)"

    })
    void shouldFindAccountEntitiesByUserEntity() {

        //given
        UserEntity user = userRepository.findById(999L).get();

        //when
        List<AccountEntity> accountEntitiesByUserEntity = accountRepository.findAccountEntitiesByUserEntity(user);

        //then
        assertEquals(1, accountEntitiesByUserEntity.size());
        assertEquals(3, accountEntitiesByUserEntity.get(0).getAccountId());
        assertEquals("MainAccount2", accountEntitiesByUserEntity.get(0).getDescription());

    }
}
