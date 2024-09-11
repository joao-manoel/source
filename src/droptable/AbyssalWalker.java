package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class AbyssalWalker extends MobRewardNodeBuilder {

	public AbyssalWalker() {
		super(new Object[] { "Abyssal Walker", -1});
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, node(PURE_ESSENCE_NOTED, 25));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(AIR_TALISMAN, 1), node(EARTH_TALISMAN, 1), node(FIRE_TALISMAN, 1), 
			node(WATER_TALISMAN, 1), node(BODY_TALISMAN, 1), node(MIND_TALISMAN, 1),  node(CHAOS_TALISMAN, 1), 
			node(COSMIC_TALISMAN, 1), node(DEATH_TALISMAN, 1), node(LAW_TALISMAN, 1), node(NATURE_TALISMAN, 1));
			break;
		case RARE:
			dissectNodeBatch(1, node(STARVED_ACIENT_EFFIGY, 1), node(CRYSTAL_KEY, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(CRYSTAL_KEY, 1));
			break;
		}
		addObj(ASHES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(5, 5, 18, 3, 1);

	}
}
