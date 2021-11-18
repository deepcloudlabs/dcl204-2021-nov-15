package com.example.banking.domain;

// Sub-class/Derived Class: CheckingAccount
// Super-class/Base-class : Account
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance); // call signature: (String,double) -- matches --> definition signature
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException { // signature -> parameters list
		System.err.println("CheckingAccount::withdraw");
		if (amount <= 0)
			throw new IllegalArgumentException("Amount must be a positive number!");
		if (amount > (balance + overdraftAmount))
			throw new InsufficientBalanceException("Your balance does not cover your expenses!", amount-balance-overdraftAmount);
		balance = balance - amount;
		return;
	}

}
