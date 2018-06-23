package xyz.kemix.java.test.junit4;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import xyz.kemix.java.test.basic.Hello;

/**
 * 
 * @author Kemix Koo
 *
 */
public class HelloJunit4Test {
    private Hello hello;

    /**
     * Must be "public static void" without any args in method.
     * 
     * Can use annotation "@BeforeClass" for several methods.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // TODO
    }

    /**
     * Must be "public static void" without any args in method also.
     * 
     * Can use annotation "@AfterClass" for several methods.
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // TODO
    }

    /**
     * Must be "public void" without any args in method.
     * 
     * Can use annotation "@Before" for several methods.
     */
    @Before
    public void setUp() throws Exception {
        hello = new Hello();
    }

    /**
     * Must be "public void" without any args in method.
     * 
     * Can use annotation "@After" for several methods.
     */
    @After
    public void tearDown() throws Exception {
        hello = null;
    }

    @Category(FlagWorldTests.class) // flag interface
    @Test
    public void testSayHello() {
        String result = hello.sayHello("world");
        assertEquals("Hello world", result);
    }

    @Category(FlagAnimalTests.class) // flag interface
    @Test
    public void sayHelloCat() {
        String result = hello.sayHello("clever cat");

        // use hamcrest API
        assertThat(result, allOf(startsWith("Hello"), containsString("cat")));
        // Hello &&(clever||cat)
        assertThat(result, both(startsWith("Hello")).and( //
                either(containsString("clever")).or(containsString("cat"))//
        ));
    }

    @Category(FlagAnimalTests.class) // flag interface
    @Test
    public void testHelloDog() {
        String result = hello.sayHello("dog");
        assertThat(result, notNullValue());
        assertEquals("Hello dog", result);
        assertThat(result, is("Hello dog"));
    }
}
