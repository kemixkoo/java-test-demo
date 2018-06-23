package xyz.kemix.java.test.junit4;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author Kemix Koo
 *
 */
@RunWith(Categories.class) //runner
@IncludeCategory(FlagAnimalTests.class) //flag interface
@SuiteClasses({ HelloJunit4Test.class }) //test classes
public class HelloAnimalCategoryTests {
    // nothing
}
