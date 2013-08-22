package org.jdonee.demo.junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * 参数化测试:参数仅仅支持String和基本数据类型
 * @author Jdonee
 *
 */
@RunWith(value = Parameterized.class)
public class JunitTest6 {

	private final Object number;
	 
	 public JunitTest6(Object number) {
	    this.number = number;
	 }

	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { { 1 }, { "second" }, { 1.1d }, { 3.2222 } };
	   return Arrays.asList(data);
	 }

	 @Test
	 public void pushTest() {
	   System.out.println("Parameterized Number is : " + number);
	 }
}
