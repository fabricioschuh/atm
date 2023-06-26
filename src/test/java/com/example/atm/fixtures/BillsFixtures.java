package com.example.atm.fixtures;

import com.example.atm.model.BillType;
import com.example.atm.service.ATMService;

public class BillsFixtures {

    public static void depositOneBill(ATMService atmService, int quantity) {
        atmService.depositBill(BillType.ONE, quantity);
    }

    public static void depositTwoBill(ATMService atmService, int quantity) {
        atmService.depositBill(BillType.TWO, quantity);
    }

    public static void depositFiveBill(ATMService atmService, int quantity) {
        atmService.depositBill(BillType.FIVE, quantity);
    }

    public static void depositTenBill(ATMService atmService, int quantity) {
        atmService.depositBill(BillType.TEN, quantity);
    }

    public static void depositTwentyBill(ATMService atmService, int quantity) {
        atmService.depositBill(BillType.TWENTY, quantity);
    }

    public static void depositFiftyBill(ATMService atmService, int quantity) {
        atmService.depositBill(BillType.FIFTY,quantity);
    }

    public static void depositHundredBill(ATMService atmService, int quantity) {
        atmService.depositBill(BillType.HUNDRED, quantity);
    }
}
