package xyz.kemix.java.test.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import xyz.kemix.java.test.basic.Hello;

/**
 * There are 3 ways to mock one object via annotation (@Mock).
 * 
 * And, have 1 way to mock the object via API (Mockito.mock) directly.
 * 
 * @author Kemix Koo
 */
@RunWith(MockitoJUnitRunner.class) // 1. runner way
public class HelloMockitoRunnerTest {
    @Mock
    Hello hello;

    // 2. init way
    // @Before
    // public void setup() {
    // MockitoAnnotations.initMocks(this);
    // }

    // 3. rule way
    // @Rule
    // public MockitoRule mockito = MockitoJUnit.rule();

    @Test
    public void testSayHello() {
        // hello = mock(Hello.class); //4. API way
        when(hello.sayHello("world")).thenReturn("Hi");
        assertThat(hello.sayHello("world"), is("Hi"));
    }
}
