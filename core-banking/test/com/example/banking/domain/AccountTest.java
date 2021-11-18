package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

// CUT: Class Under Test
class AccountTest { // CUT -> Account

	// MUT : Method Under Test
	@ParameterizedTest
	@DisplayName("creates an Account object successfuly")
	@CsvFileSource(resources = "/accounts.csv")
	void createAccountObjectWithSuccess(String iban, double balance) {
		// 1. Fixture/Setup
		// 2. Call Exercise Method
		Account acc = new Account(iban, balance);
		// 3. Verification
		assertNotNull(acc);
		assertEquals(iban, acc.getIban());
		assertEquals(balance, acc.getBalance());
		// 4. Tear-down
	}

	@Test
	@DisplayName("deposit with negative amount should throw IllegalArgumentException")
	void depositWithNegativeAmountFails() throws Exception {
		// 1. Fixture/Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Call Exercise Method
		assertThrows(IllegalArgumentException.class, () -> acc.deposit(-1) );
		// 3. verification
		assertEquals(1_000, acc.getBalance());
		// 4. Tear-down
	}

	@Test
	@DisplayName("deposit with positive amount should success")
	void depositWithPositiveAmountSuccess() throws Exception {
		// 1. Fixture/Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Call Exercise Method
		acc.deposit(1);
		// 3. verification
		assertEquals(1_001, acc.getBalance());
		// 4. Tear-down
	}

	@Test
	@DisplayName("withdraw with negative amount should throw IllegalArgumentException")
	void withdrawWithNegativeAmountFails() throws Exception {
		// 1. Fixture/Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Call Exercise Method
		assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-1) );
		// 3. verification
		assertEquals(1_000, acc.getBalance());
		// 4. Tear-down
	}

	@Test
	@DisplayName("withdraw with amount above balance should throw InsufficientBalanceException")
	void withdrawWithAmountAboveBalanceFails() throws Exception {
		// 1. Fixture/Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Call Exercise Method
		assertThrows(InsufficientBalanceException.class, () ->  acc.withdraw(1_001) );
		// 3. verification
		assertEquals(1_000, acc.getBalance());
		// 4. Tear-down
	}

	@Test
	@DisplayName("withdraw all balance should success")
	void withdrawAllBalanceSuccess() throws Exception {
		// 1. Fixture/Setup
		Account acc = new Account("tr1", 2);
		// 2. Call Exercise Method
		acc.withdraw(1.1);
		// 3. verification
		assertEquals(0.9, acc.getBalance(), 0.0001);
		// 4. Tear-down
	}

	@Test
	@DisplayName("toString")
	void toStringTest() throws Exception {
		// 1. Fixture/Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Call Exercise Method
		// 3. verification
		assertTrue(acc.toString().startsWith("Account"));
		// 4. Tear-down
	}
}
