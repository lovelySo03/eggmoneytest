package com.ssafy.eggmoney.stock.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "stocks")
@NoArgsConstructor(access = PROTECTED)
public class Stock extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private StockItem stockItem;

    private String stockCode;
    private int price;
    private int previousPrice;
}
