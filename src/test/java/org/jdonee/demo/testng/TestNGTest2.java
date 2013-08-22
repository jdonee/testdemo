package org.jdonee.demo.testng;

import org.testng.annotations.Test;

/**
 * TestNG异常测试
 * @author Jdonee
 *
 */
public class TestNGTest2 {

	@Test(expectedExceptions = ArithmeticException.class)  
	public void divisionWithException() {  
	  int i = 1/0;
	}  
}
