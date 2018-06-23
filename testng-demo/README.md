# TestNG

https://testng.org/

## Annotations vs JUnit4

JUnit 4 | TestNG
------------ | -------------
<None>  |   @BeforeSuite / @AfterSuite
<None>  |   @BeforeTest / @AfterTest
<None>  |   @BeforeGroups / @AfterGroups
@BeforeClass / @AfterClass | @BeforeClass / @AfterClass
@Before / @After  |  @BeforeMethod / @AfterMethod
@Ignore | @Test(enable=false)
@Test(expected = XXX.class) | @Test(expectedExceptions = XXX.class)
@Test(timeout = 1000)  |  @Test(timeout = 1000)
org.junit.Assert |   org.testng.Assert

## Life Cycle

![TestNG Life Cycle](/testng-lifecycle.png)

## Run test

Like in Eclipse IDE, if don't install the TestNG plugins, need install from Eclipse Marketplace first.

Then, right click on testng.xml with menu "Run As -> TestNG Suite"

![TestNG Run](/testng-runtest.png)