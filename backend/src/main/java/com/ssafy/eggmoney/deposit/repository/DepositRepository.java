package com.ssafy.eggmoney.deposit.repository;

import com.ssafy.eggmoney.deposit.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface DepositRepository extends JpaRepository<Deposit, Long> {
    Optional<Deposit> findByUserId(Long userId);
}
