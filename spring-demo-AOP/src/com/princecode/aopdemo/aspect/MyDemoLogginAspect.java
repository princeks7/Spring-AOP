package com.princecode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// this is where we add of our related advices for logging
	
	// let' start with an @Before advice
	
	@Before("execution( * com.princecode.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====> Executing @Before advice on addAccount()");
	}
}
