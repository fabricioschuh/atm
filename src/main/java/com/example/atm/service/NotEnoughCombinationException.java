package com.example.atm.service;

public class NotEnoughCombinationException extends Exception {
    @Override
    public String getMessage(){
        return "There are not possible combination of Bills and Coins at the ATMService!";
    }
}
