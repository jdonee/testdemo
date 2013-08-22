package org.jdonee.demo.testng;

import org.jdonee.demo.testng.model.Simple;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 参数化测试(@DataProvider方式[普通类])
 * @author Jdonee
 *
 */
public class TestNGTest6_3_1 {
	@Test(dataProvider = "Data-Provider-Function")
	public void parameterIntTest(Simple clzz) {
	   System.out.println("Parameterized Number is : " + clzz.getMsg());
	   System.out.println("Parameterized Number is : " + clzz.getNumber());
	}
 
	//This function will provide the patameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() {
 
		Simple obj = new Simple();
		obj.setMsg("Hello");
		obj.setNumber(123);
 
		return new Object[][]{
			{obj}
		};
	}	
}
