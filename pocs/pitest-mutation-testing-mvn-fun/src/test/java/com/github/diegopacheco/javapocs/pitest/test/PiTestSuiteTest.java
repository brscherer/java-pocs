package com.github.diegopacheco.javapocs.pitest.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.github.diegopacheco.javapocs.pitest.test")
@IncludePackages("com.github.diegopacheco.javapocs.pitest.test")
public class PiTestSuiteTest {}