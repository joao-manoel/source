package com.rs.game.player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rs.Settings;
import com.rs.game.World;
import com.rs.game.item.Item;
import com.rs.game.player.content.Commands;
import com.rs.game.player.content.friendschat.FriendChatsManager;

public class StarterProtection {

	private static List<String> StarterIPS = new ArrayList<String>();
	public static final int MAX_STARTER_COUNT = 1;

	private static final String Path = "data/starter/starterIPS.txt";
	
	public static void addStarter(Player player) {
		player.recievedStarter = true;
	}

	public static void addStarterIP(String IP) {
		if (IP == null) {
			return;
		}
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(Path));
			String line;
			while ((line = reader.readLine()) != null)
				StarterIPS.add(line);
			reader.close();
			StarterIPS.add(0, IP);
			writer = new BufferedWriter(new FileWriter(Path));
			for (String list : StarterIPS)
				writer.write(list + "\r\n");
			System.err.print(IP + " has just been added to the log. \n");
		} catch (Exception e) {
			System.err.print(IP + " was not added to starter list.");
		} finally {
			assert reader != null;
			assert writer != null;
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {

			}
		}
	}

	public static void loadIPS() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(Path));
		String line;
		StarterIPS.clear();
		while ((line = br.readLine()) != null) {
			StarterIPS.add(line);
		}
		br.close();
	}

	public static final void sendStarterPack(final Player player) {
		addStarter(player);
		player.reset();
		
		
		
		player.sm("Experience rate: " + Settings.SKILLING_XP_RATE + "x for skilling, 1x in wilderness for combat.");
		World.sendWorldMessage(
				"<img=5><col=b25200>News: " + player.getDisplayName() + " has joined " + Settings.SERVER_NAME + "!",
				false);
		if (player.getCurrentFriendChat() == null) {
			FriendChatsManager.joinChat(Settings.HELP_CC_NAME, player, true);
			FriendChatsManager.refreshChat(player);
		}
		player.toggles.put("ONEXHITS", false);
		player.toggles.put("ONEXPPERHIT", false);
		player.toggles.put("HEALTHBAR", true);
		player.toggles.put("DROPVALUE", 10000);
		player.toggles.put("LOOTBEAMS", true);
		player.switchShiftDrop();
		//player.switchZoom();
		player.switchItemsLook();
		/*
		if (Settings.ECONOMY_MODE > 0) {
			player.getControlerManager().startControler("EdgevillePvPControler");
			player.getControlerManager().moved();
		}
		*/
		String ip = player.getSession().getIP();
        int count = StarterMap.getSingleton().getCount(ip);
        player.starter = 1;
        if (count >= MAX_STARTER_COUNT) {
        	player.sm(
					"<col=99000><u>You have already received the max amount of starter packs registered on your IP address.");
                return;
        }
		StarterMap.getSingleton().addIP(ip);
		Commands.commandsMessage(player);
		//addStarterIP(player.getSession().getIP());
			Item[] inventory = { new Item(1351, 1), new Item(590, 1), new Item(303, 1), new Item(315, 1),
					new Item(1925, 1), new Item(1931, 1), new Item(2309, 1), new Item(1265, 1), new Item(1205, 1),
					new Item(1277, 1), new Item(1171, 1), new Item(841, 1), new Item(882, 25), new Item(556, 25),
					new Item(558, 15), new Item(555, 6), new Item(557, 4), new Item(559, 2) };
			for (Item items : inventory)
				player.getInventory().addItem(items);
			player.getMoneyPouch().addMoney(2000000, false);
	}

	public static final boolean containsIP(String ip) {
		return StarterIPS.contains(ip);
	}

}