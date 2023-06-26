package com.example.atm;

import com.example.atm.model.BillType;
import com.example.atm.model.CoinType;
import com.example.atm.service.ATMService;
import com.example.atm.service.ActionNotAllowed;
import com.example.atm.service.NotEnoughCombinationException;
import com.example.atm.service.NotEnoughMoneyException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) throws NotEnoughMoneyException, NotEnoughCombinationException, ActionNotAllowed {
//		SpringApplication.run(AtmApplication.class, args);
		ATMService atmService = new ATMService();
		atmService.depositBill(BillType.ONE,1);
		atmService.depositBill(BillType.TWO,1);
		atmService.depositBill(BillType.FIVE, 1);
		atmService.depositBill(BillType.TEN, 1);
		atmService.depositBill(BillType.TWENTY, 1);
		atmService.depositBill(BillType.FIFTY,2);
		atmService.depositBill(BillType.HUNDRED, 2);
//
		atmService.depositCoin(CoinType.ONE, 1);
		atmService.depositCoin(CoinType.FIVE, 1);
		atmService.depositCoin(CoinType.TEN, 1);
		atmService.depositCoin(CoinType.TWENTYFIVE, 1);
		atmService.depositCoin(CoinType.FIFTY,1);

		System.out.println("$"+ atmService.getBalance());
		BigDecimal value = new BigDecimal("-1.00");
		atmService.withdraw(value);
		System.out.println("$"+ atmService.getBalance());
	}

}
