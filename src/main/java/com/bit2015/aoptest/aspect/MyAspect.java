package com.bit2015.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.bit2015.aoptest.vo.ProductVo;

@Aspect
@Component
public class MyAspect {
	@Before("execution(* *..service.*.*(..))")
	public void before() {
		// 메소드가 시작하는 시점에 동작하는 어드바이스
		System.out.println("call [before advice]");
	}

	@After("execution(* findProduct(..))")
	public void after() {
		// 메소드가 끝나는 시점에 동작하는 어드바이스
		System.out.println("call [after advice]");
	}

	@AfterReturning(value = "execution(* findProduct(..))", returning = "vo")
	public void afterReturning(ProductVo vo) {
		// 메소드가 반환 시점에 동작하는 어드바이스
		System.out.println("call [returning advice] : " + vo);
	}

	@Around("execution(* findProduct(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("call [around advice] - before ");
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Exception ex) {
			System.out.println("Exception 발생 :" + ex);
		}
		System.out.println("call [around advice] - after ");

		return result;
	}

	// @AfterThrowing(value = "execution(* findProduct(..))", throwing = "ex")
	// public void afterThrowing(Throwable ex) {
	// // 예외가 발생한 후에 동작하는 어드바이스
	// System.out.println("call [afterThrowing advice] : " + ex);
	// }
}
