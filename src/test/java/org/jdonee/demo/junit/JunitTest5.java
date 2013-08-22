package org.jdonee.demo.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 
 * @RunWith和@Suite在一起使用进行套件测试
 * @author Jdonee
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        JunitTest1.class,
        JunitTest2.class
})
public class JunitTest5 {

}
