package com.example.atm.service;

import com.example.atm.model.BillType;
import com.example.atm.model.CoinType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static com.example.atm.fixtures.BillsFixtures.*;
import static com.example.atm.fixtures.CoinsFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ATMServiceTest {

    private ATMService atmService;

    @BeforeEach
    public void setup() {
        atmService = new ATMService();
    }


    @Test
    void depositOneOneBillShouldGiveBalance1() {
        depositOneBill(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("1.00");
        int currentQuantity = atmService.bills.get(BillType.ONE);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTwoBillShouldGiveBalance2() {
        depositTwoBill(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("2.00");
        int currentQuantity = atmService.bills.get(BillType.TWO);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiveBillShouldGiveBalance5() {
        depositFiveBill(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("5.00");
        int currentQuantity = atmService.bills.get(BillType.FIVE);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTenBillShouldGiveBalance10() {
        depositTenBill(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("10.00");
        int currentQuantity = atmService.bills.get(BillType.TEN);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTwentyBillShouldGiveBalance20() {
        depositTwentyBill(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("20.00");
        int currentQuantity = atmService.bills.get(BillType.TWENTY);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiftyBillShouldGiveBalance50() {
        depositFiftyBill(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("50.00");
        int currentQuantity = atmService.bills.get(BillType.FIFTY);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneHundredBillShouldGiveBalance100() {
        depositHundredBill(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("100.00");
        int currentQuantity = atmService.bills.get(BillType.HUNDRED);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneOneCoinShouldGiveBalance001() {
        depositOneCoin(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.01");
        int currentQuantity = atmService.coins.get(CoinType.ONE);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiveCoinShouldGiveBalance005() {
        depositFiveCoin(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.05");
        int currentQuantity = atmService.coins.get(CoinType.FIVE);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTenCoinShouldGiveBalance010() {
        depositTenCoin(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.10");
        int currentQuantity = atmService.coins.get(CoinType.TEN);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTwentyFiveCoinShouldGiveBalance025() {
        depositTwentyFiveCoin(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.25");
        int currentQuantity = atmService.coins.get(CoinType.TWENTYFIVE);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiftyCoinShouldGiveBalance050() {
        depositFiftyCoin(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.50");
        int currentQuantity = atmService.coins.get(CoinType.FIFTY);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneOneBillWithOneBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositOneBill(atmService, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("1.00");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atmService.bills.get(BillType.ONE);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneTwoBillWithTwoBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositTwoBill(atmService, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("2.00");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atmService.bills.get(BillType.TWO);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneFiveBillWithFiveBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositFiveBill(atmService, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("5.00");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atmService.bills.get(BillType.FIVE);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneTenBillWithTenBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositTenBill(atmService, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("10.00");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atmService.bills.get(BillType.TEN);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneTwentyBillWithTwentyBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositTwentyBill(atmService, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("20.00");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atmService.bills.get(BillType.TWENTY);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneFiftyBillWithFiftyBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositFiftyBill(atmService, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("50.00");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atmService.bills.get(BillType.FIFTY);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneHundredBillWithHundredBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositHundredBill(atmService, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("100.00");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atmService.bills.get(BillType.HUNDRED);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawNotEnoughMoneyShouldThrownNotEnoughMoneyException () {
        depositOneBill(atmService, 1);
        Exception expectedException = null;
        try {
            BigDecimal moneyToWithdraw = new BigDecimal("1.01");
            atmService.withdraw(moneyToWithdraw);
        }
        catch (Exception e) {
            expectedException = e;
        }
        assertThat(expectedException.getClass()).isEqualTo(NotEnoughMoneyException.class);
    }

    @Test
    void withdrawNoCombinationShouldThrownNotEnoughCombinationException () {
        depositHundredBill(atmService, 1);
        Exception expectedException = null;
        try {
            BigDecimal moneyToWithdraw = new BigDecimal("50.00");
            atmService.withdraw(moneyToWithdraw);
        }
        catch (Exception e) {
            expectedException = e;
        }
        assertThat(expectedException.getClass()).isEqualTo(NotEnoughCombinationException.class);
    }

    @Test
    void depositAndWithdrawEachTypeShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
        depositOneBill(atmService, 1);
        depositTwoBill(atmService, 1);
        depositFiveBill(atmService, 1);
        depositTenBill(atmService, 1);
        depositTwentyBill(atmService, 1);
        depositFiftyBill(atmService, 1);
        depositHundredBill(atmService, 1);

        depositOneCoin(atmService, 1);
        depositFiveCoin(atmService, 1);
        depositTenCoin(atmService, 1);
        depositTwentyFiveCoin(atmService, 1);
        depositFiftyCoin(atmService, 1);

        BigDecimal currentBalance = atmService.getBalance();
        BigDecimal expectedBalance = new BigDecimal("188.91");

        assertThat(currentBalance).isEqualTo(expectedBalance);

        BigDecimal moneyToWithdraw = new BigDecimal("188.91");
        atmService.withdraw(moneyToWithdraw);

        BigDecimal newCurrentBalance = atmService.getBalance();
        BigDecimal newExpectedBalance = new BigDecimal("00.00");
        assertThat(newCurrentBalance).isEqualTo(newExpectedBalance);
    }
}
