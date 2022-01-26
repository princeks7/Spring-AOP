package com.princecode.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyAccount() {
		
		System.out.println(getClass()+":Doing Stuff:Adding a membership accout");
		
		return true;
		
		
	}

	public void goToSleep() {
		
		System.out.println(getClass()+":go to sleep ");
}
}
