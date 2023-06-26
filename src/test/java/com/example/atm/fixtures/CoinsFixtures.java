package com.example.atm.fixtures;

import com.example.atm.model.CoinType;
import com.example.atm.service.ATM;

public class CoinsFixtures {
    public static void depositOneCoin(ATM atm, int quantity) {
        atm.depositCoin(CoinType.ONE, quantity);
    }
    public static void depositFiveCoin(ATM atm, int quantity) {
        atm.depositCoin(CoinType.FIVE, quantity);
    }
    public static void depositTenCoin(ATM atm, int quantity) {
        atm.depositCoin(CoinType.TEN, quantity);
    }
    public static void depositTwentyFiveCoin(ATM atm, int quantity) {
        atm.depositCoin(CoinType.TWENTYFIVE, quantity);
    }
    public static void depositFiftyCoin(ATM atm, int quantity) {
        atm.depositCoin(CoinType.FIFTY, quantity);
    }
}
