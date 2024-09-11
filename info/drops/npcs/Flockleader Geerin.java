import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public class FlockleaderGeerin extends MobRewardNodeBuilder{

	public FlockleaderGeerin() {
		super(new Object[] { "Flockleader Geerin", 6225 });
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1, node(MANTA_RAY_391, 2), node(STAFF_OF_AIR, 1), node(MUSHROOM_POTATO_7058, 1));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(CRUSHED_NEST_6693, 2), node(STAFF_OF_AIR, 1), node(MUSHROOM_POTATO_7058, 1));
		case RARE:
			dissectNodeBatch(1, node(GODSWORD_SHARD_1, 1), node(GODSWORD_SHARD_2, 1), node(GODSWORD_SHARD_3, 1));
		case VERY_RARE:
			dissectNodeBatch(1, node(ARMADYL_HELMET, 1), node(ARMADYL_CHESTPLATE, 1), node(ARMADYL_CHAINSKIRT, 1));
			break;
		}
		
		shakeSummoningCharm(1, 0.8, 4, 0.25, 0.05);
	}

}
