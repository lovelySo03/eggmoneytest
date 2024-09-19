package com.ssafy.eggmoney.stock.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "stock_trade_log")
@NoArgsConstructor(access = PROTECTED)
public class StockTradeLog extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "trade_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_user_id")
    private StockUser stockUser;

    @Enumerated(value = EnumType.STRING)
    private TradeType tradeType;

    private boolean isExecution;
    private int tradeAmount;
    private int price;
}
