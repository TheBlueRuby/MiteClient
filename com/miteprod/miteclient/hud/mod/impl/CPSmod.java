package com.miteprod.miteclient.hud.mod.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import com.miteprod.miteclient.hud.mod.HudMod;

import net.minecraft.client.gui.Gui;

public class CPSmod extends HudMod {
	
	public CPSmod() {
		super("CPS Display", 200, 200);
	}

	List<Long> lmbClicks = new ArrayList<Long>();
	private boolean lmbWasPressed;
	private Long lmbLastPressed;
	
	List<Long> rmbClicks = new ArrayList<Long>();
	private boolean rmbWasPressed;
	private Long rmbLastPressed;
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("20 CPS 20");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
	@Override
	public void draw() {
		
		final boolean lmbPressed = Mouse.isButtonDown(0);
		
		if(lmbPressed != this.lmbWasPressed)
		{
			this.lmbLastPressed = System.currentTimeMillis();
			this.lmbWasPressed = lmbPressed;
			if(lmbPressed) {
				this.lmbClicks.add(this.lmbLastPressed);
			}
		}
		
		final boolean rmbPressed = Mouse.isButtonDown(1);
		
		if(rmbPressed != this.rmbWasPressed)
		{
			this.rmbLastPressed = System.currentTimeMillis();
			this.rmbWasPressed = rmbPressed;
			if(rmbPressed) {
				this.rmbClicks.add(this.rmbLastPressed);
			}
		}
		
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 100).getRGB());
		fr.drawString(getLmbCPS() + " CPS " + getRmbCPS(), getX(), getY(), -1);
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 100).getRGB());
		fr.drawString("20 CPS 20", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	private int getLmbCPS() {
		
		final Long time = System.currentTimeMillis();
		this.lmbClicks.removeIf(aLong -> aLong + 1000 < time);
		return this.lmbClicks.size();
		
	}


	private int getRmbCPS() {
		
		final Long time = System.currentTimeMillis();
		this.rmbClicks.removeIf(aLong -> aLong + 1000 < time);
		return this.rmbClicks.size();
		
	}
	
}