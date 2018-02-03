/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 * A Class to hold all accounts
 * @author Raghavan
 */
public class AccountDirectory {
    
    private ArrayList<Account> accountLists;
    
    public AccountDirectory() {
        accountLists = new ArrayList<>();
    }

    public ArrayList<Account> getAccountLists() {
        return accountLists;
    }

    public void setAccountLists(ArrayList<Account> accountLists) {
        this.accountLists = accountLists;
    }
    
    public Account addAccount() {
        Account newAccount = new Account();
        accountLists.add(newAccount);
        return newAccount;
    }
    
    public void deleteAccount(Account accountObject) {
        accountLists.remove(accountObject);
    }
    
    public Account searchAccountsBy(String accountNumber) {
        for(Account a : accountLists)
            if(a.getAccountNumber().equals(accountNumber))
                return a;
        return null;
    }
}
