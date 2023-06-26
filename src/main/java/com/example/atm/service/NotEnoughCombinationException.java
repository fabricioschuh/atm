package com.example.atm.service;

public class NotEnoughCombinationException extends Exception {
    @Override
    public String getMessage(){
        return "There are no more combinations of Bills and Coins available at the ATMService!";
    }
}
