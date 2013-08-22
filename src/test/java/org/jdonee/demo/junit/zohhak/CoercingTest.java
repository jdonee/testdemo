package org.jdonee.demo.junit.zohhak;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.offset;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

/**
 * 第三方Junit参数测试框架(above junit 4.11)
 * @author Jdonee
 *
 */
@RunWith(ZohhakRunner.class)
public class CoercingTest {

	/**
	 * 测试计算
	 * @param addend1
	 * @param addend2
	 * @param result
	 */
	@TestWith({ "2, 1, 3", "3, 5, 8" })
	public void adding(int addend1, int addend2, int result) {
		assertThat(addend1 + addend2).isEqualTo(result);
	}

	/**
	 * 测试基本数据类型
	 * @param c
	 * @param b
	 * @param s
	 * @param i
	 * @param f
	 * @param d
	 * @param l
	 * @param bool
	 */
	@TestWith("c, 10, -13, 15, 1.5, 2.3, 7, true")
	public void coercingWrappers(Character c, Byte b, Short s, Integer i,
			Float f, Double d, Long l, Boolean bool) {
		// works also with primitives
		assertThat(c).isEqualTo('c');
		assertThat(b).isEqualTo((byte) 10);
		assertThat(s).isEqualTo((short) -13);
		assertThat(i).isEqualTo(15);
		assertThat(f).isEqualTo(1.5f, offset(0.0001f));
		assertThat(d).isEqualTo(2.3, offset(0.0001));
		assertThat(l).isEqualTo(7);
		assertThat(bool).isTrue();
	}

	/**
	 * 测试枚举
	 * @param param
	 */
	@TestWith("ONE_OF_ENUM_VALUES")
	public void coerceEnum(SampleEnum param) {
		assertThat(param).isEqualTo(SampleEnum.ONE_OF_ENUM_VALUES);
	}

	/**
	 * 测试对象是否为空
	 * @param whateverType
	 */
	@TestWith("null")
	public void coerceNull(WhateverType whateverType) {
		assertThat(whateverType).isNull();
	}

	/**
	 * 测试字符串
	 * @param trimmed
	 * @param untrimmed
	 */
	@TestWith(" john doe , ' john doe ' ")
	public void coerceString(String trimmed, String untrimmed) {
		assertThat(trimmed).isEqualTo("john doe");
		assertThat(untrimmed).isEqualTo(" john doe ");
	}

	@Test
	public void testRegularJunit() {
		System.out.println("@Test - testRegularJunit");
	}
}
