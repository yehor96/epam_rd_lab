package com.epam.test.ht19.junit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * With JUnit it is also possible to group tests. Using @SelectPackages or @SelectClasses
 * we can run tests of particular package or a class. However, according to JUnit official
 * documentation, approach with @RunWith annotation is available using JUnit 4 runner only.
 */
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Grouping")
@SelectPackages("com.epam.test.ht19.junit")
public class JUnitGrouping {
}