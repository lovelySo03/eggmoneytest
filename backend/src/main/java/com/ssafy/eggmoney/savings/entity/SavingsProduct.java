package com.ssafy.eggmoney.savings.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "savings_products")
@NoArgsConstructor(access = PROTECTED)
public class SavingsProduct extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "savings_product_id")
    private Long id;

    private int savingsDate;
    private Double savingsRate;

    @ColumnDefault("500000")
    private int maxPrice;
}
