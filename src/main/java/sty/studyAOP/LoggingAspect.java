package sty.studyAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    /**
     * 前置通知
     */
    @Before(value = "execution(public int sty.studyAOP.AriCalculatorImpl.add(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspect===> The Method " + methodName + " begin.");
    }

    /**
     * 后置通知
     */
    @After(value = "execution(* sty.studyAOP.*.*(..))")//可以作用于该包下的任意方法
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("Logging Aspect===> The Method " + methodName + " end.");
    }

    /**
     * 返回通知
     */
    @AfterReturning(value = "execution(* sty.studyAOP.*.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logging Aspect===> the method " + methodName + " end with:" + result);
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* sty.studyAOP.*.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getName();
        System.out.println("Logging Aspect===> the method " + name + " occurs Exception: " + ex);
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* sty.studyAOP.*.*(..))")
    public Object aroundMehod(ProceedingJoinPoint pjp) {
        try {
            //前置通知
            Object obj = pjp.proceed();
            //返回通知
            return obj;
        } catch (Throwable throwable) {
            //异常通知
            throwable.printStackTrace();
        } finally {
            //后置通知
        }
        return null;
    }
}
