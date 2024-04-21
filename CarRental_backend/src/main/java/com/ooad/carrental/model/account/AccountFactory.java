package com.ooad.carrental.model.account;

public class AccountFactory {
    public static Account getAccount(AccountType accountType){
        switch(accountType){
            case USER:
                return new User();
            case ADMIN:
                return new Admin();
            default:
                return null;
        }
    }
}
