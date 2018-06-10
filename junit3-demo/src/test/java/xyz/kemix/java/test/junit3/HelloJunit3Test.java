package xyz.kemix.java.test.junit3;

import junit.framework.TestCase;
import xyz.kemix.java.test.basic.Hello;

public class HelloJunit3Test extends TestCase {
    private Hello hello;

    public HelloJunit3Test() {
        super("Hello World Test");
    }

    @Override
    protected void setUp() throws Exception {
        hello = new Hello();
    }

    @Override
    protected void tearDown() throws Exception {
        hello = null;
    }

    public void testSayHello() {
        String result = hello.sayHello("world");
        assertEquals("Hello world", result);
    }

    public void sayHello() {
        String result = hello.sayHello("world");
        assertEquals("Hello world", result);
    }
}
