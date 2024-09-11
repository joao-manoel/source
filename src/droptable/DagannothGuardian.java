package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class DagannothGuardian extends MobRewardNodeBuilder {

	public DagannothGuardian() {
		super(new Object[] { "Dagannoth guardian", 9092 });
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(SUPER_ATTACK3, 1), node(SUPER_DEFENCE3_163, 1), node(SWORDFISH, 2), node(PURE_ESSENCE_7936, 20));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(GRIMY_GUAM, 1), node(GRIMY_MARRENTILL, 1), node(GRIMY_TARROMIN, 1), node(GRIMY_HARRALANDER, 1), node(GRIMY_RANARR, 1), node(GRIMY_IRIT, 1), node(GRIMY_AVANTOE, 1),
				                node(GRIMY_KWUARM, 1), node(GRIMY_CADANTINE, 1 ), node(GRIMY_DWARF_WEED, 1), node(GRIMY_TORSTOL,1 ));
			break;
		case RARE:
			dissectNodeBatch(1, node(WARRIOR_HELM_3753, 1), node(BERSERKER_HELM_3751, 1), node(FARSEER_HELM, 1), node(ARCHER_HELM, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(STARVED_ACIENT_EFFIGY, 1));
			break;
		}
		addObj(BIG_BONES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(5, 12, 8, 7, 1);

	}
}
