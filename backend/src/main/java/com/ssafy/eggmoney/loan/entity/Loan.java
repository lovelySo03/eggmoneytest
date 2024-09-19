package com.ssafy.eggmoney.loan.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import com.ssafy.eggmoney.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "loans")
@NoArgsConstructor(access = PROTECTED)
public class Loan extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(value = STRING)
    private LoanType loanType;

    @Enumerated(value = STRING)
    private LoanStatus loanStatus;

    private int loanAmount;
    private int loanDate;
    private int balance;
    private String loanReason;
    private String refuseReason;
    private Double loanRate;
}
