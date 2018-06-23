package xyz.kemix.java.test.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Do Suite test.
 * 
 * @author Kemix Koo
 *
 */
@RunWith(Suite.class) // runner
@Suite.SuiteClasses({ HelloJunit4Test.class }) // test classes
public class HelloSuiteTest {
    // nothing
}
