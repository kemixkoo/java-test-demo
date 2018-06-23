package xyz.kemix.java.test.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import xyz.kemix.java.test.basic.Hello;

/**
 * Base on JUnit4
 * 
 * @author Kemix Koo
 */
public class HelloMockitoTest {

    /**
     * Test mock object with return value and verify, also do reset to test.
     */
    @Test
    public void testSayHello_mock() {
        Hello hello = mock(Hello.class);

        when(hello.sayHello("world"))//
                .thenReturn("Hi, dog", "Hi, cat"); // return values
        /*
         * another way to return value one by one.
         */
        // when(hello.sayHello("world"))//
        // .thenReturn("Hi, dog").thenReturn("Hi, cat");

        assertThat(hello.sayHello("world"), is("Hi, dog")); // first value
        assertThat(hello.sayHello("world"), is("Hi, cat")); // second value

        // unknown value of arg
        assertThat(hello.sayHello("dog"), nullValue()); // no mock value

        // another value to mock
        when(hello.sayHello("boy")).thenReturn("Handsome");
        assertThat(hello.sayHello("boy"), is("Handsome"));

        // do verify the timeout and times to call.
        verify(hello, timeout(100).times(2)).sayHello("world");
        verify(hello, timeout(100).times(1)).sayHello("boy");
        verify(hello, timeout(100).atLeastOnce()).sayHello("dog");
        /*
         * can use lambda via argThat
         */
        // verify(hello, times(2)).sayHello(argThat(n -> n.endsWith("boy") || n.endsWith("dog")));

        // verify any values
        verify(hello, atMost(4)).sayHello(anyString());

        // clean all mock values.
        reset(hello);

        // then can't get the value now
        assertThat(hello.sayHello("world"), nullValue()); // null now

        verify(hello, times(1)).sayHello("world");

        // verify with description
        verify(hello, never().description("No boy")).sayHello("boy");
        verify(hello, never().description("No dog")).sayHello("dog");
    }

    /**
     * Do test via Behavior Driven Development (BDD) way
     * 
     * given -> when -> then
     */
    @Test
    public void testSayHello_bdd() {
        Hello hello = mock(Hello.class);
        // given(hello.sayHello("world"))//
        // .willReturn("Hi, dog", "Hi, cat");
        given(hello.sayHello("world"))//
                .willReturn("Hi, dog").willReturn("Hi, cat");

        // make sure the call with in order
        InOrder inOrder = inOrder(hello);

        // 1
        String world1 = hello.sayHello("world");
        assertThat(world1, is("Hi, dog"));
        // 2
        String world2 = hello.sayHello("world");
        assertThat(world2, is("Hi, cat"));

        // then(hello).should(times(2)).sayHello("world");
        then(hello).should(inOrder, times(2)).sayHello("world");
    }

    /**
     * mock with default value(Answer API)
     */
    @Test
    public void testSayHello_answer() {
        // default value always
        Hello hello = mock(Hello.class, new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return "who are you?";
            }
        });

        //
        when(hello.sayHello("world")).thenReturn("Hi, world");
        assertThat(hello.sayHello("world"), is("Hi, world"));

        // unknown one
        assertThat(hello.sayHello("dog"), is("who are you?"));

        // can set default answer for fixing values of arg
        when(hello.sayHello("cat")).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return "Hi, my clever " + invocation.getArgument(0);
            }
        });
        // JDK 8 with lambda
        // doAnswer(invocation -> "Hi, my clever " + invocation.getArgument(0)).when(hello).sayHello("cat");

        assertThat(hello.sayHello("cat"), is("Hi, my clever cat"));
    }

    /**
     * do test for spy one existed object. only mock the method when want.
     */
    @Test
    public void testSayHello_spy() {
        final Hello myHello = new Hello();
        Hello hello = spy(myHello);

        when(hello.sayHello("world")).thenReturn("Hi, world");

        //mocked value
        String world = hello.sayHello("world");
        assertThat(world, is("Hi, world"));

        // call real method, if no mock
        String dog = hello.sayHello("dog");
        assertThat(dog, is("Hello dog"));

        verify(hello, times(2)).sayHello(anyString());

        // clean mock
        reset(hello);

        //then, all will be real values
        world = hello.sayHello("world");
        assertThat(world, is("Hello world"));

        verify(hello, times(1)).sayHello(anyString());
    }

    /**
     * do test for exceptions.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSayHello_exception() {
        Hello hello = mock(Hello.class);
        
        //only have exception when call the value of mock.
        when(hello.sayHello("dog"))//
                .thenThrow(new IllegalArgumentException("Can't be dog"));
        // doThrow(new IllegalArgumentException("Can't be dog")) //
        // .when(hello).sayHello("dog");

        // hello.sayHello("world"); //no error
        hello.sayHello("dog");
    }

}
