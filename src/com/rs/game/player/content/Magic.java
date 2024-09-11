package com.rs.game.player.content;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.Animation;
import com.rs.game.Graphics;
import com.rs.game.World;
import com.rs.game.WorldTile;
import com.rs.game.item.Item;
import com.rs.game.minigames.clanwars.FfaZone;
import com.rs.game.minigames.clanwars.RequestController;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.Utils;

/*
 * content package used for static stuff
 */
public class Magic {

    public static final int MAGIC_TELEPORT = 0, ITEM_TELEPORT = 1,
	    OBJECT_TELEPORT = 2;

    private static final int AIR_RUNE = 556, WATER_RUNE = 555;
    public static final int EARTH_RUNE = 557;
    static final int FIRE_RUNE = 554;
    private static final int BODY_RUNE = 559;
    private static final int MIND_RUNE = 558;
    public static final int NATURE_RUNE = 561;
    private static final int CHAOS_RUNE = 562;
    public static final int DEATH_RUNE = 560;
    private static final int BLOOD_RUNE = 565;
    private static final int SOUL_RUNE = 566;
    
    public static final int ASTRAL_RUNE = 9075;
    private static final int LAW_RUNE = 563;
    @SuppressWarnings("unused")
    private static final int STEAM_RUNE = 4694;
    @SuppressWarnings("unused")
    private static final int MIST_RUNE = 4695;
    @SuppressWarnings("unused")
    private static final int DUST_RUNE = 4696;
    @SuppressWarnings("unused")
    private static final int SMOKE_RUNE = 4697;
    @SuppressWarnings("unused")
    private static final int MUD_RUNE = 4698;
    @SuppressWarnings("unused")
    private static final int LAVA_RUNE = 4699;
    private static final int ARMADYL_RUNE = 21773;
    private static final int ELEMENTAL_RUNE = 12850;
    private static final int CATALYTIC_RUNE = 12851;

    public static final boolean hasInfiniteRunes(int runeId, int weaponId, int shieldId) {
	if (runeId == AIR_RUNE) {
	    if (weaponId == 23044 || weaponId == 1381 || weaponId == 1397 || weaponId == 1405 || weaponId == 21777 || weaponId == 11736 || weaponId == 11738) // air
																	 // staff
		return true;
	} else if (runeId == WATER_RUNE) {
	    if (weaponId == 23045 || weaponId == 1383 || weaponId == 1395 || weaponId == 1403 || shieldId == 18346 || weaponId == 6563 || weaponId == 6726) // water
																       // staff
		return true;
	} else if (runeId == EARTH_RUNE) {
	    if (weaponId == 23046 || weaponId == 1385 || weaponId == 1399 || weaponId == 1407 || weaponId == 3053 || weaponId == 3054 || weaponId == 6563 || weaponId == 6726) // earth
																			  // staff
		return true;
	} else if (runeId == FIRE_RUNE) {
	    if (weaponId == 23047 || weaponId == 1387 || weaponId == 1393 || weaponId == 1401 || weaponId == 3053 || weaponId == 3054 || weaponId == 11736 || weaponId == 11738) // fire
																			    // staff
		return true;
	}
	return false;
    }
    
    public static void resourcesTeleport(final Player player, final int x,
			final int y, final int h) {
		player.lock(3);
		WorldTasksManager.schedule(new WorldTask() {
			int loop;
			@Override
			public void run() {
				if (loop == 0) {
					player.animate(new Animation(13288));
					player.gfx(new Graphics(2516));
				} else if (loop == 1) {
					player.setNextWorldTile(new WorldTile(x, y, h));
					player.animate(new Animation(13285));
					player.gfx(new Graphics(2517));
				}
				loop++;
			}
		}, 0, 1);
	}

    public static boolean hasSpecialRunes(Player player, int runeId, int amountRequired) {
	if (player.getInventory().containsItem(ELEMENTAL_RUNE, amountRequired)) {
	    if (runeId == AIR_RUNE || runeId == WATER_RUNE || runeId == EARTH_RUNE || runeId == FIRE_RUNE)
		return true;
	}
	if (player.getInventory().containsItem(CATALYTIC_RUNE, amountRequired)) {
	    if (runeId == ARMADYL_RUNE || runeId == MIND_RUNE || runeId == CHAOS_RUNE || runeId == DEATH_RUNE || runeId == BLOOD_RUNE || runeId == BODY_RUNE || runeId == NATURE_RUNE || runeId == ASTRAL_RUNE || runeId == SOUL_RUNE || runeId == LAW_RUNE)
		return true;
	}
	return false;
    }

    public static int getRuneForId(int runeId) {
	if (runeId == AIR_RUNE || runeId == WATER_RUNE || runeId == EARTH_RUNE || runeId == FIRE_RUNE)
	    return ELEMENTAL_RUNE;
	else if (runeId == ARMADYL_RUNE || runeId == DEATH_RUNE || runeId == MIND_RUNE || runeId == CHAOS_RUNE || runeId == BLOOD_RUNE || runeId == BODY_RUNE || runeId == NATURE_RUNE || runeId == ASTRAL_RUNE || runeId == SOUL_RUNE || runeId == LAW_RUNE)
	    return CATALYTIC_RUNE;
	return -1;
    }


    


    
    public void startSkyJumpTeleport(final Player player, final WorldTile tile) {
		WorldTasksManager.schedule(new WorldTask() {
			int loop = 0;
			@Override
			public void run() {
				if (loop == 0) {
					player.animate(new Animation(17317));
					player.gfx(new Graphics(3310));
					player.gfx(new Graphics(3311));
				} else if (loop == 8) {
					player.setNextWorldTile(new WorldTile(tile));
				} else if (loop == 10) {
					player.animate(new Animation(16386));
					player.gfx(new Graphics(3019));
				} else if (loop == 11) {
					player.animate(new Animation(808));
					player.gfx(new Graphics(-1));
					stop();
				}
				loop++;
			}
		}, 0, 1);
	}
    
    public static void AssasianTeleport(final Player player,
			int i, int j, final WorldTile tile) {
		if (!player.getControlerManager().processObjectTeleport(tile))
			return;
		WorldTasksManager.schedule(new WorldTask() {
			int loop;

			@Override
			public void run() {
				if (loop == 0) {
					player.animate(new Animation(17074));
					player.gfx(new Graphics(3215));
				} else if (loop == 6) {
					player.setNextWorldTile(tile);
				} else if (loop == 7) {
				player.animate(new Animation(16386));
				player.gfx(new Graphics(3019));
				}
				loop++;
			}
		}, 0, 1);
}
	
	public static void DemonicTeleport(final Player player,
			int i, int j, final WorldTile tile) {
		if (!player.getControlerManager().processObjectTeleport(tile))
			return;
		WorldTasksManager.schedule(new WorldTask() {
			int loop;

			@Override
			public void run() {
				if (loop == 0) {
					player.animate(new Animation(17108));
					player.gfx(new Graphics(3224));
					player.gfx(new Graphics(3225));
				} else if (loop == 8) {
					player.setNextWorldTile(tile);
				} else if (loop == 10) {
				player.animate(new Animation(16386));
				player.gfx(new Graphics(3019));
				}
				loop++;
			}
		}, 0, 1);
}
	
	public static void PegasusTeleport(final Player player,
			int i, int j, final WorldTile tile) {
		if (!player.getControlerManager().processObjectTeleport(tile))
			return;
		WorldTasksManager.schedule(new WorldTask() {
			int loop;

			@Override
			public void run() {
				if (loop == 0) {
					player.animate(new Animation(17106));
					player.gfx(new Graphics(3223));
				} else if (loop == 6) {
					player.setNextWorldTile(tile);
				} else if (loop == 7) {
				player.animate(new Animation(16386));
				player.gfx(new Graphics(3019));
				}
				loop++;
			}
		}, 0, 1);
}
	
	public static void GnomeTeleport(final Player player,
			int i, int j, final WorldTile tile) {
		if (!player.getControlerManager().processObjectTeleport(tile))
			return;
		WorldTasksManager.schedule(new WorldTask() {
			int loop;

			@Override
			public void run() {
				if (loop == 0) {
					player.animate(new Animation(17191));
					player.gfx(new Graphics(3254));
				} else if (loop == 6) {
					player.setNextWorldTile(tile);
				} else if (loop == 7) {
				player.animate(new Animation(16386));
				player.gfx(new Graphics(3019));
				}
				loop++;
			}
		}, 0, 1);
}

    @SuppressWarnings("unused")
	private static void useHomeTele(Player player) {
		player.stopAll();
		player.getInterfaceManager().sendInterface(1092);
    }

    public static final boolean checkSpellRequirements(Player player, int level, boolean delete, int... runes) {
	if (!checkSpellLevel(player, level))
	    return false;
	return checkRunes(player, delete, runes);
    }

    public static boolean checkSpellLevel(Player player, int level) {
	if (player.getSkills().getLevel(Skills.MAGIC) < level) {
	    player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
	    return false;
	}
	return true;
    }

    public static boolean hasStaffOfLight(int weaponId) {
	if (weaponId == 15486 || weaponId == 22207 || weaponId == 22209 || weaponId == 22211 || weaponId == 22213)
	    return true;
	return false;
    }
    
    public static void DaemonheimTeleport(final Player player, int i, int j, final WorldTile tile) {
		if (!player.getControlerManager().processItemTeleport(tile))
			return;
			WorldTasksManager.schedule(new WorldTask() {
			int loop;
			
			@Override
			public void run() {
			WorldTile teleTile = tile;
			teleTile = new WorldTile(tile, 2);
			teleTile = tile;						
				if (loop == 0) {
	                player.animate(new Animation(13652));
					player.gfx(new Graphics(2602));
				} else if (loop == 5) {
				player.setNextWorldTile(teleTile);
				//player.setNextWorldTile(new WorldTile(3449, 3698, 0));
				} else if (loop == 6) {
					player.animate(new Animation(13654));
					player.gfx(new Graphics(2603));
					stop();
				}
					loop++;
				}
			}, 0, 1);
		}
    
    public static void ectophialTeleport(final Player player, int i, int j, final WorldTile tile){
    	if (!player.getControlerManager().processItemTeleport(tile))
			return;
    	WorldTasksManager.schedule(new WorldTask() {
			int loop;
			@Override
			public void run() {
				if(loop == 0){
					player.gfx(new Graphics(1688));
					player.animate(new Animation(9609));
				}else if(loop == 6){
					player.addWalkSteps(2461, 3382, player.getPlane(), false);
					stop();
				}
				loop++;
			}
    	}, 0, 1);
    }
    
    public static void useEctoPhial(final Player player, Item item) {
		player.gfx(new Graphics(1688));
		player.animate(new Animation(9609));
		WorldTasksManager.schedule(new WorldTask() {
		    @Override
		    public void run() {
		    		sendTeleportSpell(player, 8939, 8941, 1678, 1679, 0, 0, new WorldTile(3659, 3522, 0), 4, true, ITEM_TELEPORT);
		    }
		}, 6);
    }

    public static final boolean checkRunes(Player player, boolean delete, int... runes) {
	int weaponId = player.getEquipment().getWeaponId();
	int shieldId = player.getEquipment().getShieldId();
	int runesCount = 0;
	while (runesCount < runes.length) {
	    int runeId = runes[runesCount++];
	    int amount = runes[runesCount++];
	    if (hasInfiniteRunes(runeId, weaponId, shieldId))
		continue;
	    else if (hasSpecialRunes(player, runeId, amount))
		continue;
	    else if (hasStaffOfLight(weaponId) && Utils.getRandom(8) == 0 && runeId != 21773)// 1
											     // in
											     // eight
											     // chance
											     // of
											     // keeping
											     // runes
		continue;
	    if (!player.getInventory().containsItem(runeId, amount)) {
		player.getPackets().sendGameMessage("You do not have enough " + ItemDefinitions.getItemDefinitions(runeId).getName().replace("rune", "Rune") + "s to cast this spell.");
		return false;
	    }
	}
	if (delete) {
	    runesCount = 0;
	    while (runesCount < runes.length) {
		int runeId = runes[runesCount++];
		int amount = runes[runesCount++];
		if (hasInfiniteRunes(runeId, weaponId, shieldId))
		    continue;
		if (hasSpecialRunes(player, runeId, amount))
		    runeId = getRuneForId(runeId);
		player.getInventory().deleteItem(runeId, amount);
	    }
	}
	return true;
    }

    public static final void sendAncientTeleportSpell(Player player, int level, double xp, WorldTile tile, int... runes) {
	sendTeleportSpell(player, 1979, -1, 1681, -1, level, xp, tile, 5, true, MAGIC_TELEPORT, runes);
    }

    public static final void sendLunarTeleportSpell(Player player, int level, double xp, WorldTile tile, int... runes) {
	sendTeleportSpell(player, 9606, -2, 1685, -1, level, xp, tile, 5, true, MAGIC_TELEPORT, runes);
    }

    public static final boolean sendNormalTeleportSpell(Player player, int level, double xp, WorldTile tile, int... runes) {
	return sendTeleportSpell(player, 8939, 8941, 1576, 1577, level, xp, tile, 3, true, MAGIC_TELEPORT, runes);
    }

    public static final boolean sendItemTeleportSpell(Player player, boolean randomize, int upEmoteId, int upGraphicId, int delay, WorldTile tile) {
	return sendTeleportSpell(player, upEmoteId, -2, upGraphicId, -1, 0, 0, tile, delay, randomize, ITEM_TELEPORT);
    }

    public static void pushLeverTeleport(final Player player, final WorldTile tile) {
	pushLeverTeleport(player, tile, 2140, null, null);
    }

    public static void pushLeverTeleport(final Player player, final WorldTile tile, int emote, String startMessage, final String endMessage) {
	if (!player.getControlerManager().processObjectTeleport(tile))
	    return;
	player.animate(new Animation(emote));
	if (startMessage != null)
	    player.getPackets().sendGameMessage(startMessage, true);
	player.lock();
	WorldTasksManager.schedule(new WorldTask() {
	    @Override
	    public void run() {
		player.unlock();
		Magic.sendObjectTeleportSpell(player, false, tile);
		if (endMessage != null)
		    player.getPackets().sendGameMessage(endMessage, true);
	    }
	}, 1);
    }

    public static final void sendObjectTeleportSpell(Player player, boolean randomize, WorldTile tile) {
	sendTeleportSpell(player, 8939, 8941, 1576, 1577, 0, 0, tile, 3, randomize, OBJECT_TELEPORT);
    }

    public static final void sendDelayedObjectTeleportSpell(Player player, int delay, boolean randomize, WorldTile tile) {
	sendTeleportSpell(player, 8939, 8941, 1576, 1577, 0, 0, tile, delay, randomize, OBJECT_TELEPORT);
    }

    public static final boolean sendTeleportSpell(final Player player, int upEmoteId, final int downEmoteId, int upGraphicId, final int downGraphicId, int level, final double xp, final WorldTile tile, int delay, final boolean randomize, final int teleType, int... runes) {
	if (player.isLocked())
	    return false;
	if (player.getSkills().getLevel(Skills.MAGIC) < level) {
	    player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
	    return false;
	}
	if (!checkRunes(player, false, runes))
	    return false;
	if (teleType == MAGIC_TELEPORT) {
	    if (!player.getControlerManager().processMagicTeleport(tile))
		return false;
	} else if (teleType == ITEM_TELEPORT) {
	    if (!player.getControlerManager().processItemTeleport(tile))
		return false;
	} else if (teleType == OBJECT_TELEPORT) {
	    if (!player.getControlerManager().processObjectTeleport(tile))
		return false;
	}
	checkRunes(player, true, runes);
	player.stopAll();
	if (upEmoteId != -1)
	    player.animate(new Animation(upEmoteId));
	if (upGraphicId != -1)
	    player.gfx(new Graphics(upGraphicId));
	if (teleType == MAGIC_TELEPORT)
	    player.getPackets().sendSound(5527, 0, 2);
	player.lock(3 + delay);
	WorldTasksManager.schedule(new WorldTask() {

	    boolean removeDamage;

	    @Override
	    public void run() {
		if (!removeDamage) {
		    WorldTile teleTile = tile;
		    if (randomize) {
			// attemps to randomize tile by 4x4 area
			for (int trycount = 0; trycount < 10; trycount++) {
			    teleTile = new WorldTile(tile, 2);
			    if (World.isTileFree(tile.getPlane(), teleTile.getX(), teleTile.getY(), player.getSize()))
				break;
			    teleTile = tile;
			}
		    }
		    player.setNextWorldTile(teleTile);
		    player.getControlerManager().magicTeleported(teleType);
		    if (player.getControlerManager().getControler() == null)
			teleControlersCheck(player, teleTile);
		    if (xp != 0)
			player.getSkills().addXp(Skills.MAGIC, xp);
		    if (downEmoteId != -1)
			player.animate(new Animation(downEmoteId == -2 ? -1 : downEmoteId));
		    if (downGraphicId != -1)
			player.gfx(new Graphics(downGraphicId));
		    if (teleType == MAGIC_TELEPORT) {
			player.getPackets().sendSound(5524, 0, 2);
			player.setNextFaceWorldTile(new WorldTile(teleTile.getX(), teleTile.getY() - 1, teleTile.getPlane()));
			player.setDirection(6);
		    }
		    removeDamage = true;
		} else {
		    player.resetReceivedHits();
		    stop();
		}
	    }
	}, delay, 0);
	return true;
    }

    private final static WorldTile[] TABS = { new WorldTile(3217, 3426, 0), new WorldTile(3222, 3218, 0), new WorldTile(2965, 3379, 0), new WorldTile(2758, 3478, 0), new WorldTile(2660, 3306, 0) };

    public static boolean useTabTeleport(final Player player, final int itemId) {
	if (itemId < 8007 || itemId > 8007 + TABS.length - 1)
	    return false;
	if (useTeleTab(player, TABS[itemId - 8007]))
	    player.getInventory().deleteItem(itemId, 1);
	return true;
    }

    public static boolean useTeleTab(final Player player, final WorldTile tile) {
	if (!player.getControlerManager().processItemTeleport(tile))
	    return false;
	player.lock();
	player.animate(new Animation(9597));
	player.gfx(new Graphics(1680));
	WorldTasksManager.schedule(new WorldTask() {
	    int stage;

	    @Override
	    public void run() {
		if (stage == 0) {
		    player.animate(new Animation(4731));
		    stage = 1;
		} else if (stage == 1) {
		    WorldTile teleTile = tile;
		    // attemps to randomize tile by 4x4 area
		    for (int trycount = 0; trycount < 10; trycount++) {
			teleTile = new WorldTile(tile, 2);
			if (World.isTileFree(tile.getPlane(), teleTile.getX(), teleTile.getY(), player.getSize()))
				    break;
				teleTile = tile;
			    }
			    player.setNextWorldTile(teleTile);
			    player.getControlerManager().magicTeleported(ITEM_TELEPORT);
		    if (player.getControlerManager().getControler() == null)
				teleControlersCheck(player, teleTile);
			    player.setNextFaceWorldTile(new WorldTile(teleTile.getX(), teleTile.getY() - 1, teleTile.getPlane()));
			    player.setDirection(6);
			    player.animate(new Animation(-1));
			    stage = 2;
			} else if (stage == 2) {
			    player.resetReceivedHits();
			    player.unlock();
			    stop();
			}
	
		    }
		}, 2, 1);
		return true;
    }

    public static void teleControlersCheck(Player player, WorldTile teleTile) {
		
		if (RequestController.inWarRequest(player))
		    player.getControlerManager().startControler("clan_wars_request");
		else if (FfaZone.inArea(player))
		    player.getControlerManager().startControler("clan_wars_ffa");
    }

    private Magic() {

    }

   
}

