package com.onlineinteract.beansspel.entitlements;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.onlineinteract.beansspel.model.Game;

@Aspect
@Component
@Order(EntitlementsAspect.ENTITLEMENTS_ORDER)
public class EntitlementsAspect {
	
	static final int ENTITLEMENTS_ORDER = 100;

	@Autowired
	@Qualifier(value = "rock")
	Game game;

	@Around(value = "execution(public * com.onlineinteract.beansspel.rest..*Controller.*(..))")
	public void authorize(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("**** Do we get here? ****");
		game.setVolume(14);
		pjp.proceed();
	}
}
