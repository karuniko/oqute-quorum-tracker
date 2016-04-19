package com.oqute.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
	
	private final static Logger log = Logger.getLogger(AuditAspect.class);
	
	@Around("execution (public * com.oqute.controller..*.*(..))")
	public Object audit(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		log.trace("method " + methodName + " started");
		Object result = pjp.proceed();
		log.trace("method " + methodName + "completed.");
		return result;
	}
}
