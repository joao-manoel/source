package com.rs.game.cityhandler.impl;

import com.rs.game.Animation;
import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.cityhandler.CityEvent;
import com.rs.game.cityhandler.CityEventHandler;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;

public class PolyporeDungeon implements CityEvent{
	
	

	@Override
	public boolean init() {
		registerObject(64294, this);
		registerObject(64295, this);
		registerObject(64362, this);
		registerObject(64359, this);
		registerObject(64361, this);
		registerObject(64360, this);
		registerObject(63094, this);
		return registerObject(63093, this);
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
		/*
		 * PRIMEIRO NIVEL DONE
		 */
		if(object.getId() == 63093) { //ENTRAR NA CAVERNA
			if(player.getX() != 3410 && player.getY() != 3329) {
				player.addWalkSteps(3410, 3329, 0);
			}
			player.setNextWorldTile(new WorldTile(4620, 5458, 3));
			return true;
		}
		if(object.getId() == 63094) {//SAIR DA CAVERNA
			player.setNextWorldTile(new WorldTile(3410, 3329, 0));
			return true;
		}
		if(object.getId() == 64360) { 
			if(player.getX() >= 4619 && player.getX() <= 4633
					&& player.getY() >= 5451 && player.getY() <= 5463 && player.getPlane() == 3) { //IR PARA SEGUNDO NIVEL - ENTRADA
				player.animate(new Animation(15458));
				player.lock(3);
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.setNextWorldTile(new WorldTile(4629, 5451, 2));
						player.animate(new Animation(-1));
					}
				}, 1);
				
				return true;
			}
			
			if(player.getX() >= 4692 && player.getX() <= 4700
					&& player.getY() >= 5616 && player.getY() <= 5625 && player.getPlane() == 3) { 
				
				DownVine(player, new WorldTile(4695, 5617, 2));
				return true;
			}
			
		}
		if(object.getId() == 64359) { 
			
			if(player.getX() >= 4684 && player.getX() <= 4700
					&& player.getY() >= 5451 && player.getY() <= 5480 && player.getPlane() == 3) {// IR PARA SEGUNDO NIVEL - 3 OPTION
				DownVine(player, new WorldTile(4691, 5469, 2));
				return true;
			}
			if(player.getX() >= 4624 && player.getX() <= 4633
					&& player.getY() >= 5405 && player.getY() <= 5415 && player.getPlane() == 3) {// IR PARA SEGUNDO NIVEL
				DownVine(player, new WorldTile(4632, 5409, 2));
				return true;
			}
			
			if(player.getX() >= 4677 && player.getX() <= 4689
					&& player.getY() >= 5576 && player.getY() <= 5587 && player.getPlane() == 3) {// IR PARA SEGUNDO NIVEL
				DownVine(player, new WorldTile(4683, 5587, 2));
				return true;
			}
			
			/*
			 * SEGUNDO NIVEL
			 */
			
			if(player.getX() >= 4699 && player.getX() <= 4710
					&& player.getY() >= 5614 && player.getY() <= 5614 && player.getPlane() == 2) {// IR PARA TERCEIRO NIVEL
				DownVine(player, new WorldTile(4699, 5617, 1));
				return true;
			}
			
			if(player.getX() >= 4720 && player.getX() <= 4729
					&& player.getY() >= 5597 && player.getY() <= 5605 && player.getPlane() == 2) {// IR PARA TERCEIRO NIVEL
				DownVine(player, new WorldTile(4720, 5601, 1));
				return true;
			}
			
			if(player.getX() >= 4624 && player.getX() <= 4636
					&& player.getY() >= 5443 && player.getY() <= 5453 && player.getPlane() == 2) {// IR PARA TERCEIRO NIVEL
				DownVine(player, new WorldTile(4632, 5443, 1));
				return true;
			}
			
			if(player.getX() >= 4630 && player.getX() <= 4643
					&& player.getY() >= 5387 && player.getY() <= 5397 && player.getPlane() == 2) {// IR PARA TERCEIRO NIVEL
				DownVine(player, new WorldTile(4642, 5389, 1));
				
				return true;
			}
			
			if(player.getX() >= 4683 && player.getX() <= 4695
					&& player.getY() >= 5469 && player.getY() <= 5469 && player.getPlane() == 2) {// IR PARA TERCEIRO NIVEL
				DownVine(player, new WorldTile(4689, 5479, 1));
			
				return true;
			}
			if(player.getX() >= 4699 && player.getX() <= 4710
					&& player.getY() >= 5450 && player.getY() <= 5462 && player.getPlane() == 2) {// IR PARA TERCEIRO NIVEL
				DownVine(player, new WorldTile(4704, 5461, 1));
				return true;
			}
			/*
			 * TERCEIRO NIVEL
			 */
			if(player.getX() >= 4694 && player.getX() <= 4707
					&& player.getY() >= 5612 && player.getY() <= 5625 && player.getPlane() == 1) {// IR PARA ULTIMO NIVEL
				DownVine(player, new WorldTile(4702, 5610, 0));
				
				return true;
			}
			if(player.getX() >= 4645 && player.getX() <= 4657
					&& player.getY() >= 5386 && player.getY() <= 5399 && player.getPlane() == 1) {// IR PARA ULTIMO NIVEL
				DownVine(player, new WorldTile(4652, 5388, 0));
				
				return true;
			}
			if(player.getX() >= 4708 && player.getX() <= 4723
					&& player.getY() >= 5466 && player.getY() <= 5477 && player.getPlane() == 1) {// IR PARA ULTIMO NIVEL
				
				DownVine(player, new WorldTile(4718, 5467, 0));
				return true;
			}
			
		}
		
		
		if(object.getId() == 64361) { //SUBIR VINE
			
			/*
			 * SEGUNDO NIVEL
			 */
			
			if(player.getX() >= 4625 && player.getX() <= 4636
					&& player.getY() >= 5444 && player.getY() <= 5453 
					&& player.getPlane() == 2) { //IR PARA PRIMEIRO NIVEL - ENTRADA
				UpVine(player, new WorldTile(4629, 5454, 3));
				//player.setNextWorldTile();
				return true;
			}
			
			if(player.getX() >= 4686 && player.getX() <= 4700
					&& player.getY() >= 5453 && player.getY() <= 5462 
					&& player.getPlane() == 2) { // IR PARA PRIEMIRO NIVEL - 3 OPTION
				UpVine(player, new WorldTile(4697, 5459, 3));
				
				return true;
			}
			
			if(player.getX() >= 4685 && player.getX() <= 4694
					&& player.getY() >= 5467 && player.getY() <= 5479 
					&& player.getPlane() == 2) { // IR PARA PRIEMIRO NIVEL - 2 OPTION
				UpVine(player, new WorldTile(4691, 5470, 3));
				return true;
			}
			
			if(player.getX() >= 4624 && player.getX() <= 4634
					&& player.getY() >= 5403 && player.getY() <= 5413 
					&& player.getPlane() == 2) { // IR PARA PRIEMIRO NIVEL
				UpVine(player, new WorldTile(4631, 5409, 3));
				return true;
			}
			
			if(player.getX() >= 4688 && player.getX() <= 4697
					&& player.getY() >= 5616 && player.getY() <= 5625 
					&& player.getPlane() == 2) { // IR PARA PRIMEIRO NIVEL
				UpVine(player, new WorldTile(4696, 5619, 3));
				return true;
			}
			
			if(player.getX() >= 4678 && player.getX() <= 4688
					&& player.getY() >= 5585 && player.getY() <= 5598 
					&& player.getPlane() == 2) { // IR PARA PRIMEIRO NIVEL
				UpVine(player, new WorldTile(4684, 5585, 3));
				return true;
			}
			
			/*
			 * TERCEIRO NIVEL
			 */
			
			if(player.getX() >= 4694 && player.getX() <= 4707
					&& player.getY() >= 5613 && player.getY() <= 5623 
					&& player.getPlane() == 1) { // IR PARA SEGUNDO NIVEL
				UpVine(player, new WorldTile(4700, 5617, 2));
				return true;
			}
			
			if(player.getX() >= 4716 && player.getX() <= 4729
					&& player.getY() >= 5593 && player.getY() <= 5604 
					&& player.getPlane() == 1) { // IR PARA SEGUNDO NIVEL
				UpVine(player, new WorldTile(4722, 5602, 2));
				return true;
			}
			
			if(player.getX() >= 4623 && player.getX() <= 4636
					&& player.getY() >= 5440 && player.getY() <= 5451 
					&& player.getPlane() == 1) { // IR PARA SEGUNDO NIVEL
				UpVine(player, new WorldTile(4632, 5444, 2));
				return true;
			}
			
			if(player.getX() >= 4633 && player.getX() <= 4645
					&& player.getY() >= 5387 && player.getY() <= 5397 
					&& player.getPlane() == 1) { // IR PARA SEGUNDO NIVEL
				UpVine(player, new WorldTile(4641, 5389, 2));
				return true;
			}
			
			if(player.getX() >= 4684 && player.getX() <= 4693
					&& player.getY() >= 5471 && player.getY() <= 5481 
					&& player.getPlane() == 1) { // IR PARA SEGUNDO NIVEL
				UpVine(player, new WorldTile(4689, 5478, 2));
				return true;
			}
			if(player.getX() >= 4700 && player.getX() <= 4709
					&& player.getY() >= 5449 && player.getY() <= 5462 
					&& player.getPlane() == 1) { // IR PARA SEGUNDO NIVEL
				UpVine(player, new WorldTile(4705, 5459, 2));
				return true;
			}
			
			/*
			 * ULTIMO NIVEL
			 */
			if(player.getX() >= 4689 && player.getX() <= 4713
					&& player.getY() >= 5602 && player.getY() <= 5617 
					&& player.getPlane() == 0) { // IR PARA TERCEIRO NIVEL
				UpVine(player, new WorldTile(4702, 5613, 1));
				return true;
			}
			if(player.getX() >= 4706 && player.getX() <= 4724
					&& player.getY() >= 5458 && player.getY() <= 5471 
					&& player.getPlane() == 0) { // IR PARA TERCEIRO NIVEL
				UpVine(player, new WorldTile(4718, 5468, 1));
				return true;
			}
		}
		
		if(object.getId() == 64362) {
			/*
			 * ULTIMO NIVEL
			 */
			if(player.getX() >= 4637 && player.getX() <= 4659
					&& player.getY() >= 5380 && player.getY() <= 5396 
					&& player.getPlane() == 0) { // IR PARA TERCEIRO NIVEL
				UpVine(player, new WorldTile(4652, 5389, 1));
				return true;
			}
		}
		
		/*
		 * JUMP
		 */
		
		if(object.getId() == 64294) {
			if(player.getX() >= 4652 && player.getX() <= 4659
					&& player.getY() >= 5473 && player.getY() <= 5479 
					&& player.getPlane() == 3) { 
				
				JumpGap(player, new WorldTile(4662, 5476, 3));
				return true;
			}
			if(player.getX() >= 4684 && player.getX() <= 4695
					&& player.getY() >= 5472 && player.getY() <= 5479 
					&& player.getPlane() == 3) {
				JumpGap(player, new WorldTile(4681, 5476, 3));
				return true;
			}
		}
		
		if(object.getId() == 64295) {
			if(player.getX() >= 4661 && player.getX() <= 4668
					&& player.getY() >= 5473 && player.getY() <= 5480 
					&& player.getPlane() == 3) { // IR PARA TERCEIRO NIVEL
				JumpGap(player, new WorldTile(4658, 5476, 3));
				return true;
			}
			
			if(player.getX() >= 4674 && player.getX() <= 4682
					&& player.getY() >= 5473 && player.getY() <= 5479 
					&& player.getPlane() == 3) { // IR PARA TERCEIRO NIVEL
				JumpGap(player, new WorldTile(4685, 5476, 3));
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
	
	public void DownVine(Player player, WorldTile nextWorldTile) {
		player.animate(new Animation(15458));
		player.lock(3);
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.setNextWorldTile(nextWorldTile);
				player.animate(new Animation(-1));
			}
		}, 1);
	}
	
	public void UpVine(Player player, WorldTile nextWorldTile) {
		player.animate(new Animation(15456));
		player.lock(3);
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.setNextWorldTile(nextWorldTile);
				player.animate(new Animation(-1));
			}
		}, 1);
	}
	
	public void JumpGap(Player player, WorldTile nextWorldTile) {
		if (player.getSkills().getLevel(Skills.AGILITY) < 73) {
			player.getPackets()
					.sendGameMessage("You need at least an agility level of 72 to use this shortcut.");
			return;
		}else {
			player.animate(new Animation(15461));
			player.lock(3);
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.setNextWorldTile(nextWorldTile);
					player.animate(new Animation(-1));
				}
			}, 3);
		}
		
	}

}
