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

public class HelloJunit4Test {
    private Hello hello;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // TODO
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // TODO
    }

    @Before
    public void setUp() throws Exception {
        hello = new Hello();
    }

    @After
    public void tearDown() throws Exception {
        hello = null;
    }

    @Category(WorldTests.class)
    @Test
    public void testSayHello() {
        String result = hello.sayHello("world");
        assertEquals("Hello world", result);
    }

    @Category(AnimalTests.class)
    @Test
    public void sayHelloCat() {
        String result = hello.sayHello("clever cat");

        assertThat(result, allOf(startsWith("Hello"), containsString("cat")));
        //Hello &&(clever||cat)
        assertThat(result, both(startsWith("Hello")).and( //
                either(containsString("clever")).or(containsString("cat"))//
        ));
    }

    @Category(AnimalTests.class)
    @Test
    public void testHelloDog() {
        String result = hello.sayHello("dog");
        assertThat(result, notNullValue());
        assertEquals("Hello dog", result);
        assertThat(result, is("Hello dog"));
    }
}
