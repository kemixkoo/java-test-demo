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

## Run test

Right click on project with menu "Run As -> JUnit Test"

![PowerMock Run](/powermock-runtest.png)