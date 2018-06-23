package xyz.kemix.java.test.junit3;

import junit.framework.TestCase;
import xyz.kemix.java.test.basic.Hello;

/**
 * Must be child class of the TestCase.
 * 
 * If need, should override the init method "setUp" and clean method "tearDown".
 * 
 * All test method must be like testXXX.
 * 
 * @author Kemix Koo
 *
 */
public class HelloJunit3Test extends TestCase {
    private Hello hello;

    public HelloJunit3Test() {
        super("Hello World Test");
    }

    /**
     * init method, need override
     */
    @Override
    protected void setUp() throws Exception {
        hello = new Hello();
    }

    /**
     * clean method, need override
     */
    @Override
    protected void tearDown() throws Exception {
        hello = null;
    }

    public void testSayHello() {
        String result = hello.sayHello("world");
        assertEquals("Hello world", result);
    }

    /**
     * never call for JUnit3
     */
    public void sayHello() {
        String result = hello.sayHello("world");
        assertEquals("Hello world", result);
    }
}
