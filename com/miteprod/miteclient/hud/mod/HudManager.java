package com.miteprod.miteclient.hud.mod;

import java.util.ArrayList;

import com.miteprod.miteclient.hud.mod.impl.CPSmod;
import com.miteprod.miteclient.hud.mod.impl.FPSMod;
import com.miteprod.miteclient.hud.mod.impl.Keystrokes;
import com.miteprod.miteclient.hud.mod.impl.PositionDisplay;
import com.miteprod.miteclient.hud.mod.impl.TargetHUD;
import com.miteprod.miteclient.hud.mod.impl.TestMod;

public class HudManager {
	
	public static ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public TestMod testMod;
	public FPSMod fps;
	public TargetHUD targetHud;
	public Keystrokes keystrokes;
	public PositionDisplay positionDisplay;
	public CPSmod cpsMod;
	
	public HudManager() {
		hudMods.add(testMod 		= new TestMod()			);
		hudMods.add(fps 			= new FPSMod()			);
		hudMods.add(targetHud 		= new TargetHUD()		);
		hudMods.add(keystrokes 		= new Keystrokes()		);
		hudMods.add(positionDisplay = new PositionDisplay()	);
		hudMods.add(cpsMod 			= new CPSmod()			);
	}
	
	public static ArrayList<HudMod> getHudMods() {
		return hudMods;
	}

	public void renderMods() {
		for (HudMod m : hudMods) {
			if(m.isEnabled()) {
				m.draw();
			}
		}
	}
	
}
