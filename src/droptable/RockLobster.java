package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public final class RockLobster extends MobRewardNodeBuilder {

	public RockLobster() {
		super(new Object[] { "Rock lobster", 2889 });
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(EARTH_RUNE, 5),node(WATER_RUNE, 9), node(PURE_ESSENCE_7936,Utils.random(4, 8)), 
								 node(STEEL_ARROW, Utils.random(4, 7)),
								 node(IRON_ARROW, Utils.random(2, 17)),
								 node(GROUND_SEAWEED_6683, 4),
								 node(EDIBLE_SEAWEED, 4), 
								 node(RAW_LOBSTER, 1),
								 node(LOBSTER_POT_301, 1),
								 node(TINDERBOX, 1)); 

			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(COINS, 355), node(FIRE_TALISMAN, 1), node(AIR_TALISMAN, 1), node(COSMIC_TALISMAN, 1), node(BODY_TALISMAN, 1), node(WATER_TALISMAN, 1), node(GRIMY_GUAM, 1), node(GRIMY_MARRENTILL, 1),
								node(GRIMY_AVANTOE, 1), node(ONION_SEED, 1));
			break;
		case RARE:
			dissectNodeBatch(1, node(CRYSTAL_KEY, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(STARVED_ACIENT_EFFIGY, 1));
			break;
		}
		addObj(BIG_BONES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(10, 17, 10, 20, 4);

	}
}
