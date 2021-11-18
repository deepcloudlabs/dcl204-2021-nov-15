package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.InsufficientBalanceException;

public class StudyPolymorphism {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InsufficientBalanceException {
		// Polymorphism -> i) Runtime
		Account acc; // T2
		if (ThreadLocalRandom.current().nextBoolean())
			acc = new Account("tr1", 1_000);
		else
			acc = new CheckingAccount("tr1", 1_000, 200);
		System.err.println(acc.getClass().getName());
		((Account) acc).withdraw(450);
		// ((Account)acc).getOverdraftAmount();
		Object o;
		o = 42;
		o = "jack";
		o = '\u20BA';
		o = new Account("tr3", 200_000);
		CheckingAccount ca = (CheckingAccount) acc;
		if (acc instanceof CheckingAccount)
			((CheckingAccount) acc).getOverdraftAmount();
	}

}
