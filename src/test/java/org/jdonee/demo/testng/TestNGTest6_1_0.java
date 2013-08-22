package org.jdonee.demo.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化测试(配合Xml方式)
 * @author Jdonee
 *
 */
public class TestNGTest6_1_0 {
	
	@Test
	@Parameters(value="number")
	public void parameterIntTest(int number) {
	   System.out.println("Parameterized Number is : " + number);
	}

}
