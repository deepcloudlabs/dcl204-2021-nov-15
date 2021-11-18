package com.example.banking.domain;

import java.util.Objects;

// Ctrl + Shift + + : Zoom in
// Ctrl + -         : Zoom out
// + Mouse Wheel
public class Account {
	// Domain Class -> i) Entity Class, Identity -> iban
	// ii) Value Object -> Immutable
	// iii) Aggregate -> Entity Root
	// Class -> Encapsulation: Members -> i) Data ii) Methods
	// attributes
	private final String iban; // attribute/state/data/property
	protected double balance; // default permission -> package private

	// methods
	// i) constructor -> new object? -> constructor initializes state
	// Alt +Shift + O -> Alt + Insert
	public Account(String iban, double balance) { // Signature: (String,double)
		super();
		this.iban = iban;
		this.balance = balance;
	}
	// getter/setter methods

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public void deposit(double amount) {
		if (amount <= 0.0) // validation
			throw new IllegalArgumentException("Amount must be a positive number!");
		this.balance += amount; // this.balance = this.balance + amount;
		return;
	}

	// (Eclipse) Ctrl + Shift + F -> (IntelliJ IDEA) Ctrl + Alt + L
	public void withdraw(double amount) throws InsufficientBalanceException {
		System.err.println("Account::withdraw");
		if (amount <= 0.0) // validation
			throw new IllegalArgumentException("Amount must be a positive number!");
		if (amount > balance) // business rule
			throw new InsufficientBalanceException("Your balance does not cover your expenses!", amount-balance);
		this.balance -= amount;
		return;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(iban);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(iban, other.iban);
	}

}
