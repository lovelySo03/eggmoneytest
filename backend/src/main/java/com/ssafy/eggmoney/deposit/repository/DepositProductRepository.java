package com.ssafy.eggmoney.deposit.repository;

import com.ssafy.eggmoney.deposit.entity.DepositProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface DepositProductRepository extends JpaRepository<DepositProduct, Long> {
}
