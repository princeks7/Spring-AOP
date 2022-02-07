package com.princecode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalysticsAspect {

	@Before("com.princecode.aopdemo.aspect.PrinceAopExpression.forDaoPackageNoGetterSetter()")
	public void perforApiAnalytics() {
		System.out.println("\n===>>> Performing API analytics");
	}
}
