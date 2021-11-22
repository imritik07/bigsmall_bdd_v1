package com.bigsmall.stepDefinitions;

import com.bigsmall.reusableComponents.BaseClass;

import io.cucumber.java.BeforeAll;

public class Hook extends BaseClass {
	@BeforeAll
	public static void init()
	{
		initializeReport();
	}
}
