package com.zhong.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 4.SpringAOP注释的类型有5种

	@Before 前置通知 在方法执行前执行
	
	@After 后置通知 在方法执行后执行
	
	@AfterThrowing 异常通知 在方法抛出异常之后执行
	
	@AfterReturning 返回通知 在方法返回结果之后执行
	
	@Around 环绕通知 环绕着方法执行
	
	5.创建一个切面类（包含@Before @After @AfterThrowing @AfterReturning）
 * @author admin
 *
 */
@Component
@Aspect
public class MyTxAspect {
	private final Logger logger = LoggerFactory.getLogger(MyTxAspect.class);

	// 使用Pointcut定义切点
	@Pointcut(value = "execution(public * com.zhong.dao.*.*(..))")
	public void daoPointCut() {

	}

	/**
	 * 应用切入点函数
	 */
	@Before(value = "daoPointCut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info(joinPoint.toString());
		String methodName = joinPoint.getSignature().getName();
		logger.info(methodName);
		System.out.println("before method execute,args are " + Arrays.toString(joinPoint.getArgs()));
	}

	@After("daoPointCut()")
	public void afterMethod(JoinPoint jp) {
		System.out.println("after method execute,args are " + Arrays.toString(jp.getArgs()));
	}

	@AfterThrowing(value = "daoPointCut()", throwing = "ex")
	public void afterThrow(Exception ex) {
		System.out.println("afterThrow" + ex.getMessage());
	}

	@AfterReturning(value = "daoPointCut()", returning = "result")
	public void afterReturn(Object result) {
		System.out.println("the result is " + result);
	}

	@Around(value = "daoPointCut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Object result = null;
		String methodName = pjp.getSignature().getName();
		try {
			result = pjp.proceed();
			System.out.println("the result is " + result);
		} catch (Throwable e) {
			System.out.println("Exception occurs : " + e.getMessage());
			throw new RuntimeException(e);
		}
		System.out.println(methodName + " end");

		return result;
	}

}
