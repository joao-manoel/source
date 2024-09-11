package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;
import com.rs.utils.Utils;


public final class GanodermicBeast extends MobRewardNodeBuilder {

	public GanodermicBeast() {
		super(new Object[] { "Ganodermic beast", 14696});
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, 
		        node(COINS, Utils.random(3000, 8000)),
		        node(BLOOD_RUNE, 50),
		        node(WATERMELON_SEED, 10),
		        node(FLAX_NOTED, 55),
		        node(FIRE_RUNE, 55),
		        node(WATER_RUNE, 50),
		        node(MIND_RUNE, 80),
		        node(NATURE_RUNE, 30),
		        node(POLYPORE_SPORE, Utils.random(30, 350)));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, 
		      node(CHAOS_RUNE, 50),
		      node(LAW_RUNE, 30),
		      node(BLOOD_RUNE, 15),
		      node(FIRE_TALISMAN, 1),
		      node(WATER_TALISMAN, 1),
		      node(CRYSTAL_KEY, 1),
		      node(GANODERMIC_FLAKE, Utils.random(30, 350)));
			break;
		case RARE:
			dissectNodeBatch(1, 
			  node(POLYPORE_STICK, 1),
			  node(SPIRIT_SEED, 1),
			  node(YEW_SEED, 1),
			  node(TORSTOL_SEED, 1),
			  node(MAGIC_SEED, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,
			  node(STARVED_ACIENT_EFFIGY, 1),
			  node(LONG_BONE, 1),
			  node(CURVED_BONE, 1),
			  node(CRYSTAL_KEY, 2));
			break;
		}
		addObj(BIG_BONES, 1);
		shakeSummoningCharm(30, 3, 3, 4, 6);

	}
}
