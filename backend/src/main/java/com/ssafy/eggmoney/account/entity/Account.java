package com.ssafy.eggmoney.account.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import com.ssafy.eggmoney.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "accounts")
@NoArgsConstructor(access = PROTECTED)
public class Account extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int balance;

    @Builder(toBuilder = true)
    private Account(long id, User user, int balance) {
        this.id = id;
        this.user = user;
        this.balance = balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }
}
