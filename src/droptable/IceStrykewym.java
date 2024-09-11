package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;

public class IceStrykewym extends MobRewardNodeBuilder{

	public IceStrykewym() {
		super(new Object[] { "Ice strykewyrm", 9463 });
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, node(995, Utils.random(200,660)), node(CRUSHED_NEST_NOTED_6694, Utils.random(5,9)), node(SHARK, Utils.random(1,3)), node(RUNITE_BAR_NOTED_2364,1), 
					node(GRIMY_GUAM_NOTED, 2), node(MAGIC_LOGS_NOTED, 5), node(SUPER_DEFENCE3_NOTED_164, 1), node(BLOOD_RUNE, 15), node(DEATH_RUNE, 20), node(KWUARM_SEED, 1), 
					node(WATER_TALISMAN, 3), node(MITHRIL_BATTLEAXE, 1));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(GRIMY_IRIT_NOTED, 2), node(GRIMY_HARRALANDER_NOTED, 2), node(GRIMY_DWARF_WEED_NOTED, 1), node(GRIMY_AVANTOE_NOTED, 2), node(995, Utils.random(4400, 8000)),
					node(HARRALANDER_SEED, 1), node(JANGERBERRY_SEED, 1), node(LIMPWURT_SEED, 1), node(STRAWBERRY_SEED, 1), node(WATERMELON_SEED, 1), node(WILDBLOOD_SEED, 1),
					node(GRIMY_TARROMIN_NOTED, 2), node(GRIMY_RANARR_NOTED, 2), node(GRIMY_MARRENTILL_NOTED, 2), node(WATER_TALISMAN, 1));
			break;
		case RARE:
			dissectNodeBatch(1, node(BELLADONNA_SEED, 1), node(AVANTOE_SEED, 1), node(GRIMY_LANTADYME_NOTED, 1), node(GRIMY_KWUARM_NOTED, 2), node(GRIMY_CADANTINE_NOTED, 1), node(LANTADYME_SEED, 1),
					node(MAPLE_SEED, 1), node(MARRENTILL_SEED, 1), node(POISON_IVY_SEED, 1), node(RANARR_SEED, 1), node(SNAPDRAGON_SEED, 1), node(SPIRIT_WEED_SEED, 1), node(TARROMIN_SEED, 1),
					node(TOADFLAX_SEED, 1),node(WHITEBERRY_SEED, 1),node(IRIT_SEED, 1),node(DWARF_WEED_SEED, 1),node(CACTUS_SEED, 1),node(CHAOS_TALISMAN, 1),node(BODY_TALISMAN, 1),
					node(AIR_TALISMAN, 1),node(FIRE_TALISMAN, 1),node(MIND_TALISMAN, 1),node(EARTH_TALISMAN, 1),node(COSMIC_TALISMAN, 1),node(RUNE_BATTLEAXE, 1),node(STAFF_OF_LIGHT, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1, node(MAGIC_SEED, 1), node(YEW_SEED, 1));
			break;
		}
		//addObj(BONES, 1);
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(5, 5, 6, 8, 4);

	}

}
