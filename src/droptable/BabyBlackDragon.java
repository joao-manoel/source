package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class BabyBlackDragon extends MobRewardNodeBuilder {

	public BabyBlackDragon() {
		super(new Object[] { "Baby black dragon", 3376}); 
	}
	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, node(COINS, Utils.random(350, 1000)), node(CHAOS_RUNE, 20), node(LAW_RUNE, 5), node(NATURE_RUNE, 6));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(CHAOS_RUNE, 20),
		      node(NATURE_RUNE, 50),
		      node(LAW_RUNE, 15),
		      node(GRIMY_RANARR_NOTED, 4));
			break;
		case RARE:
			dissectNodeBatch(1, 
					node(GRIMY_DWARF_WEED_NOTED, 5));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
					node(GRIMY_DWARF_WEED_NOTED, 10));
			break;
		}
		addObj(BABYDRAGON_BONES, 1);
		shakeSummoningCharm(10, 2, 3, 2, 2);

	}
}
