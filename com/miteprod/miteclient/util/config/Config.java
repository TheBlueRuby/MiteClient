package com.miteprod.miteclient.util.config;

import java.io.File;
import java.io.IOException;

import com.miteprod.miteclient.MiteClient;
import com.miteprod.miteclient.hud.mod.HudMod;

public class Config {
	
	public File configFolder = new File("MiteClient");
	public File modsFolder   = new File("MiteClient/mods");
	
	public Configuration config, configToSave = ConfigurationAPI.newConfiguration(new File("MiteClient/mods/modConfig.mcfg"));
	
	public void saveModConfig() {
		
		if (!configFolder.exists()) {
			configFolder.mkdirs();
		}
		if (!modsFolder.exists()) {
			modsFolder.mkdirs();
		}
		
		System.out.println("Saving Mod Configs");
		
		for(HudMod m : MiteClient.INSTANCE.hudManager.hudMods) {
			configToSave.set(m.name + " x"	    , m.getX() 	   );
			configToSave.set(m.name + " y"	    , m.getY()	   );
			configToSave.set(m.name + " enabled", m.isEnabled());
		}
		
		try {
			configToSave.save();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
	}
	
	public void loadModConfig() {
		System.out.println("Loading Configs!");
		try {
			config = ConfigurationAPI.loadExistingConfiguration(new File("MiteClient/mods/modConfig.mcfg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
