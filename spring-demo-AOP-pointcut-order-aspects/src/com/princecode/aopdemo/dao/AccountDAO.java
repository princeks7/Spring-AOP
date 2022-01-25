package com.princecode.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.princecode.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
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
