package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class MithrilDragon extends MobRewardNodeBuilder {

	public MithrilDragon() {
		super(new Object[] { "Mithril dragon", 5663}); 
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(3000, 5000)),
		        node(GRIMY_RANARR_NOTED, 5),
		        node(GRIMY_IRIT_NOTED, 2),
		        node(GRIMY_AVANTOE_NOTED, 3),
		        node(RUNE_JAVELIN, 30));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(RUNITE_BOLTS, 70),
		      node(RUNE_DART, 50),
		      node(CHEWED_BONES_11338, 10));
			break;
		case RARE:
			dissectNodeBatch(1, 
			   node(RUNE_SCIMITAR, 1),
			   node(RUNE_PLATELEGS, 1),
			   node(RUNE_PLATEBODY, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1, 
				node(DRAGON_FULL_HELM_11335, 1),
				node(STARVED_ACIENT_EFFIGY, 1),
				node(DRACONIC_VISAGE, 1));
			break;
		}
		addObj(DRAGON_BONES, 1);
		shakeSummoningCharm(20, 4, 6, 9, 10);

	}
}
