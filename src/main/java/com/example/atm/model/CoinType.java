package com.example.atm.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Entity
public enum CoinType {
    ONE(new BigDecimal("0.01")),
    FIVE(new BigDecimal("0.05")),
    TEN(new BigDecimal("0.10")),
    TWENTYFIVE(new BigDecimal("0.25")),
    FIFTY(new BigDecimal("0.50"));

    public final BigDecimal value;

    public String getIDAsString() {
        return "Coin: " + this.name();
    }
}
