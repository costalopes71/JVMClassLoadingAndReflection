package com.costalopes;

public class NikonCameraFactory implements ICameraFactory {

	@Override
	public ICamera createCamera() {
		return new NikonCamera();
	}

}
