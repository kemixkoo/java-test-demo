package xyz.kemix.java.test.junit5;

import static java.time.Duration.ofMillis;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.condition.OS.LINUX;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import xyz.kemix.java.test.basic.Hello;

/**
 * 
 * @author Kemix Koo
 *
 */
@DisplayName("Test JUnit5 for horses")
public class HelloJunit5Tests {

    @DisabledOnOs(LINUX) // no test in linux
    @RepeatedTest(value = 5, name = "第{currentRepetition}轮{displayName}测试") // use the inner vars
    @DisplayName("♞♘")
    public void helloHorse(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions()); // verify the repeated times

        final Hello hello = new Hello();
        assertTimeout(ofMillis(1000), () -> { // test in 1s
            assertAll("horses", () -> {
                final String blackHorse = hello.sayHello("black horse");
                assertNotNull(blackHorse);
                assertAll("black horse", //
                        () -> assertThat(blackHorse, startsWith("Hello")), //
                        () -> assertThat(blackHorse, containsString("black")), //
                        () -> assertThat(blackHorse, endsWith("horse")));
            }, () -> {
                final String whiteHorse = hello.sayHello("white horse");
                assertNotNull(whiteHorse);
                assertAll("white horse", //
                        () -> assertThat(whiteHorse, startsWith("Hello")), //
                        () -> assertThat(whiteHorse, containsString("white")), //
                        () -> assertThat(whiteHorse, endsWith("horse")));
            });
        });
    }

    /**
     * do parameters test
     */
    @ParameterizedTest(name = "第{index}次我想要{0}马") // use inner var with arg value
    @ValueSource(strings = { "赤兔", "的卢", "白龙" }) // values of args
    @DisplayName("宝马测试")
    public void helloBestHorse(String name) {
        final Hello hello = new Hello();
        final String blackHorse = hello.sayHello(name + "马");
        assertAll("宝马", //
                () -> assertThat(blackHorse, startsWith("Hello")), //
                () -> assertThat(blackHorse, containsString(name)));
    }

}
