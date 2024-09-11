package com.rs.game.cityhandler.impl;

import com.rs.game.Animation;
import com.rs.game.ForceMovement;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.cityhandler.CityEvent;
import com.rs.game.cityhandler.CityEventHandler;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.actions.skills.agility.Agility;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;

public class BarbarianAssault implements CityEvent{

	@Override
	public boolean init() {
		registerObject(4615, this);
		registerObject(4616, this);
		registerObject(4577, this);
		registerObject(4559, this);
		registerObject(4558, this);
		registerObject(4557, this);
		registerObject(4556, this);
		registerObject(4555, this);
		registerObject(4554, this);
		registerObject(4553, this);
		registerObject(4552, this);
		registerObject(4550, this);
		return registerObject(4551, this);
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
		
		if(id == 4615) {
			if (!Agility.hasLevel(player, 26))
				return false;
			
			player.lock(5);
			player.animate(new Animation(753));
			player.getAppearence().setRenderEmote(157);
			final WorldTile toTile = new WorldTile(2598, object.getY(), object.getPlane());
			player.setRun(true);
			player.addWalkSteps(toTile.getX(), toTile.getY(), -1, false);
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.animate(new Animation(759));
					player.getAppearence().setRenderEmote(-1);				
				}
			}, 3);
			return true;
		}
		
		if(id == 4616) {
			if (!Agility.hasLevel(player, 26))
				return false;
			player.lock(5);
			player.animate(new Animation(752));
			player.getAppearence().setRenderEmote(156);
			final WorldTile toTile = new WorldTile(2596, object.getY(), object.getPlane());
			player.setRun(true);
			player.addWalkSteps(toTile.getX(), toTile.getY(), -1, false);
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.animate(new Animation(759));
					player.getAppearence().setRenderEmote(-1);
					
				}
			}, 3);
			return true;
		}
		
		if(id == 4577) {
			openDoorTower(player, object);
			return true;			
		}
		/*
		 * PASSAR PARA A TORRE NAS PEDRAS
		 * **/
		if(id == 4551) {
			if(player.getX() >= 2520 && player.getX() <= 2525
					&& player.getY() >= 3593 && player.getY() <= 3596) {
				jump(player, new WorldTile(2522, 3597,0), ForceMovement.NORTH);
				return true;
			}else {
				jump(player, new WorldTile(2522, 3595,0), ForceMovement.SOUTH);
				return true;
			}
		}
		if(id == 4553) {
			if(player.getX() >= 2522 && player.getX() <= 2522
					&& player.getY() >= 3597 && player.getY() <= 3600) {
				jump(player, new WorldTile(2522, 3602,0), ForceMovement.NORTH);
				return true;
			}else {
				jump(player, new WorldTile(2522, 3600,0), ForceMovement.SOUTH);
				return true;
			}
		}
		
		if(id == 4555) {
			if(player.getX() >= 2518 && player.getX() <= 2518
					&& player.getY() >= 3609 && player.getY() <= 3611) {
				jump(player, new WorldTile(2516, 3611,0), ForceMovement.WEST);
				return true;
			}else {
				jump(player, new WorldTile(2518, 3611,0), ForceMovement.EAST);
				return true;
			}
		}
		if(id == 4557) {
			if(player.getX() >= 2514 
					&& player.getY() >= 3611 && player.getY() <= 3613) {
				jump(player, new WorldTile(2514, 3615,0), ForceMovement.NORTH);
				return true;
			}else {
				jump(player, new WorldTile(2514, 3613,0), ForceMovement.SOUTH);
				return true;
			}
		}
		if(id == 4559) {
			if(player.getX() >= 2514 
					&& player.getY() >= 3615 && player.getY() <= 3617) {
				jump(player, new WorldTile(2514, 3619,0), ForceMovement.NORTH);
				return true;
			}else {
				jump(player, new WorldTile(2514, 3617,0), ForceMovement.SOUTH);
				return true;
			}
		}
		
		/*
		 * VOLTANDO PARA BARBARIAN ASSAULT
		 * */
		
		if(id == 4558) {
			if(player.getX() >= 2511 && player.getX() <= 2517
					&& player.getY() >= 3618 && player.getY() <= 3621) {
				jump(player, new WorldTile(2514, 3617,0), ForceMovement.SOUTH);
				return true;
			}else {
				jump(player, new WorldTile(2514, 3619,0), ForceMovement.NORTH);
				return true;
			}
		}
		
		if(id == 4556) {
			if(player.getX() >= 2514 
					&& player.getY() >= 3615 && player.getY() <= 3617) {
				jump(player, new WorldTile(2514, 3615,0), ForceMovement.SOUTH);
				return true;
			}else {
				jump(player, new WorldTile(2514, 3613,0), ForceMovement.NORTH);
				return true;
			}
		}
		if(id == 4554) {
			if(player.getX() >= 2514 && player.getX() <= 2516
					&& player.getY() >= 3611 && player.getY() <= 3613) {
				jump(player, new WorldTile(2518, 3611,0), ForceMovement.EAST);
				return true;
			}else {
				jump(player, new WorldTile(2516, 3611,0), ForceMovement.WEST);
				return true;
			}
		}
		if(id == 4552) {
			if(player.getX() >= 2519 && player.getX() <= 2523
					&& player.getY() >= 3602 && player.getY() <= 3605) {
				jump(player, new WorldTile(2522, 3600,0), ForceMovement.SOUTH);
				return true;
			}else {
				jump(player, new WorldTile(2522, 3602,0), ForceMovement.NORTH);
				return true;
			}
		}
		if(id == 4550) {
			if(player.getX() >= 2520 && player.getX() <= 2524
					&& player.getY() >= 3591 && player.getY() <= 3600) {
				jump(player, new WorldTile(2522, 3595,0),ForceMovement.SOUTH);
				return true;
			}else {
				jump(player, new WorldTile(2522, 3597,0), ForceMovement.NORTH);
				return true;
			}
			
		}
		return false;
	}

	private void openDoorTower(Player player, WorldObject object) {
		
		WorldObject openedDoor = new WorldObject(object.getId() - 133, object.getType(), 0,
				object.getX() + 1, object.getY(), object.getPlane());
		
		if (World.removeObjectTemporary(object, 1200, false))
			World.spawnObjectTemporary(openedDoor, 1200);
		player.lock(2);
		player.stopAll();
		player.addWalkSteps(player.getX(), player.getY() < object.getY() ? object.getY() : object.getY() - 1, -1, false);
		player.sm("object X:"+ object.getX()+" Y:"+object.getY());
		return;
		
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
	
	public boolean jump(Player player, WorldTile tile, int direct) {
		if (!Agility.hasLevel(player, 35)) {
			player.sm("You need agility level 35.");
			return false;
		}			
		
		player.animate(new Animation(741));
		player.setNextForceMovement(
				new ForceMovement(tile,1, direct ));
		
		player.lock(1);
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {	
				player.setNextWorldTile(tile);
				player.animate(new Animation(-1));				
			}
		}, 1);
		return true;
	}

}
