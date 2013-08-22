package org.jdonee.demo.junit;

import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit Ignore Test:忽略测试
 * @author Jdonee
 *
 */
public class JunitTest3 {
	@Ignore("Not Ready to Run")  
	@Test
	public void divisionWithException() {  
	  System.out.println("Method is not ready yet");
	}  

}
