package xyz.kemix.java.test.powermock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import xyz.kemix.java.test.basic.DelegateUtil;
import xyz.kemix.java.test.basic.Hello;

/**
 * 
 * @author Kemix Koo
 *
 */
@RunWith(PowerMockRunner.class) // must use the PowerMockRunner
@PrepareForTest({ DelegateUtil.class }) // the static classes must be set here
public class HelloPowerMockTests {

    /**
     * do test the constructor
     */
    @Test
    public void testConstructor() throws Exception {
        Hello hello = mock(Hello.class); // mock one object

        // when new one object without any args, will use the mock one instead
        whenNew(Hello.class) //
                .withNoArguments().thenReturn(hello);

        Hello myHello = new Hello(); // the object is mocked one now.

        // because didn't mock the method with value of arg, so will be null
        assertThat(myHello.sayHello("World"), nullValue());
    }

    /**
     * do test the static method
     */
    @Test
    public void testHelloHost() {
        final String user = System.getProperty("user.name");

        final Hello hello = new Hello(); // new real object

        assertThat(hello.helloUser(), is("Hi " + user)); // real call

        // do mock way
        mockStatic(DelegateUtil.class);// must mock the static class first.

        when(DelegateUtil.getUser()).thenReturn("Baishan"); // mock the method of static classes

        assertThat(hello.helloUser(), is("Hi Baishan")); // mocked value

        verifyStatic(DelegateUtil.class, atLeastOnce()); // verify the times to call
    }
}
