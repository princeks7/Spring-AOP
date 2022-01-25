package com.princecode.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.princecode.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() +":Doing my Db Work: Addjing accout");
		
	}
	public boolean doWork() {
		
		System.out.println(getClass() +": Doing stuff: do work ");
		return true;
	}
}
