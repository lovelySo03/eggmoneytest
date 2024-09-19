package com.ssafy.eggmoney.withdrawal.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import com.ssafy.eggmoney.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "withdrawals")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Withdrawal extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "withdrawal_id")
    private Long id;

//    인출하는 사용자
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    인출 금액
    private int withdrawalPrice;

//    인출 상태(진행중, 승인, 거절)
//    private WithdrawalType withdrawalStatus;

    @Builder(toBuilder = true)
    private Withdrawal(User user, WithdrawalStatus withdrawalStatus, int withdrawalPrice) {
        this.user = user;
        this.withdrawalPrice = withdrawalPrice;
//        this.withdrawalStatus = withdrawalStatus;
        this.withdrawalStatus = withdrawalStatus;
    }

    public void setWithdrawalStatus(WithdrawalStatus withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    @Enumerated(value = EnumType.STRING)
    private WithdrawalStatus withdrawalStatus;
}
