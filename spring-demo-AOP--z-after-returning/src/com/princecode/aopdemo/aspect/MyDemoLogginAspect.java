package com.princecode.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.princecode.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {

	// add a new advice for  @AfterReturnings on the findAccouts method
	
	@AfterReturning(pointcut="execution(* com.princecode.aopdemo.dao.AccountDAO.findAccouts(..))",
	                  returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @AferReturning on method" +method);
		
		// print out the results of the method call
		System.out.println("\n==>>> result is: " + result);
		
		// let's post-process the data .. let's modify it :-)
		
		//convert the account name to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n===>>> result is :" + result);
		
	}
		
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {

		
		// loop through accouts 
		
		for(Account tempAccount :result)
		{
		// get uppercase version of name
		String theUpperName = tempAccount.getName().toUpperCase();
		// update the name on the account
		tempAccount.setName(theUpperName);
	}
		
	}



	@Before("com.princecode.aopdemo.aspect.PrinceAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====> Executing @Before advice on method");
		
		
		// display the method signature
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// display the method argument 
		
		//get args 
		Object[] args = theJoinPoint.getArgs();
		// loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);
		
		if(tempArg instanceof Account) {
			
			// downcast and print Account specific stuff
			Account theAccount = (Account) tempArg;
			
			System.out.println("account name: " + theAccount.getName());
			System.out.println("account level: " + theAccount.getLevel());
						
		}
		}
		
		
	}
	
	
	
	
}
