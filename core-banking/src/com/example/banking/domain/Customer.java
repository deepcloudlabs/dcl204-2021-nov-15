package com.example.banking.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

// Entity -> Identity 
public class Customer {
	private final String tcKimlikNo;
	private String fullname;
	private List<Account> accounts; // One-to-Many: i) Array ii) Collection

	public Customer(String tcKimlikNo, String fullname) {
		this.tcKimlikNo = tcKimlikNo;
		this.fullname = fullname;
		accounts = new LinkedList<>();
	}

	public Customer(String tcKimlikNo, String fullname, List<Account> accounts) {
		this.tcKimlikNo = tcKimlikNo;
		this.fullname = fullname;
		this.accounts = accounts;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTcKimlikNo() {
		return tcKimlikNo;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public Optional<Account> closeAccount(String iban) {
		var account = getAccount(iban);
		if (account.isPresent()) {
			Account acc = account.get();
			double balance = acc.getBalance();
			if (balance > 0)
				try {
					acc.withdraw(balance);
				} catch (InsufficientBalanceException e) {
					System.err.println(e.getMessage());
				}
			accounts.remove(acc);
		}
		return account;
	}

	public Optional<Account> getAccount(String iban) {
		for (Account account : accounts) {
			if (iban.equals(account.getIban()))
				return Optional.of(account);
		}
		// throw new IllegalArgumentException("Cannot find iban");
		return Optional.empty();
	}

	public Optional<Account> getAccountStream(String iban) {
		// filter: higher order function
		return accounts.stream().filter(account -> account.getIban().equalsIgnoreCase(iban)).findFirst();
	}

	public Account getAccount(int index) {
		return accounts.get(index);
	}

	public int getNumberOfAccounts() {
		return accounts.size();
	}
}
