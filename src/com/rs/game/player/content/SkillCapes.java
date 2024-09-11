package com.rs.game.player.content;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.item.Item;
import com.rs.game.player.Player;

public class SkillCapes {
	
	private enum Cape {
		ATTACK(9747, 9748, 9749, -1), STRENGTH(9750, 9751,9752, -1), DEFENCE(9753, 9754, 9755, -1), RANGED(9756, 9757, 9758, -1), 
		PRAYER(9759, 9760, 9761, -1), MAGIC(9762, 9763, 9764, -1), RUNECRAFTING(9765, 9766, 9767, -1), CONSTITUTION(9768, 9769, 9770, -1), 
		DUNEGON(18508, 18509, 18510, -1), CONSTRUCT(9789, 9790, 9791, -1), AGILITY(9771, 9772, 9773, -1), HERBLORE(9774, 9775, 9776, -1), 
		THIEVING(9777, 9778, 9779, -1), CRAFTING(9780, 9781, 9782, -1), FLETCHING(9783, 9784, 9785, -1), SLAYER(9786, 9787, 9788, -1), 
		HUNTER(9948, 9949, 9950, -1), MINING(9792, 9793, 9794, -1), SMITH(9795, 9796, 9797, -1), FISHING(9798, 9799, 9800, -1), 
		COOKING(9801, 9802, 9803, -1), FIREMAKING(9804, 9805, 9806, -1), WOODCUTTING(9807, 9808, 9809, -1), FARMING(9810, 9811, 9812, -1), 
		SUMMONING(12169, 12170, 12171, -1), DUNGEONEERING(18508, 18509, 18510, 19709);
		
		private int capeUntrimed, capeTrimed, hat, masterCape;
		private String nameCapeUntrimed, nameCapeTrimed, nameHat, nameMasterCape;
		
		Cape(int capeUntrimed, int capeTrimed, int hat, int masterCape){
			this.capeUntrimed = capeUntrimed;
			this.capeTrimed = capeTrimed;
			this.hat = hat;
			this.masterCape = masterCape;
			this.nameCapeUntrimed = ItemDefinitions.getItemDefinitions(getUntrimed()).getName();
			this.nameCapeTrimed = ItemDefinitions.getItemDefinitions(getTrimed()).getName();
			this.nameHat = ItemDefinitions.getItemDefinitions(getHat()).getName();
			this.nameMasterCape = ItemDefinitions.getItemDefinitions(getMasterCape()).getName();
		}
		
		public int getUntrimed() {
			return capeUntrimed;
		}
		
		public int getTrimed() {
			return capeTrimed;
		}
		
		public int getHat() {
			return hat;
		}
		
		public int getMasterCape() {
			return masterCape;
		}
		
		public String getNameCapeUntrimed() {
			return nameCapeUntrimed;
		}
		
		public String getNameCapeTrimed() {
			return nameCapeTrimed;
		}
		
		public String getNameHat() {
			return nameHat;
		}
		
		public String getNameMasterCape() {
			return nameMasterCape;
		}
		
	}
	
	
	public static int getCapeBySkillName(String name, boolean trimmed) {
		for(Cape cape: Cape.values()) {
			if(trimmed) {
				if(cape.getNameCapeTrimed().toLowerCase().contains(name)) {
					return cape.getTrimed();
				}
			}else {
				if(cape.getNameCapeUntrimed().toLowerCase().contains(name)) {
					return cape.getUntrimed();
				}
			}
		}
		
		return -1;
	}
	
	//FUTURE SUPPORT MASTER CAPE
	public static int getMasterCapeBySkillName(String name) {
		for(Cape cape: Cape.values()) {
			if(cape.getNameMasterCape().toLowerCase().contains(name)) {
				return cape.getMasterCape();
			}
		}
		
		return -1;
	}
	
	public static int getHatBySkillName(String name) {
		for(Cape cape: Cape.values()) {
			if(cape.getNameHat().toLowerCase().contains(name)) {
				return cape.getHat();
			}
		}
		
		return -1;
	}
	
	public static void addCapeInventory(Player player, int capeId, int hatId) {
		player.getInventory().addItem(capeId, 1);
		if(hatId > 0) {
			player.getInventory().addItem(hatId, 1);
		}
	}
	
	
	public static boolean buySkillCape(Player player, String skillName, boolean masterCape) {
		boolean trimmed = player.getSkills().howMany99() >= 2 ? true : false;
		int price = masterCape ? 120000 : 99000;
		int capeId = masterCape ? getMasterCapeBySkillName(skillName): getCapeBySkillName(skillName, trimmed);
		int hatId = masterCape ? 0 : getHatBySkillName(skillName);
		
		if(price <= player.getMoneyPouch().getTotal()) {
			player.getMoneyPouch().takeMoneyFromPouch(price);
			addCapeInventory(player, capeId, hatId);
			return true;
		}else if(price <= player.getInventory().getNumberOf(995)) {
			player.getInventory().deleteItem(995, price);
			addCapeInventory(player, capeId, hatId);
			return true;
		}
		
		return false;
	}
	public static void checkTrimmeCape(Player player) {
		for(Cape cape: Cape.values()) {
			
			if(player.getBank().getItem(cape.getUntrimed()) != null) {
				int amount = player.getBank().getItem(cape.getUntrimed()).getAmount();
				player.getBank().removeItem(player.getBank().getItemSlot(cape.getUntrimed()), amount, true, false);
				player.getBank().addItem(new Item(cape.getTrimed(), amount), true);
				
			}
			if(player.getInventory().containsItem(cape.getUntrimed(), 1) ) {
				int amount = player.getInventory().getAmountOf(cape.getUntrimed()); 
				player.getInventory().deleteItem(cape.getUntrimed(), amount);
				player.getInventory().addItem(cape.getTrimed(), amount);
			}
			if (player.getEquipment().getCapeId() == cape.getUntrimed()) {
				player.getEquipment().deleteItem(cape.getUntrimed(), 1);
				if(player.getInventory().hasFreeSlots()) {
					player.getInventory().addItem(cape.getTrimed(), 1);					
				}else {
					player.getBank().addItem(new Item(cape.getTrimed(), 1), true);
				}
				
				player.getEquipment().refresh();
				player.getAppearence().generateAppearenceData();
			}
		}
	}
}
