package org.jdonee.demo.junit;

import org.junit.Test;

/**
 * 测试超时：如果测试案例执行有超过1秒 就会报错
 * @author Jdonee
 *
 */
public class JunitTest4 {
	@Test(timeout = 1000)  
	public void infinity() {  
		while (true);  //呵呵，这是死循环
	}  
}
