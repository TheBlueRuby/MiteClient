package com.miteprod.miteclient.hud.mod;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import com.miteprod.miteclient.MiteClient;
import com.miteprod.miteclient.hud.DraggableComponent;
import com.miteprod.miteclient.settings.Setting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class HudMod {

	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	
	public ArrayList<Setting> settings;
	
	public String name;
	public boolean enabled;
	public DraggableComponent drag;
	
	public int x, y;
	
	public HudMod(String name, int x, int y) {
		this.name = name;
		
		try {
			this.x = (int) MiteClient.INSTANCE.config.config.get(name + " x");
			this.y = (int) MiteClient.INSTANCE.config.config.get(name + " y");
			this.setEnabled((boolean) MiteClient.INSTANCE.config.config.get(name + " enabled"));


		} catch (NullPointerException e) {
			e.printStackTrace();
			this.x = x;
			this.y = y;
			this.enabled = false;
		}
		
		settings = new ArrayList<Setting>();
		drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());
		
	}
	
	public void addSettings(Setting...sets) {
		//this.settings.add((Setting) Arrays.asList(sets));
	}
	
	public int getWidth() {
		return 50;
	}
	
	public int getHeight() {
		return 50;

	}
	
	public void draw() {
		
	}
	
	public void renderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);
	}
	
	public int getX() {
		return drag.getxPosition();
	}
	
	public int getY() {
		return drag.getyPosition();
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggle() {
		this.setEnabled(!enabled);

	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
}
