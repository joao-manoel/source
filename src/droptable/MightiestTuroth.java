package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class MightiestTuroth extends MobRewardNodeBuilder {

	public MightiestTuroth() {
		super(new Object[] { "Mightiest turoth", 7800}); 
	}


	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(3000, 3840)),
		        node(LIMPWURT_ROOT_NOTED, 2),
		        node(SNAPE_GRASS_NOTED, 5),
		        node(NATURE_RUNE, 6));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(GRIMY_GUAM, 1),
		      node(GRIMY_MARRENTILL, 1),
		      node(GRIMY_TARROMIN, 2),
		      node(GRIMY_RANARR_NOTED, 4));
			break;
		case RARE:
			dissectNodeBatch(1, 
			  node(GRIMY_DWARF_WEED_NOTED, 5),
			  node(GRIMY_DWARF_WEED, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
			  node(GRIMY_DWARF_WEED_NOTED, 10),
			  node(CRYSTAL_KEY, 1),
			  node(RUNE_SCIMITAR, 1));
			break;
		}
		addObj(BIG_BONES, 1);    
		shakeSummoningCharm(10, 12, 5, 4, 4);

	}
}
