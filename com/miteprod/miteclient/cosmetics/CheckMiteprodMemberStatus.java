package com.miteprod.miteclient.cosmetics;

import java.util.UUID;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;


public class CheckMiteprodMemberStatus {
	public static boolean isMiteprodMember(AbstractClientPlayer player) {
		
		String playerUUID = player.getUUID(player.getGameProfile()).toString();
		
		if 		  (playerUUID.equals("73b978f9-08fb-4e3c-bc42-9a7181d539c7")  ) {		//TheBlueRuby
			return true;
		} else if (playerUUID.equals("afec22fa-61b1-4e6c-9c22-f9aca4008620")  ) {		//Zaethar
			return true;
		} else if (playerUUID.equals("21a283ce-e056-408e-b146-bfde17d43701")  ) {		//BixBox
			return true;
		} else if (playerUUID.equals("844171db-e5c9-4546-8b97-5a9aa5477bbd")  ) {		//PandarificJTL
			return true;
		}
		
		else return false;
	}
}
