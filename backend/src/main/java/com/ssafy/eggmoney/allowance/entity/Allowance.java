package com.ssafy.eggmoney.allowance.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import com.ssafy.eggmoney.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "allowances")
@NoArgsConstructor(access = PROTECTED)
public class Allowance extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "allowance_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User child;
    // 부모는 자식의 가족id에서 조인해서 가져오기

    private int price;

    @Enumerated(value = STRING)
    private AllowancePeriod allowancePeriod;

    // 주 : 0(일)-6(토), 월 : 0(초일)-6(말일)
    private int allowanceDay;
}
