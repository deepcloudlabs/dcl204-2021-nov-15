package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.InsufficientBalanceException;

// Ctrl + Shift + O -> Organize Imports
// Ctrl + 1
public class BankingApplication {
	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc1 = new Account("tr1", 1_000); // creates an object
		acc1.withdraw(500);
		System.err.println("Balance: " + acc1.getBalance());
		acc1.withdraw(500);
		System.err.println("Balance: " + acc1.getBalance());
		acc1.withdraw(500);
		System.err.println("Balance: " + acc1.getBalance());
		System.err.println(acc1.toString());
		Account acc2 = new Account("tr1", 2_000); // creates an object
		System.err.println("acc1.equals(acc2): " + acc1.equals(acc2));
	}
}
