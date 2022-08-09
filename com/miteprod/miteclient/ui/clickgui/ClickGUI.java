package com.miteprod.miteclient.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import com.miteprod.miteclient.MiteClient;
import com.miteprod.miteclient.hud.mod.HudMod;
import com.miteprod.miteclient.ui.clickgui.comp.ModButton;
import com.miteprod.miteclient.hud.mod.HudManager;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class ClickGUI extends GuiScreen {
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		super.initGui();
		for(int i = 0; i < com.miteprod.miteclient.hud.mod.HudManager.getHudMods().size(); i++) {
			this.modButtons.add(new ModButton(210, 60 + i*10, 240, mc.fontRendererObj.FONT_HEIGHT, com.miteprod.miteclient.hud.mod.HudManager.getHudMods().get(i)));
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		Gui.drawRect(200, 50, sr.getScaledWidth() - 100, sr.getScaledHeight() - 50, new Color(0, 0, 0, 100).getRGB());
		
		for (ModButton m : modButtons) {
			m.draw();
		}
		
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}
	
}
