package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class Glacor extends MobRewardNodeBuilder {

	public Glacor() {
		super(new Object[] { "Glacor", -1});
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, node(SHARDS_OF_ARMADYL, 1), node(WATER_TALISMAN_NOTED, 5), node(PURE_ESSENCE_NOTED, 100), 
			node(COINS, 15000), node(RAW_SHARK_NOTED_384, 10));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(DEATH_RUNE, 50), node(ADAMANT_BOLTSUNF_9380, 98), node(DRAGON_MACE, 1), node(SHARK_6969, 6), 
			node(BLUE_DRAGONHIDE_NOTED_1752, 10), node(HEADLESS_ARROW_53, 600));
			break;
		case RARE:
			dissectNodeBatch(1, node(PRAYER_POTION3_139, 1), node(CRYSTAL_KEY, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(STEADFAST_BOOTS, 1), node(RAGEFIRE_BOOTS, 1), node(GLAIVEN_BOOTS, 1));
			break;
		}
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(40, 5, 7, 9, 15);

	}
}
