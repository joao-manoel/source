package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class Jogre extends MobRewardNodeBuilder {

	public Jogre() {
		super(new Object[] { "Jogre", 3063});
	}
	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(542, 6521)),
		        node(NATURE_RUNE, 50),
		        node(KNIFE, 1),
		        node(BIG_BONES_NOTED, 6));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(DEATH_RUNE, 50),
		      node(NATURE_RUNE, 100),
		      node(BIG_BONES_NOTED, 15),
		      node(GRIMY_RANARR_NOTED, 4));
			break;
		case RARE:
			dissectNodeBatch(1, 
					node(TORSTOL_SEED, 5));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
					node(TORSTOL_SEED, 10));
			break;
		}
		addObj(JOGRE_BONES_3125, 1);    
		shakeSummoningCharm(10, 5, 7, 2, 2);

	}
}
