package com.example.atm;

import com.example.atm.model.BillType;
import com.example.atm.model.CoinType;
import com.example.atm.service.ATMService;
import com.example.atm.service.ActionNotAllowed;
import com.example.atm.service.NotEnoughCombinationException;
import com.example.atm.service.NotEnoughMoneyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
		SpringApplication.run(AtmApplication.class, args);
//		ATMService atmService = new ATMService();
//		atmService.depositBill(BillType.ONE,50);
//		atmService.depositBill(BillType.TWO,50);
//		atmService.depositBill(BillType.FIVE, 50);
//		atmService.depositBill(BillType.TEN, 50);
//		atmService.depositBill(BillType.TWENTY, 50);
//		atmService.depositBill(BillType.FIFTY,50);
//		atmService.depositBill(BillType.HUNDRED, 50);
//
//		atmService.depositCoin(CoinType.ONE, 50);
//		atmService.depositCoin(CoinType.FIVE, 50);
//		atmService.depositCoin(CoinType.TEN, 50);
//		atmService.depositCoin(CoinType.TWENTYFIVE, 50);
//		atmService.depositCoin(CoinType.FIFTY,50);
//
//		System.out.println("$"+ atmService.getBalance());
//		BigDecimal value = new BigDecimal("147.32");
//		atmService.withdraw(value);
//		System.out.println("$"+ atmService.getBalance());
	}

}
