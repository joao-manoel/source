package com.rs.game.cityhandler.impl;

import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.cityhandler.CityEvent;
import com.rs.game.cityhandler.CityEventHandler;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;

public class Yanille implements CityEvent{
	
	int STAIRCASE_UP = 1722;
	int STAIRCASE_DOWN = 1723;
	static int MAGIC_GUILD_DOOR_RIGHT_ENTRACE = 1601;
	static int MAGIC_GUILD_DOOR_LEFT_ENTRACE = 1600;
	int MAGIC_GUILD_LADDER_NEXT_WIZARD_GUILD = 1754;
	int MAGIC_GUILD_LADDER_NEXT_GUILD = 1757;
	
	int ROBE_STORE_OWNER = 1658;
	@Override
	public boolean init() {
		registerNPC(ROBE_STORE_OWNER, this);
		registerObject(MAGIC_GUILD_LADDER_NEXT_WIZARD_GUILD, this);
		registerObject(MAGIC_GUILD_LADDER_NEXT_GUILD, this);
		registerObject(MAGIC_GUILD_DOOR_RIGHT_ENTRACE, this);
		registerObject(MAGIC_GUILD_DOOR_LEFT_ENTRACE, this);
		registerObject(STAIRCASE_DOWN, this);
		return registerObject(STAIRCASE_UP, this);
	}

	@Override
	public boolean handleNPCClick(Player player, NPC npc) {
		if(npc.getId() == ROBE_STORE_OWNER) {
			player.getDialogueManager().startDialogue("robeStoreOwner", npc);
			return true;
		}
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
		
		if(id == STAIRCASE_UP && player.getX() >= 2585 && player.getX() <= 2596
				&& player.getY() >= 3083 && player.getY() <= 3094 ) {
			climpStairCase(player, true);
			return true;
		}
		else  if(id == STAIRCASE_DOWN && player.getX() >= 2585 && player.getX() <= 2596
				&& player.getY() >= 3083 && player.getY() <= 3094 ) {
			climpStairCase(player, false);
			return true;
		}
		
		else if(id == MAGIC_GUILD_DOOR_RIGHT_ENTRACE) {
			if(player.getX() >= 2591 && player.getX() <= 2599
					&& player.getY() >= 3083 && player.getY() <= 3095) {
				openDoorGuild(player, object, object.getRotation() + 1);
				return true;
			}else if(player.getX() >= 2581 && player.getX() <= 2591
					&& player.getY() >= 3082 && player.getY() <= 3094) {
				openDoorGuild1(player, object, object.getRotation() + 1);
				return true;
			}
			
			
		}
		
		else if(id == MAGIC_GUILD_DOOR_LEFT_ENTRACE) {
			if(player.getX() >= 2591 && player.getX() <= 2599
					&& player.getY() >= 3083 && player.getY() <= 3095) {
				openDoorGuild(player, object, object.getRotation() - 1);
				return true;
			}else if(player.getX() >= 2581 && player.getX() <= 2591
					&& player.getY() >= 3082 && player.getY() <= 3094) {
				openDoorGuild1(player, object, object.getRotation() - 1);
				return true;
			}
		}
		
		else if(id == MAGIC_GUILD_LADDER_NEXT_WIZARD_GUILD) {
			if(player.getX() >= 2585 && player.getX() <= 2596
					&& player.getY() >= 3083 && player.getY() <= 3094) {
				player.useStairs(827, new WorldTile(2594, 9486, 0), 1, 2);
				return true;
			}
		}
		else if(id == MAGIC_GUILD_LADDER_NEXT_GUILD) {
			if(player.getX() >= 2582 && player.getX() <= 2594
					&& player.getY() >= 9484 && player.getY() <= 9493) {
				player.useStairs(828, new WorldTile(2594, 3086, 0), 1, 2);
				return true;
			}
		}
					  
		return false;
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
	
	public static void openDoorGuild(Player player, WorldObject object, int rotation) {
		if(player.getSkills().getLevelForXp(Skills.MAGIC) <= 59) {
			player.getDialogueManager().startDialogue("SimpleNPCMessage",
					462,
					"Sorry, but you need level 60 Magic to go in there.");
			return;
		}
	
		WorldObject otherOpenDoor = World.getObjectWithType(
				new WorldTile(object.getX(), object.getId() == MAGIC_GUILD_DOOR_LEFT_ENTRACE ? 3088 : 3087, object.getPlane()), object.getType());
		WorldObject openedDoor = new WorldObject(object.getId(), object.getType(), rotation,
				object.getX() - 1, object.getY(), object.getPlane());
		WorldObject openedDoor2 = new WorldObject(otherOpenDoor.getId(), otherOpenDoor.getType(), object.getId() == MAGIC_GUILD_DOOR_RIGHT_ENTRACE ? -1 : 1,
				otherOpenDoor.getX() - 1, otherOpenDoor.getY(), otherOpenDoor.getPlane());
		
		if (World.removeObjectTemporary(object, 1200, false))
			World.spawnObjectTemporary(openedDoor, 1200);
		if(World.removeObjectTemporary(otherOpenDoor, 1200, false))
			World.spawnObjectTemporary(openedDoor2, 1200);
			
		player.lock(2);
		player.stopAll();
		player.addWalkSteps(player.getX() < object.getX() ? object.getX() : object.getX() - 1, player.getY(), -1, false);
		return;
	}
	
	public static void openDoorGuild1(Player player, WorldObject object, int rotation) {
		if(player.getSkills().getLevelForXp(Skills.MAGIC) <= 59) {
			player.getDialogueManager().startDialogue("SimpleNPCMessage",
					462,
					"Sorry, but you need level 60 Magic to go in there.");
			return;
		}
		WorldObject otherOpenDoor = World.getObjectWithType(new WorldTile(object.getX(), object.getId() == MAGIC_GUILD_DOOR_LEFT_ENTRACE ? 3087 : 3088, object.getPlane()), object.getType());
		
		WorldObject openedDoor = new WorldObject(object.getId(), object.getType(), rotation,
				object.getX() + 1, object.getY(), object.getPlane());
		
		WorldObject openedDoor2 = new WorldObject(otherOpenDoor.getId(), otherOpenDoor.getType(), object.getId() == MAGIC_GUILD_DOOR_RIGHT_ENTRACE ? 1 : -1,
				otherOpenDoor.getX() + 1, otherOpenDoor.getY(), otherOpenDoor.getPlane());
		
		if (World.removeObjectTemporary(object, 1200, false))
			World.spawnObjectTemporary(openedDoor, 1200);
		if(World.removeObjectTemporary(otherOpenDoor, 1200, false))
			World.spawnObjectTemporary(openedDoor2, 1200);
		player.lock(2);
		player.stopAll();
		player.addWalkSteps(player.getX() > object.getX() ? object.getX() : object.getX() + 1, player.getY(), -1, false);
		player.sm("object X:"+ object.getX()+" Y:"+object.getY());
		return;
	}
	
	
	public static void climpStairCase(Player player, boolean UP) {
		int nextUpPlayerY = player.getY()  + 4;
		int nextDownPlayerY = player.getY()  - 4; 
		player.setNextWorldTile(new WorldTile(player.getX(), UP ? nextUpPlayerY : nextDownPlayerY, UP ? player.getPlane() + 1 : player.getPlane() - 1));
		return;
	}

}
