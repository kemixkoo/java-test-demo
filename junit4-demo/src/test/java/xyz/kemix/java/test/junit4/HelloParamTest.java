package xyz.kemix.java.test.junit4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import xyz.kemix.java.test.basic.Hello;

@RunWith(Parameterized.class)
public class HelloParamTest {
    private String expected;
    private String name;

    public HelloParamTest(String expected, String name) {
        super();
        this.expected = expected;
        this.name = name;
    }

    @Parameters
    public static Collection addedNumbers() {
        return Arrays.asList(new String[][] {
            { "Hello world", "world" }, 
            { "Hello cat", "cat" }, 
            { "Hello dog", "dog" } });
    }

    @Test
    public void testSayHello() {
        Hello hello=new Hello();
        assertEquals(expected, hello.sayHello(name));
    }
}
