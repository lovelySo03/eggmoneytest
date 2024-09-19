package com.ssafy.eggmoney.deposit.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import com.ssafy.eggmoney.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "deposits")
@NoArgsConstructor(access = PROTECTED)
public class Deposit extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "deposit_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "deposit_product_id")
    private DepositProduct depositProduct;


    private LocalDateTime expireDate;

    private int depositMoney;

    // 가입기간 : created_at
    @Builder
    public Deposit(User user, DepositProduct depositProduct, LocalDateTime expireDate, int depositMoney) {
        this.user = user;
        this.depositProduct = depositProduct;
        this.expireDate = expireDate;
        this.depositMoney = depositMoney;
    }

}
