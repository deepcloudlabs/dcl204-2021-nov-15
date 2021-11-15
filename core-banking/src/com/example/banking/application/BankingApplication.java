package com.example.banking.application;

import com.example.banking.domain.Account;

// Ctrl + Shift + O -> Organize Imports
// Ctrl + 1
public class BankingApplication {
	public static void main(String[] args) {
		Account acc = new Account("tr1", 1_000); // creates an object
		acc.withdraw(500);
		System.err.println("Balance: "+acc.getBalance());
		acc.withdraw(500);
		System.err.println("Balance: "+acc.getBalance());
		acc.withdraw(500);
		System.err.println("Balance: "+acc.getBalance());
	}
}
