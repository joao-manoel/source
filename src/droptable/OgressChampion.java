package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class OgressChampion extends MobRewardNodeBuilder {

	public OgressChampion() {
		super(new Object[] { "Ogress champion", 7078}); 
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(251, 341)),
		        node(CHAOS_RUNE, 20),
		        node(LAW_RUNE, 5),
		        node(NATURE_RUNE, 6));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(CHAOS_RUNE, 3),
		      node(NATURE_RUNE, 12),
		      node(LAW_RUNE, 15),
		      node(GRIMY_RANARR_NOTED, 4));
			break;
		case RARE:
			dissectNodeBatch(1, 
					node(GRIMY_DWARF_WEED_NOTED, 5));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
			  node(GRIMY_DWARF_WEED_NOTED, 10),
			  node(STARVED_ACIENT_EFFIGY, 1));
			break;
		}
		addObj(BIG_BONES, 1);
		shakeSummoningCharm(15, 2, 3, 0, 0);

	}
}
