package com.example.test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TestClass {

	private static final String FILE_NAME = "META-INF/test.properties";

	private boolean fileFound = false;

	public TestClass() {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		
		// When called through onOpen, these will be the same.
		// When called through onMessage they will be different.
		System.out.println("    Local Class Loader  : " + this.getClass().getClassLoader().getClass().getName());
		System.out.println("    Context Class Loader: " + contextClassLoader.getClass().getName());
		
		try {
			Enumeration<URL> urls = contextClassLoader.getResources(FILE_NAME);
			if (urls.hasMoreElements()) {
			    System.out.println("    File Found: " + urls.nextElement());
			    fileFound = true;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		if (fileFound) {
		    System.out.println("    Found files on classpath\n");
		} else {
		    System.out.println("    Didn't find files on classpath\n");
		}
	}

	public String getValue() {
		return fileFound + "";
	}
}