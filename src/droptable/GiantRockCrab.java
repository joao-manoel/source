package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class GiantRockCrab extends MobRewardNodeBuilder {

	public GiantRockCrab() {
		super(new Object[] { "Giant rock crab", 2885}); 
	}
	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(1500, 1800)),
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
		      node(WATER_TALISMAN, 1),
		      node(ROCK_SHELL_HELM_6128, 1));
			break;
		case RARE:
			dissectNodeBatch(1, 
			  node(ROCK_SHELL_HELM_6128, 1),
			  node(ROCK_SHELL_PLATE, 1),
			  node(ROCK_SHELL_LEGS, 1),
			  node(ROCK_SHELL_BOOTS_6145, 1),
			  node(ROCK_SHELL_GLOVES_6151, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
			  node(ROCK_SHELL_HELM_6128, 1),
			  node(ROCK_SHELL_PLATE, 1),
			  node(ROCK_SHELL_LEGS, 1),
			  node(CRYSTAL_KEY, 2));
			break;
		}
		addObj(BONES, 1);
		shakeSummoningCharm(12, 15, 10, 9, 5);

	}
}
