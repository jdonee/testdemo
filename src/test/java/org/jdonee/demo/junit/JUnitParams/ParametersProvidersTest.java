package org.jdonee.demo.junit.JUnitParams;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.internal.ParameterisedTestMethodRunner;
import junitparams.internal.TestMethod;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

@RunWith(JUnitParamsRunner.class)
public class ParametersProvidersTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    @Parameters(source = SingleParamSetProvider.class)
    public void oneParamSetFromClass(String a, String b) {
    }

    public static class SingleParamSetProvider {
        public static Object[] provideOneParamSetSameTypes() {
            return $($("a", "b"));
        }
    }

    @Test
    public void shouldPutProviderClassNameInExceptionMessageForProviderWithNoValidMethods() {
        ParameterisedTestMethodRunner runner = new ParameterisedTestMethodRunner(getTestMethodWithInvalidProvider());

        exception.expect(RuntimeException.class);
        exception.expectMessage(ProviderClassWithNoValidMethods.class.getName());
        runner.method.parametersSets();
    }

    private TestMethod getTestMethodWithInvalidProvider() {
        Method testMethod = TestClassWithProviderClassWithNoValidMethods.class.getMethods()[0];
        return new TestMethod(new FrameworkMethod(testMethod), new TestClass(TestClassWithProviderClassWithNoValidMethods.class));
    }

    @RunWith(JUnitParamsRunner.class)
    static class TestClassWithProviderClassWithNoValidMethods {
        @Test
        @Parameters(source = ProviderClassWithNoValidMethods.class)
        public void shouldDoNothingItsJustToConnectTestClassWithProvider() {
        }
    }

    static class ProviderClassWithNoValidMethods {
    }

    @Test
    @Parameters(source = OneIntegerProvider.class)
    public void providedPrimitiveParams(int integer) {
        assertTrue(integer < 4);
    }

    public static class OneIntegerProvider {
        public static Object[] provideTwoNumbers() {
            return $($(1), $(2));
        }

        public static Object[] provideOneNumber() {
            return new Object[] { $(3) };
        }
    }

    @Test
    @Parameters(source = DomainObjectProvider.class)
    public void providedDomainParams(DomainClass object1, DomainClass object2) {
        assertEquals("dupa1", object1.toString());
        assertEquals("dupa2", object2.toString());
    }

    public static class DomainObjectProvider {
        public static Object[] provideDomainObject() {
            return new Object[] { new Object[] {
                    new DomainClass("dupa1"),
                    new DomainClass("dupa2") } };
        }
    }

    public static class DomainClass {
        private final String name;

        public DomainClass(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
