package droptable;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class FrostDragon extends MobRewardNodeBuilder {

	public FrostDragon() {
		super(new Object[] { "Frost dragon", 11636 });
	}

	@Override
	public void populate(Player player) {
		double row = ItemDefinitions.getItemDefinitions(player.getEquipment().getRingId()).getName().toLowerCase()
				.contains("ring of wealth") ? 0.25 : 0;
		double shake = shake(2500);
		if (shake <= 1 + row) {
			if (row > 0) {
				player.getPackets().sendGameMessage("<col=ff7000>Your ring of wealth shines more brightly!</col>");
				player.setRareDrop(true);
				dissectNodeBatch(1, 
						node(DRACONIC_VISAGE, 1));
			}
			
		} else
			switch (rarityNode(player)) {
				case -1:
				case COMMON:
					dissectNodeBatch(1, node(COINS, Utils.random(200, 300) ), node(SHARK, Utils.random(1, 2)), 
							node(WATER_ORB_NOTED, 2), node(RUNE_ARROW, 12), node(GRIMY_AVANTOE_NOTED, 1), node(GRIMY_CADANTINE_NOTED, 1),
							node(GRIMY_GUAM_NOTED, 1), node(GRIMY_HARRALANDER_NOTED, 1), node(GRIMY_IRIT_NOTED, 1), node(GRIMY_KWUARM_NOTED, 1),
							node(GRIMY_MARRENTILL_NOTED, 1), node(GRIMY_RANARR, 1), node(GRIMY_TARROMIN, 1), node(WATER_TALISMAN_NOTED, 2));
					break;
				case UNCOMMON:
					dissectNodeBatch(1, node(ADAMANT_PLATEBODY, 1), node(ADAMANTITE_BAR_NOTED_2362, 3), node(PURE_ESSENCE_NOTED, 50), 
							node(LIMPWURT_ROOT_NOTED,1), node(ADAMANT_KITESHIELD, 1), node(GRIMY_LANTADYME_NOTED, 1), node(GRIMY_DWARF_WEED_NOTED, 1), 
							node(BLOOD_RUNE, 10), node(DEATH_RUNE, Utils.random(10, 15)), node(MAHOGANY_LOGS_NOTED, 3), node(LAW_RUNE, 10), 
							node(AIR_TALISMAN_NOTED, 2), node(RUNE_LONGSWORD, 1));
					break;
				case RARE:
					
					break;
				case VERY_RARE:
					dissectNodeBatch(1, node(GRIMY_SNAPDRAGON, 1), node(DRACONIC_VISAGE, 1), node(STARVED_ACIENT_EFFIGY, 1));
					break;
			}
		addObj(FROST_DRAGON_BONES, 1);// bones
		shakeTreasureTrail(player, HARD_CLUE);
		shakeSummoningCharm(1, 1.5, 5, 6, 4);

	}
}
