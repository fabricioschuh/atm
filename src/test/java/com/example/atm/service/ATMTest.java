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
public class ATMTest {

    private ATM atm;

    @BeforeEach
    public void setup() {
        atm = new ATM();
    }


    @Test
    void depositOneOneBillShouldGiveBalance1() {
        depositOneBill(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("1.00");
        int currentQuantity = atm.bills.get(BillType.ONE);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTwoBillShouldGiveBalance2() {
        depositTwoBill(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("2.00");
        int currentQuantity = atm.bills.get(BillType.TWO);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiveBillShouldGiveBalance5() {
        depositFiveBill(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("5.00");
        int currentQuantity = atm.bills.get(BillType.FIVE);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTenBillShouldGiveBalance10() {
        depositTenBill(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("10.00");
        int currentQuantity = atm.bills.get(BillType.TEN);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTwentyBillShouldGiveBalance20() {
        depositTwentyBill(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("20.00");
        int currentQuantity = atm.bills.get(BillType.TWENTY);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiftyBillShouldGiveBalance50() {
        depositFiftyBill(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("50.00");
        int currentQuantity = atm.bills.get(BillType.FIFTY);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneHundredBillShouldGiveBalance100() {
        depositHundredBill(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("100.00");
        int currentQuantity = atm.bills.get(BillType.HUNDRED);
        int expectedBillQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneOneCoinShouldGiveBalance001() {
        depositOneCoin(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.01");
        int currentQuantity = atm.coins.get(CoinType.ONE);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiveCoinShouldGiveBalance005() {
        depositFiveCoin(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.05");
        int currentQuantity = atm.coins.get(CoinType.FIVE);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTenCoinShouldGiveBalance010() {
        depositTenCoin(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.10");
        int currentQuantity = atm.coins.get(CoinType.TEN);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneTwentyFiveCoinShouldGiveBalance025() {
        depositTwentyFiveCoin(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.25");
        int currentQuantity = atm.coins.get(CoinType.TWENTYFIVE);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void depositOneFiftyCoinShouldGiveBalance050() {
        depositFiftyCoin(atm, 1);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("00.50");
        int currentQuantity = atm.coins.get(CoinType.FIFTY);
        int expectedCoinQuantity = 1;

        assertThat(currentQuantity).isEqualTo(expectedCoinQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneOneBillWithOneBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException {
        depositOneBill(atm, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("1.00");
        atm.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atm.bills.get(BillType.ONE);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneTwoBillWithTwoBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException {
        depositTwoBill(atm, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("2.00");
        atm.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atm.bills.get(BillType.TWO);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneFiveBillWithFiveBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException {
        depositFiveBill(atm, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("5.00");
        atm.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atm.bills.get(BillType.FIVE);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneTenBillWithTenBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException {
        depositTenBill(atm, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("10.00");
        atm.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atm.bills.get(BillType.TEN);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneTwentyBillWithTwentyBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException {
        depositTwentyBill(atm, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("20.00");
        atm.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atm.bills.get(BillType.TWENTY);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneFiftyBillWithFiftyBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException {
        depositFiftyBill(atm, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("50.00");
        atm.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atm.bills.get(BillType.FIFTY);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawOneHundredBillWithHundredBalanceShouldGiveBalanceZero() throws NotEnoughMoneyException, NotEnoughCombinationException {
        depositHundredBill(atm, 1);
        BigDecimal moneyToWithdraw = new BigDecimal("100.00");
        atm.withdraw(moneyToWithdraw);

        BigDecimal currentBalance = atm.getBalance();
        BigDecimal expectedBalance = new BigDecimal("0.00");
        int currentQuantity = atm.bills.get(BillType.HUNDRED);
        int expectedBillQuantity = 0;

        assertThat(currentQuantity).isEqualTo(expectedBillQuantity);
        assertThat(currentBalance).isEqualTo(expectedBalance);
    }

    @Test
    void withdrawNotEnoughMoneyShouldThrownNotEnoughMoneyException () {
        depositOneBill(atm, 1);
        Exception expectedException = null;
        try {
            BigDecimal moneyToWithdraw = new BigDecimal("1.01");
            atm.withdraw(moneyToWithdraw);
        }
        catch (Exception e) {
            expectedException = e;
        }
        assertThat(expectedException.getClass()).isEqualTo(NotEnoughMoneyException.class);
    }

    @Test
    void withdrawNoCombinationShouldThrownNotEnoughCombinationException () {
        depositHundredBill(atm, 1);
        Exception expectedException = null;
        try {
            BigDecimal moneyToWithdraw = new BigDecimal("50.00");
            atm.withdraw(moneyToWithdraw);
        }
        catch (Exception e) {
            expectedException = e;
        }
        assertThat(expectedException.getClass()).isEqualTo(NotEnoughCombinationException.class);
    }
}
