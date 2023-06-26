package com.example.atm;

import com.example.atm.model.BillType;
import com.example.atm.model.CoinType;
import com.example.atm.service.ATM;
import com.example.atm.service.NotEnoughCombinationException;
import com.example.atm.service.NotEnoughMoneyException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) throws NotEnoughMoneyException, NotEnoughCombinationException {
//		SpringApplication.run(AtmApplication.class, args);
		ATM atm = new ATM();
//		atm.depositBill(BillType.ONE,1);
//		atm.depositBill(BillType.TWO,1);
//		atm.depositBill(BillType.FIVE, 1);
//		atm.depositBill(BillType.TEN, 1);
//		atm.depositBill(BillType.TWENTY, 1);
		atm.depositBill(BillType.FIFTY,1);
		atm.depositBill(BillType.HUNDRED, 1);
//
//		atm.depositCoin(CoinType.ONE, 1);
//		atm.depositCoin(CoinType.FIVE, 1);
//		atm.depositCoin(CoinType.TEN, 1);
//		atm.depositCoin(CoinType.FIFTY,1);

		System.out.println("$"+atm.getBalance());
		BigDecimal value = new BigDecimal("100.00");
		atm.withdraw(value);
		System.out.println("$"+atm.getBalance());
	}

}
