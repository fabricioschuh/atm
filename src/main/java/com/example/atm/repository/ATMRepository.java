package com.example.atm.repository;

import com.example.atm.model.BillType;
import com.example.atm.model.CoinType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ATMRepository {
    public interface AtmRepository extends JpaRepository<Enum, BigDecimal> {

    }
}
