package fr.wonyu.orthyong.proxy;

import java.io.File;

public class OrthyonClientProxy extends OrthyonCommonProxy {

	@Override
	public void preInit(File config) {
		super.preInit(config);
		System.out.println("Pré init client");
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void postInit() {
		super.postInit();
	}

}
