package com.ssafy.eggmoney.withdrawal.repository;

import com.ssafy.eggmoney.withdrawal.entity.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
    @Query("SELECT w FROM Withdrawal w WHERE w.user.id = :userId")
    List<Withdrawal> findLogsByUserId(@Param("userId") Long userId);
}
