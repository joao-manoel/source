package com.rs.game.cityhandler.impl;

import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.cityhandler.CityEvent;
import com.rs.game.cityhandler.CityEventHandler;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;

public class Keldagrim implements CityEvent{

	private static final int STAIRS_CLIMDOWN = 6088;
	private static final int STAIRS_CLIMDOWN_TOP = 6090;

	@Override
	public boolean init() {
				registerObject(STAIRS_CLIMDOWN_TOP, this);
		return registerObject(STAIRS_CLIMDOWN, this);
	}

	@Override
	public boolean handleNPCClick(Player player, NPC npc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleNPCClick2(Player player, NPC npc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleNPCClick3(Player player, NPC npc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleNPCClick4(Player player, NPC npc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleObjectClick(Player player, WorldObject object) {
		int id = object.getId();
		
		if(id == STAIRS_CLIMDOWN) {
			int[] FirstCoords = {2878, 2899, 10185, 10214, 1};
			int[] SecondCoord = {2858, 2878, 10185, 10214, 1};
			climbDownStairPalace(player, FirstCoords, SecondCoord, 0);
			return true;
			
		}
		else if(id == STAIRS_CLIMDOWN_TOP) {
			int[] FirstCoords = {2877, 2899, 10183, 10215, 2};
			int[] SecondCoord = {2860, 2879, 10185, 10214, 2};
			climbDownStairPalace(player, FirstCoords, SecondCoord, 1);
			return true;
		}
		return false;
	}
	
	public static void climbDownStairPalace(Player player, int[] FirstCoords, int[] SecondCoord, int FloorDest) {
		if(player.getX() >= FirstCoords[0] && player.getX() <= FirstCoords[1]
				&& player.getY() >= FirstCoords[2] && player.getY() <= FirstCoords[3] && player.getPlane() == FirstCoords[4]) {
			player.setNextWorldTile(new WorldTile(player.getX() - 3, player.getY(), FloorDest));
			return;
			
		}else if(player.getX() >= SecondCoord[0] && player.getX() <= SecondCoord[1]
				&& player.getY() >= SecondCoord[2] && player.getY() <= SecondCoord[3] && player.getPlane() == SecondCoord[4]) {
			player.setNextWorldTile(new WorldTile(player.getX() + 3, player.getY(), FloorDest));
			return;
			
		}
	}

	@Override
	public boolean handleObjectClick2(Player player, WorldObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleObjectClick3(Player player, WorldObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleObjectClick4(Player player, WorldObject object) {
		// TODO Auto-generated method stub
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

}
