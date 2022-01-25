package com.princecode.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.princecode.aopdemo.DemoConfig;
import com.princecode.aopdemo.dao.AccountDAO;
import com.princecode.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read the Spring java class 
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the Account business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		// do it again
	//   System.out.println("\n let's call it again\n");
	   
		// call the membership business method
		theMembershipDAO.addSillyAccount();
		theMembershipDAO.goToSleep();
		// close the context
		context.close();
	}

}
