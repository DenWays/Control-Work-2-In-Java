package org.example;

import java.time.LocalDate;
import java.util.Calendar;

public class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Введено отрицательное значение");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance)
            throw new IllegalArgumentException("Недостаточно средств");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CardAccount extends BankAccount {
    public CardAccount() {
        super();
    }

    @Override
    public void withdraw(double amount) {
        if (amount > super.getBalance())
            throw new IllegalArgumentException("Недостаточно средств");
        amount = amount + amount * 0.01;
        super.setBalance(super.getBalance() - amount);
    }
}

class DepositAccount extends BankAccount {
    private LocalDate lastIncome;
    public DepositAccount() {
        super();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        lastIncome = LocalDate.now();
    }

    @Override
    public void withdraw(double amount) {
        if (amount > super.getBalance())
            throw new IllegalArgumentException("Недостаточно средств");
        if (lastIncome.plusDays(30).getDayOfMonth() <= LocalDate.now().getDayOfMonth()) {
            super.setBalance(amount);
        }
    }
}
