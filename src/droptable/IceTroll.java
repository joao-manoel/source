package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class IceTroll extends MobRewardNodeBuilder {

	public IceTroll() {
		super(new Object[] { "Ice troll", 1560});
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(1000, 2345)),
		        node(WATER_RUNE, 12),
		        node(MIND_RUNE, 24),
		        node(BODY_RUNE, 37),
		        node(COSMIC_RUNE, 6),
		        node(DEATH_RUNE, 50),
		        node(BLOOD_RUNE, 50));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(LAW_RUNE, 50),
		      node(NATURE_RUNE, 100),
		      node(GRIMY_MARRENTILL_NOTED, 5),
		      node(GRIMY_RANARR_NOTED, 4),
		      node(GRIMY_HARRALANDER_NOTED, 7),
		      node(GRIMY_KWUARM_NOTED, 12));
			break;
		case RARE:
			dissectNodeBatch(1, 
			  node(GRANITE_SHIELD_3122, 1),
			  node(BLOOD_RUNE, 60),
			  node(TOADFLAX_SEED, 3));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
					node(CRYSTAL_KEY, 2));
			break;
		}
		addObj(BIG_BONES, 1);    
		shakeSummoningCharm(10, 17, 14, 5, 7);

	}
}
