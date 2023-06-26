package com.example.atm.service;

public class NotEnoughMoneyException extends Exception {
    @Override
    public String getMessage(){
        return "Not Enough Money at the ATM!";
    }
}
