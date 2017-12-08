/**
 * 
 */
package example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lenovo
 *
 */
@Aspect
public class SimpleLogging {
	
	@Pointcut("execution(* example.service.*.*(..))")
	private void selectAll(){}
	
	@Before("selectAll()")
	public void beforeAdvice(){
		System.out.println("SimpleLogging --> Before entering the method");
	}
	
	@After("selectAll()")
	public void afterAdvice(){
		System.out.println("SimpleLogging --> After the method");
	}
	
	@AfterReturning(pointcut = "selectAll()", returning="retVal")
	public void afterReturnAdvice(Object retVal){
		System.out.println("SimpleLogging --> Method returned successfully ");
		if (retVal !=null){
			retVal.toString();
		}
	}
	
	@AfterThrowing(pointcut = "selectAll()", throwing="iae")
	public void afterThrowAdvice(IllegalArgumentException iae){
		System.out.println("SimpleLogging --> Exception thrown " + iae.getMessage().toString());
	}
	
	@Around("selectAll()")
	public void aroundAdvice(){
		System.out.println("SimpleLogging --> Around advice");
	}

}
