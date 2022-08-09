package com.miteprod.miteclient.hud.mod.impl;

import com.miteprod.miteclient.hud.DraggableComponent;
import com.miteprod.miteclient.hud.mod.HudMod;

import java.awt.Color;
import java.lang.Math;

import net.minecraft.client.gui.Gui;

public class PositionDisplay extends HudMod {
	
	public PositionDisplay() {
		super("PositionDisplay", 5, 5);
	}
	
	private static double round (double value, int precision) {
	    int scale = (int) Math.pow(10, precision);
	    return (double) Math.round(value * scale) / scale;
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 100).getRGB());
		fr.drawString("Current Position:"		 		   , getX(), getY()					  , -1);
		fr.drawString("X:§a " + round(mc.thePlayer.posX, 1), getX(), getY() + fr.FONT_HEIGHT  , -1);
		fr.drawString("Y:§a " + round(mc.thePlayer.posY, 1), getX(), getY() + fr.FONT_HEIGHT*2, -1);
		fr.drawString("Z:§a " + round(mc.thePlayer.posZ, 1), getX(), getY() + fr.FONT_HEIGHT*3, -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString("Current Position:", getX(), getY()					, -1);
		fr.drawString("X:§a " + 30000000 , getX(), getY() + fr.FONT_HEIGHT  , -1);
		fr.drawString("Y:§a " + 30000000 , getX(), getY() + fr.FONT_HEIGHT*2, -1);
		fr.drawString("Z:§a " + 30000000 , getX(), getY() + fr.FONT_HEIGHT*3, -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("Current Position: ");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT*4;
	}
	
}
