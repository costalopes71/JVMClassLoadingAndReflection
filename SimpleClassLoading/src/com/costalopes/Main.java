package com.costalopes;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

public class Main {

	public static void main(String[] args) {

		URL url;
		
		try {
			url = new URL("file:///media/16AC8619AC85F391/workspaces/Pluralsight_workspaces/JVMClassLoadingAndReflection_workspace/ClassPathExample/SimpleClassLoading/lib/Quoter.jar");
			URLClassLoader ucl = new URLClassLoader(new URL[]{url});
			Class clazz = ucl.loadClass("com.mantiso.Quote");
			Object o = clazz.newInstance();
			System.out.println(o.toString());
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
