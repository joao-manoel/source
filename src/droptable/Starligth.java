package droptable;

import com.rs.game.npc.MobRewardNodeBuilder;
import com.rs.game.player.Player;

public final class Starligth extends MobRewardNodeBuilder {

	public Starligth() {
		super(new Object[] { "Starligth", -1 });
	}
  //para randomizar a quantidade
  //Utils.random(1, 2)

  //node(id, quantidade)

	@Override
	public void populate(Player player) {
		switch (rarityNode(player)) {
		case -1:
		case COMMON:
			dissectNodeBatch(1,  node(STEEL_DART_808, 100),node(GRIMY_MARRENTILL_NOTED, 5), node(LAW_RUNE, 10), node(STEEL_ARROW, 150));
			break;
		case UNCOMMON:
			dissectNodeBatch(1, node(COINS, 1500));
			break;
		case RARE:
			dissectNodeBatch(1, node(UNICORN_HORN_1487, 1), node(SNAPE_GRASS, 5), node(GODSWORD_SHARD_1, 1), node(GODSWORD_SHARD_2, 1), node(GODSWORD_SHARD_3, 1));
			break;
		case VERY_RARE:
			dissectNodeBatch(1, node(SARADOMIN_WHISPER, 1), node(SARADOMIN_HISS, 1), node(SARADOMIN_MURMUR, 1), node(SARADOMIN_SWORD, 1));
			break;
		}
    
    //shakeSummoningCharm(1, gold, green, crismon, blue);
		shakeSummoningCharm(5, 9, 4, 8, 2);

	}
}
