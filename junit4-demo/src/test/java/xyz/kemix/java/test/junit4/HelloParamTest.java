package xyz.kemix.java.test.junit4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import xyz.kemix.java.test.basic.Hello;

/**
 * Do test with parameters.
 * 
 * @author Kemix Koo
 *
 */
@RunWith(Parameterized.class) // Parameterized runner
public class HelloParamTest {
    private String expected;
    private String name;

    /**
     * 
     * @param expected,
     *            value of test
     * @param name,
     *            value of arg
     */
    public HelloParamTest(String expected, String name) {
        super();
        this.expected = expected;
        this.name = name;
    }

    /**
     * If want to test several values with same case, set values in arrays.
     */
    @Parameters
    public static Collection setup() {
        return Arrays.asList(new String[][] { { "Hello world", "world" }, { "Hello cat", "cat" }, { "Hello dog", "dog" } });
    }

    @Test
    public void testSayHello() {
        Hello hello = new Hello();
        //use the args to do test
        assertEquals(expected, hello.sayHello(name));
    }
}
