package com.ssafy.eggmoney.family.repository;

import com.ssafy.eggmoney.family.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    Optional<Family> findByPresentId(Long presentId);
}
