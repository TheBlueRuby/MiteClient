package com.miteprod.miteclient.mod.impl;

import com.miteprod.miteclient.mod.Category;
import com.miteprod.miteclient.mod.Mod;

import net.minecraft.potion.Potion;

import com.miteprod.miteclient.event.EventManager;
import com.miteprod.miteclient.event.EventTarget;
import com.miteprod.miteclient.event.impl.EventUpdate;

public class ToggleSprint extends Mod {
	public ToggleSprint() {
		super("ToggleSprint", "Toggles sprint so you don't have to hold ctrl", Category.MISC);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (this.isEnabled() 
				&& !mc.thePlayer.isBlocking() 
				&& !mc.thePlayer.isSneaking() 
				&& (mc.thePlayer.motionX != 0 && mc.thePlayer.motionZ !=0)
				&& !mc.thePlayer.isCollidedHorizontally
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				&& !mc.gameSettings.keyBindBack.isKeyDown()
				) {
			mc.thePlayer.setSprinting(true);
		}

	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		mc.thePlayer.setSprinting(false);
		
	}
	
}
