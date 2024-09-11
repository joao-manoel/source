package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class ShadowHound extends MobRewardNodeBuilder {

	public ShadowHound() {
		super(new Object[] { "Shadow hound", 1976});
	}
	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(152, 341)),
		        node(CHAOS_RUNE, 20),
		        node(LAW_RUNE, 5),
		        node(NATURE_RUNE, 6));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(CHAOS_RUNE, 10),
		      node(NATURE_RUNE, 15),
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
		addObj(BONES, 1);
		shakeSummoningCharm(15, 2, 3, 0, 0);

	}
}
