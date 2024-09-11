package com.rs.game.cityhandler.impl;

import com.rs.cores.CoresManager;
import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.cityhandler.CityEvent;
import com.rs.game.cityhandler.CityEventHandler;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.content.FadingScreen;
import com.rs.utils.Logger;

public class Rellekka implements CityEvent{

	public static final int JARVALD_RELLEKKA = 2437;
	public static final int JARVALD_WATERBIRTH = 2438;
	
	public static final int ENTRANCE_CAVE_TROLL = 5008;
	public static final int EXIT_CAVE_TROLL = 5014;
	public static final int ENTRANCE_CAVE_2ND_TROLL = 5012;
	public static final int EXIT_CAVE_2ND_TROLL = 5013;
	public static final int ENTRANCE_KELDAGRIM = 5973;
	public static final int EXIT_KELDAGRIM = 5998;
	
	@Override
	public boolean init() {
				registerObject(ENTRANCE_CAVE_2ND_TROLL, this);
				registerObject(EXIT_CAVE_2ND_TROLL, this);
				registerObject(ENTRANCE_CAVE_TROLL, this);
				registerObject(EXIT_CAVE_TROLL, this);
				registerObject(ENTRANCE_KELDAGRIM, this);
				registerObject(EXIT_KELDAGRIM, this);
			 	registerNPC(JARVALD_WATERBIRTH, this);
		return  registerNPC(JARVALD_RELLEKKA, this);
	}

	@Override
	public boolean handleNPCClick(Player player, NPC npc) {
		return false;
	}

	@Override
	public boolean handleNPCClick2(Player player, NPC npc) {
		int id = npc.getId();
		if(id == JARVALD_RELLEKKA) {
			NextFadeWorlTile(player, new WorldTile(2550, 3759, 0));
			return true;
		}
		else if(id == JARVALD_WATERBIRTH) {
			player.sm("teste");
			NextFadeWorlTile(player, new WorldTile(2620, 3685, 0));
			return true;
		}
		return false;
	}

	@Override
	public boolean handleNPCClick3(Player player, NPC npc) {
		return false;
	}

	@Override
	public boolean handleNPCClick4(Player player, NPC npc) {
		return false;
	}
	
	@Override
	public boolean handleObjectClick(Player player, WorldObject object) {
		int id = object.getId();
		
		if(id == ENTRANCE_CAVE_TROLL) {
			player.setNextWorldTile(new WorldTile(2773, 10162, 0));
			return true;
		}else if(id == EXIT_CAVE_TROLL) {
			player.setNextWorldTile(new WorldTile(2730, 3713, 0));
			return true;
		}
		
		else if(id == ENTRANCE_KELDAGRIM) {
			NextFadeWorlTile(player, new WorldTile(2838, 10124, 0));
			return true;
		}else if(id == EXIT_KELDAGRIM) {
			NextFadeWorlTile(player, new WorldTile(2780, 10161, 0));
			return true;
		}
		
		else if(id == ENTRANCE_CAVE_2ND_TROLL) {
			player.setNextWorldTile(new WorldTile(2799, 10134, 0));
			return true;
		}else if(id == EXIT_CAVE_2ND_TROLL) {
			player.setNextWorldTile(new WorldTile(2796, 3719, 0));
			return true;
		}
		
		return false;
	}

	@Override
	public boolean handleObjectClick2(Player player, WorldObject object) {
		return false;
	}

	@Override
	public boolean handleObjectClick3(Player player, WorldObject object) {
		return false;
	}

	@Override
	public boolean handleObjectClick4(Player player, WorldObject object) {
		return false;
	}

	@Override
	public boolean handleObjectClick5(Player player, WorldObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleItemOnObject(Player player, WorldObject object, Item item) {
		// TODO Auto-generated method stub
		return false;
	}
	
	boolean registerNPC(int npcId, CityEvent cityevent) {
		return CityEventHandler.registerNPCs(npcId, this);
	}

	boolean registerObject(int objectId, CityEvent cityEvent) {
		return CityEventHandler.registerObjects(objectId, this);
	}
	
	public static void NextFadeWorlTile(Player player, WorldTile tile) {
		player.lock(5);
		final long time = FadingScreen.fade(player);
		CoresManager.slowExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					FadingScreen.unfade(player, time, new Runnable() {
						@Override
						public void run() {
							player.setNextWorldTile(tile);
						}
					});
				} catch (Throwable e) {
					Logger.handle(e);
				}
			}
		});
	}

}
