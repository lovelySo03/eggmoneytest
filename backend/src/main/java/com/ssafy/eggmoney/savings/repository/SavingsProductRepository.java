package com.ssafy.eggmoney.savings.repository;

import com.ssafy.eggmoney.savings.entity.SavingsProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SavingsProductRepository extends JpaRepository<SavingsProduct, Long> {
}
