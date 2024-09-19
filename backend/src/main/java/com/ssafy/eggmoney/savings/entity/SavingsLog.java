package com.ssafy.eggmoney.savings.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "savings_logs")
@NoArgsConstructor(access = PROTECTED)
public class SavingsLog extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "savings_log_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "savings_id" )
    private Savings savings;

    // 납입 시점 적금통장 잔고
    private int balance;

    @Builder(toBuilder = true)
    public SavingsLog(Long id, Savings savings, int balance) {
        this.id = id;
        this.savings = savings;
        this.balance = balance;
    }
}
