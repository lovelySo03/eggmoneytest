package com.ssafy.eggmoney.user.repository;

import com.ssafy.eggmoney.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {

}
