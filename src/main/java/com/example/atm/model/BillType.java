package com.example.atm.model;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public enum BillType {
    ONE(new BigDecimal("1.00")),
    TWO(new BigDecimal("2.00")),
    FIVE(new BigDecimal("5.00")),
    TEN(new BigDecimal("10.00")),
    TWENTY(new BigDecimal("20.00")),
    FIFTY(new BigDecimal("50.00")),
    HUNDRED(new BigDecimal("100.00"));

    public final BigDecimal value;
}
