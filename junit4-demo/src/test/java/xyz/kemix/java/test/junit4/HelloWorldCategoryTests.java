package xyz.kemix.java.test.junit4;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Do Categories test.
 * 
 * @author Kemix Koo
 *
 */
@RunWith(Categories.class) // runner
@IncludeCategory(FlagWorldTests.class) // flag interface
@SuiteClasses({ HelloJunit4Test.class }) // test classes
public class HelloWorldCategoryTests {
    // nothing
}
