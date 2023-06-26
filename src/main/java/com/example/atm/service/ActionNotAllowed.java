package com.example.atm.service;

public class ActionNotAllowed extends Exception{
    @Override
    public String getMessage(){
        return "The action you performed is not allowed, please enter with a number higher then 0.00.";
    }
}
