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
	public boolean withdraw(double amount) { // signature -> parameters list
		if (amount <= 0) return false;
		if (amount > (balance+overdraftAmount)) return false;
		balance = balance - amount;
		return true;
	}


	
}
