package org.jdonee.demo.junit;

import org.junit.Test;

/**
 * JUnit Expected Exception Test
 * 
 * @author Jdonee
 * 
 */
public class JunitTest2 {

	@Test(expected = ArithmeticException.class)
	public void divisionWithException() {
		System.out
				.println("since this is an expected exception, so the unit test will pass");
		int i = 1 / 0;
	}

}
