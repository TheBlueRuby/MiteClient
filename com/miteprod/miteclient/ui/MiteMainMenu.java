package com.miteprod.miteclient.ui;

import java.awt.Color;
import java.io.IOException;

import com.miteprod.miteclient.MiteClient;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class MiteMainMenu extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

		mc.getTextureManager().bindTexture(new ResourceLocation("miteclient/menu/main_menu.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		this.drawCenteredString(mc.fontRendererObj, MiteClient.INSTANCE.NAME, width/2f, (height/2f - mc.fontRendererObj.FONT_HEIGHT/2f) - 10, -1);
		GlStateManager.popMatrix();
		
		mc.fontRendererObj.drawStringWithShadow(MiteClient.INSTANCE.VERSION, width/2f + 60, height/2f - mc.fontRendererObj.FONT_HEIGHT * 2f, new Color(0, 255, 0, 255).getRGB());
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		
		MiteClient.INSTANCE.getDiscordRP().update("Idle", "Main Menu");
		
		this.buttonList.add(new GuiButton(1, width/2 - 100, height / 2     , 200, 20, "Singleplayer"));
		this.buttonList.add(new GuiButton(2, width/2 - 100, height / 2 + 25, 200, 20, "Multiplayer" ));
		this.buttonList.add(new GuiButton(3, width/2 +   5, height / 2 + 50,  95, 20, "Options"     ));
		this.buttonList.add(new GuiButton(4, width/2 - 100, height / 2 + 50,  95, 20, "Exit Game"   ));
		
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if (button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if (button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if (button.id == 4) {
			mc.shutdown();
		}
		
		super.actionPerformed(button);
	}
	
}
