package com.princecode.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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

		
	@Before("com.princecode.aopdemo.aspect.PrinceAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====> Executing @Before advice on method");
		
		
		// diaplay the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// dislay the method argument 
		
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
