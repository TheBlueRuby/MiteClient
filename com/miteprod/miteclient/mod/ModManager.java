package com.miteprod.miteclient.mod;

import java.util.ArrayList;

import com.miteprod.miteclient.mod.impl.*;

public class ModManager {
	
	public TestMod testmod;
	public ToggleSprint toggleSprint;
	public AutoGG autoGG;
	
	public ArrayList<Mod> mods;
	
	public ModManager() {
		mods = new ArrayList<>();
		
		//Misc Mods
		mods.add(testmod 	  = new TestMod()	  );
		mods.add(toggleSprint = new ToggleSprint());
		mods.add(autoGG		  = new AutoGG()	  );
		
		
	}
	
	
	
}
