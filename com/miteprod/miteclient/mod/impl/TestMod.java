package com.miteprod.miteclient.mod.impl;

import com.miteprod.miteclient.mod.Category;
import com.miteprod.miteclient.mod.Mod;

public class TestMod extends Mod {
	public TestMod() {
		super("TestMod", "Test Mod", Category.MISC);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		System.out.println("Mod Is On");

	}
	
}
