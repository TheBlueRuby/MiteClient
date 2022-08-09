package com.miteprod.miteclient.mod.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.miteprod.miteclient.MiteClient;
import com.miteprod.miteclient.mod.Category;
import com.miteprod.miteclient.mod.Mod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoGG extends Mod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public ArrayList<String> endGameMessageList = new ArrayList<String>();
	
	public void initArrayList() {
		endGameMessageList.add("1st Killer - ");
		endGameMessageList.add("1st Place - ");
		endGameMessageList.add("Winner: ");
		endGameMessageList.add(" - Damage Dealt - ");
		endGameMessageList.add("Winning Team -");
		endGameMessageList.add("1st - ");
		endGameMessageList.add("Winners: ");
		endGameMessageList.add("Winner: ");
		endGameMessageList.add("Winning Team: ");
		endGameMessageList.add(" won the game!");
		endGameMessageList.add("Top Seeker: ");
		endGameMessageList.add("1st Place: ");
		endGameMessageList.add("Last team standing!");
		endGameMessageList.add("Winner #1 ");
		endGameMessageList.add("Top Survivors");
		endGameMessageList.add("Winners - ");
		endGameMessageList.add("Sumo Duel - ");
		
	}
	

	public AutoGG() {
		super("Auto GG", "Gives you karma every hypixel round", Category.MISC);
	}
	
	@Override
	public void onEnable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("AutoGG Enabled!"));
		MiteClient.INSTANCE.eventManager.register(this);
		initArrayList();
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("AutoGG Disabled!"));
		MiteClient.INSTANCE.eventManager.unregister(this);
	}
	
	
	@SubscribeEvent
	public void sayGG(ClientChatReceivedEvent event) {
		System.out.println("Message Received! Checking to see if it should trigger a GG");
		String message = event.message.getUnformattedText();
        message = EnumChatFormatting.getTextWithoutFormattingCodes(message);
		for (int i = 0; i < endGameMessageList.size(); i++) {
			if(message.contains(endGameMessageList.get(i))) {
				mc.thePlayer.sendChatMessage("gg");
				System.out.println("GG Sent!");
			}
		}
	}
	
}
