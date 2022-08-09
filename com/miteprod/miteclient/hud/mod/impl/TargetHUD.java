package com.miteprod.miteclient.hud.mod.impl;
import com.miteprod.miteclient.hud.DraggableComponent;
import com.miteprod.miteclient.hud.mod.HudMod;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;

public class TargetHUD extends HudMod {
	EntityLivingBase target;
	
	public TargetHUD() {
		super("Target HUD", 150, 150);
	}
	
	@Override
	public void draw() {
		renderTargetHud();
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX(), getY(), getX() + fr.getStringWidth("Target Name"), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("Target Name", getX() + 2, getY() + 2, -1);
		//Disallowed on Hypixel fr.drawStringWithShadow(20 + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth("Target Name "), getY() + 30, 20, 50, 0, mc.thePlayer);

		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		if(target != null) {
			return fr.getStringWidth(target.getName()) + 70;
		} else {
			return 70;
		}
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 15;
	}
	
	private void renderTargetHud() {
		if(!(mc.pointedEntity instanceof EntityItemFrame)) {
			target = (EntityLivingBase) mc.pointedEntity;
		}
		
		if(target != null) {
			Gui.drawRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
			fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
			//Disallowed on Hypixel fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
			GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(target.getName()) + 25, getY() + 30, 20, 50, 0, target);

		}

	}
	
}
