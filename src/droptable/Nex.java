package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class Nex extends MobRewardNodeBuilder {

	public Nex() {
		super(new Object[] { "Nex", -1 });
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, node(GREEN_DRAGONHIDE_NOTED_1754, 400), node(UNCUT_DRAGONSTONE_NOTED_1632, 20), node(MAGIC_LOGS_NOTED, 375));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(ONYX_BOLTS_E_9245, 375), node(GRIMY_AVANTOE_NOTED, 75), node(GRIMY_DWARF_WEED_NOTED, 75), node(GRIMY_TORSTOL_NOTED, 75), node(MAGIC_SEED, 5));
		case RARE:
			
			break;
		case VERY_RARE:
			dissectNodeBatch(1, node(TORVA_FULL_HELM, 1), node(TORVA_PLATEBODY, 1), node(TORVA_PLATELEGS, 1), node(PERNIX_COWL, 1), node(PERNIX_BODY, 1), node(PERNIX_CHAPS, 1), 
					node(VIRTUS_MASK, 1), node(VIRTUS_ROBE_TOP, 1), node(VIRTUS_ROBE_LEGS, 1), node(ZARYTE_BOW, 1));
			break;
		}
		addObj(BIG_BONES, 1);// bones
		shakeSummoningCharm(8, 9, 12, 19, 23);
	}
}
