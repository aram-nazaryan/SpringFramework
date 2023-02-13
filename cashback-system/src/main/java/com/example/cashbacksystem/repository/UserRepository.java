package com.example.cashbacksystem.repository;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUsersByUuid(String uuid);
    Optional<User> findUserByUsername(String username);

}
