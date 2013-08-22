package org.jdonee.demo.testng;

import org.testng.annotations.Test;

/**
 * 忽略测试
 * @author Jdonee
 *
 */
public class TestNGTest3 {
	
	@Test(enabled=false)
	public void divisionWithException() {  
	  System.out.println("Method is not ready yet");
	}  

}
