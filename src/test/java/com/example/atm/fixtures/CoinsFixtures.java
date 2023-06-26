package com.example.atm.fixtures;

import com.example.atm.model.CoinType;
import com.example.atm.service.ATMService;

public class CoinsFixtures {
    public static void depositOneCoin(ATMService atmService, int quantity) {
        atmService.depositCoin(CoinType.ONE, quantity);
    }
    public static void depositFiveCoin(ATMService atmService, int quantity) {
        atmService.depositCoin(CoinType.FIVE, quantity);
    }
    public static void depositTenCoin(ATMService atmService, int quantity) {
        atmService.depositCoin(CoinType.TEN, quantity);
    }
    public static void depositTwentyFiveCoin(ATMService atmService, int quantity) {
        atmService.depositCoin(CoinType.TWENTYFIVE, quantity);
    }
    public static void depositFiftyCoin(ATMService atmService, int quantity) {
        atmService.depositCoin(CoinType.FIFTY, quantity);
    }
}
