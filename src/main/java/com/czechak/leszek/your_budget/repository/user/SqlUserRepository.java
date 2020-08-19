package com.czechak.leszek.your_budget.repository.user;

import com.czechak.leszek.your_budget.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlUserRepository extends UserRepository, JpaRepository<UserEntity, Long> {

}
