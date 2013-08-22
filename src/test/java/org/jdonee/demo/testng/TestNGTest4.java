package org.jdonee.demo.testng;

import org.testng.annotations.Test;

/**
 * 测试超时：如果测试案例执行有超过1秒 就会报错
 * @author Jdonee
 *
 */
public class TestNGTest4 {
	@Test(timeOut = 1000)  
	public void infinity() {  
		while (true);  //呵呵，这是死循环
	}  
}
