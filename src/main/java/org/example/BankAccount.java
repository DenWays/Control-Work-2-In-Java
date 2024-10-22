//В проекте найдите класс BankAccount и унаследованные от него классы CardAccount
//и DepositAccount. Реализуйте методы классов, при необходимости переопределите
//методы в наследниках так, чтобы выполнялись условия пополнения и снятия:
//BankAccount — пополнение и списание происходит без комиссии. Если передать в
//метод пополнения отрицательное значение, сумма на счёте не должна измениться.
//При попытке снять большую сумму, чем есть на счёте, сумма не списывается со
//счёта, сумма на счёте не изменяется. CardAccount — карточный счёт, в дополнение к
//условиям BankAccount — при снятии денег должна взиматься комиссия 1% от суммы
//списания. Пример: при попытке снять со счёта 100 рублей должен списаться 101
//рубль. DepositAccount — депозитный расчётный счёт, в дополнение к условиям
//BankAccount — нельзя снимать деньги в течение одного месяца после последнего
//пополнения. Переменную, в которой хранится дата последнего внесения, назовите
//lastIncome. Тип переменной используйте Calendar или LocalDate.
//Для каждого класса провести модульное тестирование основных методов класса.
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
        if (amount < 0)
            throw new IllegalArgumentException("Введено отрицательное значение");
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
        if (amount < 0)
            throw new IllegalArgumentException("Введено отрицательное значение");
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
        if (amount < 0)
            throw new IllegalArgumentException("Введено отрицательное значение");
        super.deposit(amount);
        lastIncome = LocalDate.now();
    }

    @Override
    public void withdraw(double amount) {
        if (amount > super.getBalance())
            throw new IllegalArgumentException("Недостаточно средств");
        if (amount < 0)
            throw new IllegalArgumentException("Введено отрицательное значение");
        if (lastIncome.plusDays(30).getDayOfMonth() <= LocalDate.now().getDayOfMonth()) {
            super.setBalance(amount);
        }
    }
}
