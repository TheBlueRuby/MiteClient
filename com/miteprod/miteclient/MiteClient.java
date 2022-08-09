package com.miteprod.miteclient;

import org.lwjgl.opengl.Display;

import com.miteprod.miteclient.discord.DiscordRP;
import com.miteprod.miteclient.event.EventManager;
import com.miteprod.miteclient.event.EventTarget;
import com.miteprod.miteclient.event.impl.EventUpdate;
import com.miteprod.miteclient.event.impl.ClientTick;
import com.miteprod.miteclient.hud.HUDConfigScreen;
import com.miteprod.miteclient.hud.mod.HudManager;
import com.miteprod.miteclient.hud.mod.impl.CPSmod;
import com.miteprod.miteclient.mod.ModManager;
//import com.miteprod.miteclient.util.SessionChanger;
import com.miteprod.miteclient.util.config.Config;

import net.minecraft.client.Minecraft;

public class MiteClient {

	public String NAME = "Mite Client", VERSION = "1.0.3 Alpha", AUTHOR = "TheBlueRuby", NAMEVER = NAME + " " + VERSION;
	public static final MiteClient INSTANCE = new MiteClient();
	public Minecraft mc = Minecraft.getMinecraft();
	
	private DiscordRP discordRP = new DiscordRP();
	
	public boolean hasSent = false;
	
	public EventManager eventManager;
	public Config config;
	public ModManager modManager;
	public HudManager hudManager;	
	
	public void startup() {
		eventManager = new EventManager();
		config = new Config();
		modManager = new ModManager();
		config.loadModConfig();
		hudManager = new HudManager();
		
		Display.setTitle(NAMEVER);
		
		System.out.println("Starting " + NAMEVER + " by " + AUTHOR);
		discordRP.start();
		
		eventManager.register(this);
	}
	
	public void shutdown() {
		config.saveModConfig();
		
		System.out.println("Shutting Down " + NAMEVER);
		discordRP.shutdown();

		eventManager.unregister(this);
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.AUTO_GG.isPressed()) {
			modManager.autoGG.toggle();
		}
		if(mc.gameSettings.keyBindSprint.isPressed()) {
			modManager.toggleSprint.toggle();
		}
		if (mc.gameSettings.CLICK_GUI.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
}
