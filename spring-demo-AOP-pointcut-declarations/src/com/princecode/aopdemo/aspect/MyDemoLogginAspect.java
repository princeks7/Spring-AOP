package com.princecode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// this is where we add of our related advices for logging
	
	// let' start with an @Before advice
	
	@Pointcut("execution( * com.princecode.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void perforApiAnalytics() {
		System.out.println("\n===>>> Performing API analytics");
	}
}
