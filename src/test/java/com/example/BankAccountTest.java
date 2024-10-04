package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    //// test balance: positive & negative balance:
    // constructor positive balance
    @Test
    public void PositiveBalance() {
        BankAccount account = new BankAccount(100.0);
        assertEquals(100.0, account.getBalance());
    }

    // constructor negative balance
    @Test
    public void NegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-50.0));
    }

    //// test deposit both positive & negative amount:
    // constructor positive amount
    @Test
    public void PositiveAmountDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    // constructor negative amount
    @Test
    public void NegativeAmountDeposit() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    //// withdraw positive and negative:
    // withdraw positive
    @Test
    public void PositiveAmountWithdraw() {
        BankAccount account = new BankAccount(150.0);
        account.withdraw(50.0);
        assertEquals(100.0, account.getBalance());
    }

    // withdraw negative
    @Test
    public void NegativeAmountWithdraw() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    //// both test deposit and test withdraw with zero amount:
    // test deposit with zero amount
    @Test
    public void ZeroAmountTestDeposit() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }

    // test withdraw with zero amount
    @Test
    public void ZeroAmountTestWithdraw() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    //// withdraw sufficient funds with both positive amount and negative amount:
    // withdraw with sufficient funds with positive amount
    @Test
    public void SufficientFundsPositiveAmount() {
        BankAccount account = new BankAccount(150.0);
        account.withdraw(50.0);
        assertEquals(100.0, account.getBalance());
    }

    // withdraw with sufficient funds with negative amount
    @Test
    public void SufficientFundsNegativeAmount() {
        BankAccount account = new BankAccount(150.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    //// withdraw InSufficient funds with both positive amount and negative amount:
    // withdraw InSufficient funds with positive amount
    @Test
    public void InsufficientFundsPositiveAmount() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    // withdraw InSufficient funds with negative amount
    @Test
    public void InsufficientFundsNegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-200.0));
    }
}