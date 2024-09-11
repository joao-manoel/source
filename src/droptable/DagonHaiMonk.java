package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class DagonHaiMonk extends MobRewardNodeBuilder {

	public DagonHaiMonk() {
		super(new Object[] { "Dagonhai monk", 7138}); 
	}

	@Override
	public void populate(Player player) {
		
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
	        node(COINS, Utils.random(800, 1250)),
	        node(EARTH_RUNE, 50),
	        node(AIR_RUNE, 100),
	        node(BODY_RUNE, 75),
	        node(FIRE_RUNE, 55),
	        node(WATER_RUNE, 50),
	        node(MIND_RUNE, 80),
	        node(NATURE_RUNE, 30));
			break;
			
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(CHAOS_RUNE, 50),
		      node(LAW_RUNE, 30),
		      node(BLOOD_RUNE, 15),
		      node(FIRE_TALISMAN, 1),
		      node(WATER_TALISMAN, 1));
			break;
		case RARE:
			dissectNodeBatch(1, node(GRIMY_DWARF_WEED_NOTED, 5));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
			  node(DAGONHAI_ROBE_TOP, 1),
			  node(DAGONHAI_HAT, 1),
			  node(DAGONHAI_ROBE_BOTTOM, 1));
			break;
		}
		
		addObj(BONES, 1);
		shakeSummoningCharm(10, 2, 3, 5, 0);

	}
}
