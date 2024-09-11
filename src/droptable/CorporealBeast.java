package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class CorporealBeast extends MobRewardNodeBuilder {

	public CorporealBeast() {
		super(new Object[] { "Corporeal beast", -1 });
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(WATERMELON_SEED, 24), node(COINS, 3000), node(UNCUT_DIAMOND, 1), 
			node(UNCUT_RUBY_1619, 1), node(UNCUT_EMERALD_1621, 1), node(UNCUT_SAPPHIRE_1623, 1), node(UNCUT_DRAGONSTONE_1631, 1));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(ADAMANT_ARROW, 750), node(RUNITE_BOLTS, 250), node(CANNONBALL, 2000), node(REGEN_BRACELET_11133, 1), 
				node(ONYX_BOLTS_E_9245, 175), node(TEAK_PLANK_NOTED_8781, 100),node(MAHOGANY_LOGS_NOTED, 150), node(MAGIC_LOGS_NOTED, 75), 
				node(RAW_SHARK_NOTED_384, 70), node(WHITE_BERRIES_NOTED, 150), node(DESERT_GOAT_HORN_NOTED_9738, 120), node(LAW_RUNE, 100), node(TUNA_POTATO_7060, 30), node(GREEN_DRAGONHIDE_NOTED_1754, 100));
			break;
		case RARE:
			dissectNodeBatch(1, node(COINS, 50000), node(UNCUT_DIAMOND_NOTED_1618, 15), node(RANARR_SEED, 15), node(CRYSTAL_KEY, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(SPECTRAL_SIGIL, 1), node(ELYSIAN_SIGIL, 1), node(ARCANE_SIGIL, 1), node(DIVINE_SIGIL, 1));
			break;
		}
		addObj(BONES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(50, 23, 13, 23, 45);

	}
}
