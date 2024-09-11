package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class KalphiteQueen extends MobRewardNodeBuilder {

	public KalphiteQueen() {
		super(new Object[] { "Kalphite queen", -1 });
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(RUNE_ARROW, 100), node(BLOOD_RUNE, 150), node(LAW_RUNE, 150), node(DEATH_RUNE, 150), 
			node(COINS, 80000), node(SHARK, 14), node(FIRE_TALISMAN_NOTED, 12), node(CRYSTAL_KEY, 1));
			break;
		case UNCOMMON:
			//dissectNodeBatch();
			break;
		case RARE:
			dissectNodeBatch(1, node(LAVA_BATTLESTAFF, 2), node(DRAGON_2H_SWORD, 1), node(DRAGON_CHAINBODY_3140, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(STARVED_ACIENT_EFFIGY, 1));
			break;
		}
		addObj(BIG_BONES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(15, 4, 4, 8, 10);

	}
}
