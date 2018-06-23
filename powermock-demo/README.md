# PowerMock

- Support EasyMock
- Support Mockito
- Support TestNG


https://github.com/powermock/powermock/wiki/

## Mock

- mock static method
- mock final method
- mock private method
- mock constructor
- can't mock the classes in package java.lang, because it's in system classloader.

## Compatibility

When work with the Mockito, make sure use right version.

When I write this doc at Jun 2018, the 1.7.4 version can't be compatible with the version 2.18.3 for Mockito.
Must use old version like 2.8.47 instead.

## Issue of Constructor

If there is no any constructor for Object, will have error, when mock constructor. Must impl one default constructor.

Else will throw the exceptions:

```
org.mockito.exceptions.misusing.UnfinishedVerificationException: 
Missing method call for verify(mock) here:
 at xyz.kemix.java.test.powermock.HelloPowerMockTests.testConstructor(HelloPowerMockTests.java:39)

Example of correct verification:
    verify(mock).doSomething()

Also, this error might show up because you verify either of: final/private/equals()/hashCode() methods.
Those methods *cannot* be stubbed/verified.
Mocking methods declared on non-public parent classes is not supported.

    at xyz.kemix.java.test.powermock.HelloPowerMockTests.testConstructor(HelloPowerMockTests.java:39)
    ...

```

## Run test

Right click on project with menu "Run As -> JUnit Test"

![PowerMock Run](powermock-runtest.png)

Seems when use mock way, will spend more times to test.