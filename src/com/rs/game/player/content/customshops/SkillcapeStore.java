package com.rs.game.player.content.customshops;

import java.util.ArrayList;

import com.rs.game.item.Item;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;

public class SkillcapeStore extends CustomStore {
	
	/**
	 * @Author -Andreas
	 * 2019-11
	 */

	public SkillcapeStore(Player player) {
		super(player);
	}

	protected static final int CURRENCY_SPRITE = 1371;

	protected static String TITLE = "Max' Skillcape Store";
	
	
	protected static ArrayList<Item> capes = new ArrayList<Item>();
	
	protected static void generateCapes(Player player) {
		capes.clear();
		capes.trimToSize();
		boolean hasTwo99s = player.getSkills().hasTwo99s();
		if (player.getSkills().getLevelForXp(Skills.ATTACK) == 99)
			capes.add(new Item(hasTwo99s ? 9748 : 9747, 1));
		if (player.getSkills().getLevelForXp(Skills.STRENGTH) == 99)
			capes.add(new Item(hasTwo99s ? 9751 : 9750, 1));
		if (player.getSkills().getLevelForXp(Skills.DEFENCE) == 99)
			capes.add(new Item(hasTwo99s ? 9754 : 9753, 1));
		if (player.getSkills().getLevelForXp(Skills.RANGE) == 99)
			capes.add(new Item(hasTwo99s ? 9757 : 9756, 1));
		if (player.getSkills().getLevelForXp(Skills.PRAYER) == 99)
			capes.add(new Item(hasTwo99s ? 9760 : 9759, 1));
		if (player.getSkills().getLevelForXp(Skills.MAGIC) == 99)
			capes.add(new Item(hasTwo99s ? 9763 : 9762, 1));
		if (player.getSkills().getLevelForXp(Skills.RUNECRAFTING) == 99)
			capes.add(new Item(hasTwo99s ? 9766 : 9765, 1));
		if (player.getSkills().getLevelForXp(Skills.HITPOINTS) == 99)
			capes.add(new Item(hasTwo99s ? 9769 : 9768, 1));
		if (player.getSkills().getLevelForXp(Skills.AGILITY) == 99)
			capes.add(new Item(hasTwo99s ? 9772 : 9771, 1));
		if (player.getSkills().getLevelForXp(Skills.HERBLORE) == 99)
			capes.add(new Item(hasTwo99s ? 9775 : 9774, 1));
		if (player.getSkills().getLevelForXp(Skills.THIEVING) == 99)
			capes.add(new Item(hasTwo99s ? 9778 : 9777, 1));
		if (player.getSkills().getLevelForXp(Skills.CRAFTING) == 99)
			capes.add(new Item(hasTwo99s ? 9781 : 9780, 1));
		if (player.getSkills().getLevelForXp(Skills.FLETCHING) == 99)
			capes.add(new Item(hasTwo99s ? 9784 : 9783, 1));
		if (player.getSkills().getLevelForXp(Skills.SLAYER) == 99)
			capes.add(new Item(hasTwo99s ? 9787 : 9786, 1));
		if (player.getSkills().getLevelForXp(Skills.CONSTRUCTION) == 99)
			capes.add(new Item(hasTwo99s ? 9790 : 9789, 1));
		if (player.getSkills().getLevelForXp(Skills.MINING) == 99)
			capes.add(new Item(hasTwo99s ? 9793 : 9792, 1));
		if (player.getSkills().getLevelForXp(Skills.SMITHING) == 99)
			capes.add(new Item(hasTwo99s ? 9796: 9795, 1));
		if (player.getSkills().getLevelForXp(Skills.FISHING) == 99)
			capes.add(new Item(hasTwo99s ? 9799 : 9798, 1));
		if (player.getSkills().getLevelForXp(Skills.COOKING) == 99)
			capes.add(new Item(hasTwo99s ? 9802 : 9801, 1));
		if (player.getSkills().getLevelForXp(Skills.FIREMAKING) == 99)
			capes.add(new Item(hasTwo99s ? 9805 : 9804, 1));
		if (player.getSkills().getLevelForXp(Skills.WOODCUTTING) == 99)
			capes.add(new Item(hasTwo99s ? 9808 : 9807, 1));
		if (player.getSkills().getLevelForXp(Skills.FARMING) == 99)
			capes.add(new Item(hasTwo99s ? 9811 : 9810, 1));
		if (player.getSkills().getLevelForXp(Skills.HUNTER) == 99)
			capes.add(new Item(hasTwo99s ? 9949 : 9948, 1));
		if (player.getSkills().getLevelForXp(Skills.SUMMONING) == 99)
			capes.add(new Item(hasTwo99s ? 12170 : 12169, 1));
		if (player.getSkills().getLevelForXp(Skills.DUNGEONEERING) >= 99)
			capes.add(new Item(hasTwo99s ? 18509 : 18508, 1));
		if (player.getSkills().getLevelForXp(Skills.DUNGEONEERING) == 120)
			capes.add(new Item(19709, 1));
		if (player.hasMaxCapeRequirements())
			capes.add(new Item(20767, 1));
	}
}
