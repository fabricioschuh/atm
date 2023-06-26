package com.example.atm.fixtures;

import com.example.atm.model.BillType;
import com.example.atm.service.ATM;
import com.example.atm.service.NotEnoughMoneyException;

import java.math.BigDecimal;

public class BillsFixtures {

    public static void depositOneBill(ATM atm, int quantity) {
        atm.depositBill(BillType.ONE, quantity);
    }

    public static void depositTwoBill(ATM atm, int quantity) {
        atm.depositBill(BillType.TWO, quantity);
    }

    public static void depositFiveBill(ATM atm, int quantity) {
        atm.depositBill(BillType.FIVE, quantity);
    }

    public static void depositTenBill(ATM atm, int quantity) {
        atm.depositBill(BillType.TEN, quantity);
    }

    public static void depositTwentyBill(ATM atm, int quantity) {
        atm.depositBill(BillType.TWENTY, quantity);
    }

    public static void depositFiftyBill(ATM atm, int quantity) {
        atm.depositBill(BillType.FIFTY,quantity);
    }

    public static void depositHundredBill(ATM atm, int quantity) {
        atm.depositBill(BillType.HUNDRED, quantity);
    }
}
