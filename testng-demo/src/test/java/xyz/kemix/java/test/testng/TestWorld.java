package xyz.kemix.java.test.testng;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import xyz.kemix.java.test.basic.Hello;

/**
 * 
 * @author Kemix Koo
 *
 */
public class TestWorld {

    /**
     * do test in 5 times and 5 threads in one group.
     */
    @Test(groups = "world", invocationCount = 5, threadPoolSize = 5)
    public void sayHello5Times() {
        Hello hello = new Hello();
        String actual = hello.sayHello("World");
        Assert.assertEquals(actual, "Hello World");
    }

    /**
     * depend on another method to test, if the metho is failed, then this will be failed directly too.
     */
    @Test(groups = "dog", dependsOnMethods = { "sayHello" })
    public void sayHelloDog() {
        Hello hello = new Hello();
        String actual = hello.sayHello("dog");
        Assert.assertEquals(actual, "Hello dog");
    }

    /**
     * parameters test with one name which set in testng.xml.
     */
    @Parameters({ "name" })
    @Test(groups = "param")
    public void sayHello(String name) {
        Hello hello = new Hello();
        String actual = hello.sayHello(name);
        Assert.assertEquals(actual, "Hello " + name);
    }

    @Test(groups = "dog")
    public void sayHelloDogs() {
        Hello hello = new Hello();
        String actual = hello.sayHello("dogs");
        Assert.assertEquals(actual, "Hello dogs");
    }
}
