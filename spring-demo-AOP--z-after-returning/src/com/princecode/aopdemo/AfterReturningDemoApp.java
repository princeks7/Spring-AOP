package com.princecode.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.princecode.aopdemo.DemoConfig;
import com.princecode.aopdemo.dao.AccountDAO;
import com.princecode.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read the Spring java class 
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		// call method to find the accounts
		List<Account> theAccounts =theAccountDAO.findAccouts(); 
		
		//display the accounts
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("---");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
	}

}
