package org.jdonee.demo.testng;

import org.testng.annotations.Test;

/**
 * 分组测试
 * @author Jdonee
 *
 */
public class TestNGTest5_2_0 {
	
	@Test(groups="method1")
	public void testingMethod1() {  
	  System.out.println("Method - testingMethod1()");
	}  
 
	@Test(groups="method2")
	public void testingMethod2() {  
		System.out.println("Method - testingMethod2()");
	}  
 
	@Test(groups="method1")
	public void testingMethod1_1() {  
		System.out.println("Method - testingMethod1_1()");
	}  
 
	@Test(groups="method4")
	public void testingMethod4() {  
		System.out.println("Method - testingMethod4()");
	}    
}
