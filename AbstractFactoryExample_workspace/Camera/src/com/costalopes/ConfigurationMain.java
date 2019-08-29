package com.costalopes;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class ConfigurationMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Configuration config = Configuration.loadConfigurations(args[0]);
		String location = config.getLocation();
		URL url = new URL(location);
		URLClassLoader ucl = new URLClassLoader(new URL[] {url});
		
		Class<ICameraFactory> clazz = (Class<ICameraFactory>) Class.forName(config.getFactoryType(), true, ucl);
		ICameraFactory cameraFactory = clazz.newInstance();
		
		ICamera camera = cameraFactory.createCamera();
		System.out.println(camera.takePhoto());
	}
	
}
