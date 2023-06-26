package com.example.atm.rest;

import com.example.atm.model.BillType;
import com.example.atm.model.CoinType;
import com.example.atm.repository.ATMRepository;
import com.example.atm.service.ATMService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(ATMController.PATH)
public class ATMController {

    public static final String PATH = "/api/v1/atm";
    private final ATMService atmService;
    private final ATMRepository atmRepository;

    @PostMapping("/deposit/bill")
    public ResponseEntity<Void> depositBill(@RequestBody BillType billType, @RequestBody int quantity) {
//        atmService.depositBill(billType, quantity);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/deposit/coin")
    public ResponseEntity<Void> depositCoin(@RequestBody CoinType coinType, @RequestBody int quantity) {
//        atmService.depositCoin(coinType, quantity);
        return ResponseEntity.noContent().build();
    }

}
