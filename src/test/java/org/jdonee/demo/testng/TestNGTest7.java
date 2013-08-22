package org.jdonee.demo.testng;

import org.testng.annotations.Test;

/**
 * 依赖测试
 * @author Jdonee
 *
 */
public class TestNGTest7 {
	
	@Test
	public void method1() {
	   System.out.println("This is method 1");
	}
 
	@Test(dependsOnMethods={"method1"})
	public void method2() {
		System.out.println("This is method 2");
	}

}
