package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;

// Entity -> Identity 
public class Customer {
	private final String tcKimlikNo;
	private String fullname;
	private List<Account> accounts; // One-to-Many: i) Array ii) Collection
	
	public Customer(String tcKimlikNo, String fullname) {
		this.tcKimlikNo = tcKimlikNo;
		this.fullname = fullname;
		accounts = new ArrayList<>();
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
		
	}

	public Account closeAccount(String iban) {
		
	}

	public Account findAccount(String iban) {
		
	}

	public Account getAccount(int index) {
		
	}

	public int getNumberOfAccounts() {
		
	}
}
