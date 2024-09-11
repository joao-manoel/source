package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class MatureGrotworm extends MobRewardNodeBuilder {

	public MatureGrotworm() {
		super(new Object[] { "Mature Grotworm", 15463 });
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(SUPER_RESTORE2_3028, 1), node(COINS, 3000), node(SHARK, 2));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(SARADOMIN_BREW2_6689, 2), node(ROYAL_DRAGONHIDE_24373, 2));
			break;
		case RARE:
			dissectNodeBatch(1, node(IRIT_SEED, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(STARVED_ACIENT_EFFIGY, 1));
			break;
		}
		addObj(BIG_BONES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(5, 3, 2, 9, 1);

	}
}
