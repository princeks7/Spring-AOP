package com.princecode.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.princecode.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	// add a new method: findAccouts()
	
	public List<Account> findAccouts(){
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts 
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Maham", "Platinm");
		Account temp3 = new Account("Luca", "Gold");
		// add them to our account list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	
	
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() +":Doing my Db Work: Addjing accout");
		
	}
	public boolean doWork() {
		
		System.out.println(getClass() +": Doing stuff: do work ");
		return true;
	}
	public String getName() {
		System.out.println(getClass() +"in getName ");
		
		return name;
	}
	public String getServiceCode() {
		System.out.println(getClass() +"in getServiceCode");
		return serviceCode;
	}
	public void setName(String name) {
		System.out.println(getClass() +" in setName");
		this.name = name;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +"in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
