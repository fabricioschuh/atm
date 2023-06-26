package com.example.atm.service;

import com.example.atm.model.BillType;
import com.example.atm.model.CoinType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

@Getter
@Setter
public class ATM {
    LinkedHashMap<BillType, Integer> bills = new LinkedHashMap<>();
    LinkedHashMap<CoinType, Integer> coins = new LinkedHashMap<>();
    private BigDecimal balance;

    public ATM(LinkedHashMap<BillType, Integer> bills, LinkedHashMap<CoinType, Integer> coins) {
        //initializing ATM with desired bills and coins
        this.bills = bills;
        this.coins = coins;
        this.balance = new BigDecimal("0.00");
    }

    public ATM() {
        //initializing ATM with ZERO for each bill and Coin
        this.bills.put(BillType.ONE, 0);
        this.bills.put(BillType.TWO, 0);
        this.bills.put(BillType.FIVE, 0);
        this.bills.put(BillType.TEN, 0);
        this.bills.put(BillType.TWENTY, 0);
        this.bills.put(BillType.FIFTY, 0);
        this.bills.put(BillType.HUNDRED, 0);

        this.coins.put(CoinType.ONE, 0);
        this.coins.put(CoinType.FIVE,0 );
        this.coins.put(CoinType.TEN, 0);
        this.coins.put(CoinType.TWENTYFIVE, 0);
        this.coins.put(CoinType.FIFTY, 0);

        this.balance = new BigDecimal("0.00");
    }

    public void depositBill(BillType bill, int quantity) {
        //get current coins quantity for desired Bill Type
        int currentQuantity = bills.get(bill);

        bills.put(bill, currentQuantity+quantity);
        BigDecimal qty = new BigDecimal(quantity);
        balance = balance.add(qty.multiply(bill.value));
    }

    public void depositCoin(CoinType coin, int quantity) {
        //get current coins quantity for desired Coin Type
        int currentQuantity = coins.get(coin);

        //update Coin quantity
        coins.put(coin, currentQuantity+quantity);

        //convert quantity to BigDecimal
        BigDecimal qty = new BigDecimal(quantity);

        //update ATM balance
        balance = balance.add(qty.multiply(coin.value));
    }

    public void withdraw(BigDecimal moneyToWithdraw) throws NotEnoughMoneyException, NotEnoughCombinationException {
        //HashMap to return the least number of bills and coins for that amount.
        LinkedHashMap<BillType, Integer> leastBillsQuantity = new LinkedHashMap<>();
        LinkedHashMap<CoinType, Integer> leastCoinsQuantity = new LinkedHashMap<>();

        if (moneyToWithdraw.compareTo(balance) == 1) {
            throw new NotEnoughMoneyException();
        }

        //withdraw Bills
        moneyToWithdraw = withdrawBills(moneyToWithdraw, BillType.HUNDRED, "100.00", leastBillsQuantity);
        moneyToWithdraw = withdrawBills(moneyToWithdraw, BillType.FIFTY, "50.00", leastBillsQuantity);
        moneyToWithdraw = withdrawBills(moneyToWithdraw, BillType.TWENTY, "20.00", leastBillsQuantity);
        moneyToWithdraw = withdrawBills(moneyToWithdraw, BillType.TEN, "10.00", leastBillsQuantity);
        moneyToWithdraw = withdrawBills(moneyToWithdraw, BillType.FIVE, "5.00", leastBillsQuantity);
        moneyToWithdraw = withdrawBills(moneyToWithdraw, BillType.TWO, "2.00", leastBillsQuantity);
        moneyToWithdraw = withdrawBills(moneyToWithdraw, BillType.ONE, "1.00", leastBillsQuantity);

        //withdraw Coins
        moneyToWithdraw = withdrawCoins(moneyToWithdraw, CoinType.FIFTY, "0.50", leastCoinsQuantity);
        moneyToWithdraw = withdrawCoins(moneyToWithdraw, CoinType.TWENTYFIVE, "0.25", leastCoinsQuantity);
        moneyToWithdraw = withdrawCoins(moneyToWithdraw, CoinType.TEN, "0.10", leastCoinsQuantity);
        moneyToWithdraw = withdrawCoins(moneyToWithdraw, CoinType.FIVE, "0.05", leastCoinsQuantity);
        moneyToWithdraw = withdrawCoins(moneyToWithdraw, CoinType.ONE, "0.01", leastCoinsQuantity);

        //check whether all possible bills and coins were withdraw but there are still some money to withdraw (combinations are not satisfied)
        if (moneyToWithdraw.compareTo(new BigDecimal("0.00")) != 0) {
            throw new NotEnoughCombinationException();
        }

        System.out.println(leastBillsQuantity);
        System.out.println(leastCoinsQuantity);
    }

    private BigDecimal withdrawBills(BigDecimal moneyToWithdraw, BillType billType, String stringValue, LinkedHashMap<BillType, Integer> leastBillsQuantity) {
        //quantity needed to withdraw
        BigDecimal billsNeededToWithdraw = moneyToWithdraw.divideToIntegralValue(billType.value);

        //available Bills in the ATM
        BigDecimal availableBillsToWithdraw = new BigDecimal(bills.get(billType));

        //in case of 0 or -1 -> there are available bills to withdraw
        BigDecimal quantityBillToWithdraw = billsNeededToWithdraw.subtract(availableBillsToWithdraw);

        //declaring and initializing total value to subtract later
        BigDecimal totalValue = new BigDecimal("0.00");

        // if quantityBillToWithdraw <= 0, It's possible to withdraw the current bill type
        if (quantityBillToWithdraw.compareTo(new BigDecimal(0)) == 0 || quantityBillToWithdraw.compareTo(new BigDecimal(0)) == -1) {
            //update quantity based on comparison
            quantityBillToWithdraw = billsNeededToWithdraw;

            //get total money to subtract from ATM balance
            totalValue = quantityBillToWithdraw.multiply(new BigDecimal(stringValue));
            balance = balance.subtract(totalValue);

            //updating HashMap quantity
            int currentMapValue = bills.get(billType);
            bills.put(billType, currentMapValue - quantityBillToWithdraw.intValue());

            //adding number of bills used to satisfy the value combination
            int leastNumberOfBills = quantityBillToWithdraw.intValue();
            leastBillsQuantity.put(billType, leastNumberOfBills);
        }

        //return the current remaining money to withdraw
        return moneyToWithdraw.subtract(totalValue);
    }

    private BigDecimal withdrawCoins(BigDecimal moneyToWithdraw, CoinType coinType, String stringValue, LinkedHashMap<CoinType, Integer> leastCoinsQuantity) {
        //quantity needed to withdraw
        BigDecimal coinsNeededToWithdraw = moneyToWithdraw.divideToIntegralValue(coinType.value);

        //available Coins in ATM
        BigDecimal availableCoinsToWithdraw = new BigDecimal(coins.get(coinType));

        //in case of 0 or -1 -> there are available coins to withdraw
        BigDecimal quantityCoinsToWithdraw = coinsNeededToWithdraw.subtract(availableCoinsToWithdraw);

        //declaring and initializing total value to subtract later
        BigDecimal totalValue = new BigDecimal("0.00");

        // if quantityBillToWithdraw <= 0, It's possible to withdraw the current bill type
        if (quantityCoinsToWithdraw.compareTo(new BigDecimal(0)) == 0 || quantityCoinsToWithdraw.compareTo(new BigDecimal(0)) == -1) {
            //update quantity based on comparison
            quantityCoinsToWithdraw = coinsNeededToWithdraw;

            //get total money to subtract from ATM balance
            totalValue = quantityCoinsToWithdraw.multiply(new BigDecimal(stringValue));
            balance = balance.subtract(totalValue);

            //updating HashMap quantity
            int currentMapValue = coins.get(coinType);
            coins.put(coinType, currentMapValue - quantityCoinsToWithdraw.intValue());

            //adding number of coins used to satisfy the value combination
            int leastNumberOfCoins = quantityCoinsToWithdraw.intValue();
            leastCoinsQuantity.put(coinType, leastNumberOfCoins);
        }

        //return the current remaining money to withdraw
        return moneyToWithdraw.subtract(totalValue);
    }


}
