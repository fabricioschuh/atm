package com.example.atm.model;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public enum CoinType {
    ONE(new BigDecimal("0.01")),
    FIVE(new BigDecimal("0.05")),
    TEN(new BigDecimal("0.10")),
    TWENTYFIVE(new BigDecimal("0.25")),
    FIFTY(new BigDecimal("0.50"));

    public final BigDecimal value;
}
