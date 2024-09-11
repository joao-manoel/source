package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class FungalMage extends MobRewardNodeBuilder {

	public FungalMage() {
		super(new Object[] { "Fungal mage", 14691});
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(300, 1000)),
		        node(GRIMY_GUAM_NOTED, 5),
		        node(GRIMY_MARRENTILL_NOTED, 5),
		        node(GRIMY_TARROMIN_NOTED, 7),
		        node(FUNGAL_FLAKE, Utils.random(20, 150)),
		        node(SNAPE_GRASS_NOTED, 25),
		        node(LIMPWURT_ROOT_NOTED, 10),
		        node(NATURE_RUNE, 30),
		        node(POLYPORE_SPORE, Utils.random(50, 180)));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(GRIMY_HARRALANDER_NOTED, 5),
		      node(GRIMY_RANARR_NOTED, 7),
		      node(GRIMY_IRIT_NOTED, 4),
		      node(GRIMY_AVANTOE_NOTED, 7),
		      node(GRIMY_KWUARM_NOTED, 4),
		      node(CRYSTAL_KEY, 1),
		      node(GRIMY_CADANTINE_NOTED, Utils.random(3, 10)));
			break;
		case RARE:
			dissectNodeBatch(1, 
			  node(SNAPDRAGON_SEED, 1),
			  node(SPIRIT_SEED, 1),
			  node(YEW_SEED, 1),
			  node(TORSTOL_SEED, 1),
			  node(MAGIC_SEED, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
			  node(STARVED_ACIENT_EFFIGY, 1),
			  node(LONG_BONE, 1),
			  node(CURVED_BONE, 1),
			  node(CRYSTAL_KEY, 2));
			break;
		}
		addObj(ACCURSED_ASHES, 1);
		shakeSummoningCharm(8, 3, 3, 4, 2);

	}
}
