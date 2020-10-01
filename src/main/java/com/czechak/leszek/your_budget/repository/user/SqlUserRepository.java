package com.czechak.leszek.your_budget.repository.user;

import com.czechak.leszek.your_budget.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SqlUserRepository extends UserRepository, JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT u FROM UserEntity u WHERE u.username = :username")
    Optional<UserDetails> loadUserByUsername(@Param("username") String username);

}
