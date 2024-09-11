package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class CommanderZilyana extends MobRewardNodeBuilder {

	public CommanderZilyana() {
		super(new Object[] { "Commander Zilyana", 6247 });
	}

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(GRIMY_RANARR_NOTED, 5), node(RANARR_SEED, 2), node(RUNE_DART, 40), node(COINS, 21000));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(PRAYER_POTION4_2434, 3), node(SARADOMIN_BREW3_6687, 3), node(SUPER_RESTORE4_3024, 3), node(SUPER_DEFENCE3_163, 3), node(SUPER_MAGIC_POTION_4, 3), node(MAGIC_LOGS_NOTED, 40), node(CRYSTAL_KEY, 1));
			break;
		case RARE:
			dissectNodeBatch(1, node(COINS, 21000), node(CRYSTAL_KEY, 1), node( MAGIC_SEED, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1,node(SARADOMIN_SWORD, 1), node(SARADOMIN_WHISPER, 1), node(SARADOMIN_HISS, 1), node(SARADOMIN_MURMUR, 1), node(SARADOMIN_HILT_11706, 1), node(GODSWORD_SHARD_1, 1), node(GODSWORD_SHARD_2,1),
			                   node(GODSWORD_SHARD_3, 1), node(COINS, 120000));
			break;
		}
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(3, 6, 10, 15, 7);

	}
}
