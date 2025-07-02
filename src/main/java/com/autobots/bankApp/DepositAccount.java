package com.autobots.bankApp;

public class DepositAccount extends BankAccount {

    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
        addTransaction("DEPOSIT", amount);
    }

    @Override
    public boolean withDraw(double amount) {
            if (amount <= 0) return false;
            if (amount <= balance) {
                balance -= amount;
                addTransaction("WITHDRAW", amount);
                return true;
            }
            return false;
        }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                ", currency=" + currency +
                ", transactions=" + transactions +
                '}';
    }
}
