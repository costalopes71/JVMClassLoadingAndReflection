package com.costalopes;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.pluralsight.IQuote;

public class Main {

	public static void main(String[] args) {
		
		try {
			URL url1 = new URL("file:///tmp/implemantations.jar");
			URLClassLoader ucl1 = new URLClassLoader(new URL[] {url1});
			Class clazz1 = Class.forName("com.pluralsight.Quote", true, ucl1);
			IQuote quote1 = (IQuote) clazz1.newInstance();
			
			URL url2 = new URL("file:///tmp/implemantations.jar");
			URLClassLoader ucl2 = new URLClassLoader(new URL[] {url2});
			Class clazz2 = Class.forName("com.pluralsight.Quote", true, ucl2);
			IQuote quote2 = (IQuote) clazz2.newInstance();
			
			System.out.println("clazz1 == clazz2 " + (clazz1 == clazz2));
			System.out.println("quote1 == quote2 " + (quote1.getClass() == quote2.getClass()));
			
		} catch (MalformedURLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
