package com.ssafy.eggmoney.deposit.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "deposit_products")
@NoArgsConstructor(access = PROTECTED)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DepositProduct extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "deposit_product_id")
    private Long id;

    private int depositDate;
    private Double depositRate;
}
