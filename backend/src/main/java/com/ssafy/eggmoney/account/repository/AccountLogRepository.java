package com.ssafy.eggmoney.account.repository;

import com.ssafy.eggmoney.account.entity.AccountLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountLogRepository extends JpaRepository<AccountLog, Long> {

    // accountID값이 같은 로그 가져오기
    @Query("SELECT al FROM AccountLog al WHERE al.account.id = :accountId")
    List<AccountLog> findLogsByAccountId(@Param("accountId") Long accountId);
}
