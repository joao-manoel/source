package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class TormentedDemon extends MobRewardNodeBuilder {

	public TormentedDemon() {
		super(new Object[] { "Tormented demon", -1 });
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(AVANTOE_SEED, 1), node(GRIMY_AVANTOE, Utils.random(1, 11)), node(GRIMY_CADANTINE, Utils.random(1, 11)), node(GRIMY_LANTADYME, Utils.random(1, 11)), node(DIAMOND_NOTED_1602, 4),
				                 node(560, 50), node(563, 45), node(FIRE_TALISMAN_NOTED, 4), node(COINS, Utils.random(3000, 15000)));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(565, 50), node(GRIMY_DWARF_WEED, 11));
			break;
		case RARE:
			dissectNodeBatch(1, node(CRYSTAL_KEY, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(DRAGON_CLAWS_14484, 1));
			break;
		}
		addObj(INFERNAL_ASHES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(20, 21, 11, 21, 40);

	}
}
