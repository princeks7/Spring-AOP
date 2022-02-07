package com.princecode.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.princecode.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @Around on method" + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n===> Duration: " + duration /1000.0 + " second");
		
		
		
		return result;
	}
	

	@After("execution(* com.princecode.aopdemo.dao.AccountDAO.findAccouts(..))")
	
	public void afterFinallyFindAccoutsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @After(Finally) method" + method);
		
	}
	
	
@AfterThrowing(pointcut ="execution(* com.princecode.aopdemo.dao.AccountDAO.findAccouts(..))",
                throwing="theExc" )

 public void afterThrowingFindAccoutsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
	 
	// print out which method we are advising on
	String method = theJoinPoint.getSignature().toShortString();
	System.out.println("\n===>>> Executing @AferThrowing method" + method);
	
	//log the exception
	System.out.println("\n====>> the exception is: " + theExc);
	
 }
	
	
	
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
