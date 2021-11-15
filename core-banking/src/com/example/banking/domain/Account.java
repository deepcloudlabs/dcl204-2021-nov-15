package com.example.banking.domain;

// Ctrl + Shift + + : Zoom in
// Ctrl + -         : Zoom out
// + Mouse Wheel
public class Account { 
	// Domain Class -> i) Entity Class, Identity -> iban
	//                ii) Value Object -> Immutable
	//               iii) Aggregate -> Entity Root 
	// Class -> Encapsulation: Members -> i) Data ii) Methods
	// attributes
	private final String iban; // attribute/state/data/property
	private double balance;

	// methods
	// i) constructor -> new object? -> constructor initializes state
	// Alt +Shift + O -> Alt + Insert
	public Account(String iban, double balance) {
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
	public boolean deposit(double amount) {
		if (amount <= 0.0) // validation
			return false;
		this.balance += amount; // this.balance = this.balance + amount;
		return true;
	}

	// (Eclipse) Ctrl + Shift + F -> (IntelliJ IDEA) Ctrl + Alt + L
	public boolean withdraw(double amount) {
		if (amount <= 0.0) // validation
			return false;
		if (amount > balance) // business rule
			return false;
		this.balance -= amount;
		return true;
	}
}
