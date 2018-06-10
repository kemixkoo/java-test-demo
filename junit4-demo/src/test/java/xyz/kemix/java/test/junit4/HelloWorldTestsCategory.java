package xyz.kemix.java.test.junit4;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(WorldTests.class)
@SuiteClasses({ HelloJunit4Test.class })
public class HelloWorldTestsCategory {
    // nothing
}
