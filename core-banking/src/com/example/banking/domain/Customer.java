package com.example.banking.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

	public Account closeAccount(String iban) {
		Account account = getAccount(iban);
		double balance = account.getBalance();
		if (balance > 0)
			account.withdraw(balance);
		if (Objects.nonNull(account))
			accounts.remove(account);
		return account;
	}

	public Account getAccount(String iban) {
		for (Account account : accounts) {
			if (iban.equals(account.getIban()))
				return account;
		}
		return null;
	}

	public Account getAccount(int index) {
		return accounts.get(index);
	}

	public int getNumberOfAccounts() {
		return accounts.size();
	}
}
