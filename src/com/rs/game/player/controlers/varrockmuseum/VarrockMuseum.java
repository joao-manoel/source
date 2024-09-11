package com.rs.game.player.controlers.varrockmuseum;

import com.rs.game.Animation;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.controlers.Controler;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.Utils;

public class VarrockMuseum extends Controler {

	public static boolean CrumbledRock;
	public transient boolean forceMuseumArea;
	

	private static Item[] ARCHEOLOGYARTEFACTS = { new Item(11178), new Item(11179), new Item(11180), new Item(11181),
			new Item(11182) };

	private static final int ARROWHEADS = 11176, JEWELLERY = 11177, POTTERY = 11178, OLD_COIN = 11179,
			ANCIENT_COIN = 11180, ANCIENT_SYMBOL = 11181, OLD_SYMBOL = 11182, CHIPPED_VASE = 11183, IRON_DAGGER = 1203,
			UNCUT_OPAL = 1625, UNCUT_JADE = 1627, BONES = 526, /*COINS = 995, */BROKEN_ARROW = 687, BROKEN_GLASS = 1469;

	private static Item[] USELESSFINDS = { new Item(1203), new Item(1625), new Item(11183), new Item(1627),
			new Item(526), new Item(995), new Item(1627), new Item(687), new Item(11177), new Item(1469) };

	private static Item[] STORAGECRATE = { new Item(995, Utils.random(5, 40)), new Item(1923), new Item(1931),
			new Item(1203), new Item(9420), new Item(9440), new Item(438), new Item(436), new Item(440), new Item(447),
			new Item(453), new Item(863), new Item(453), new Item(807, Utils.random(1, 49)),
			new Item(40, Utils.random(1, 44)), new Item(1627), new Item(532), new Item(9140, Utils.random(1, 7)) };

	private static Item[] STORAGECRATERARE = { new Item(9245, Utils.random(12, 18)), new Item(452, Utils.random(4, 12)),
			new Item(2363, Utils.random(4, 7)), new Item(2362, Utils.random(9, 14)),
			new Item(18831, Utils.random(8, 16)), new Item(1514, Utils.random(22, 29)),
			new Item(1748, Utils.random(4, 7)), new Item(561, Utils.random(112, 177)) };

	// required items for clean process
	private static final int ROCKPICK = 675, TROWEL = 676, BRUSH = 670, LEATHER_BOOTS = 1061, LEATHER_GLOVES = 1059,
			UNCLEANED_FIND = 11175;

	@Override
	public void start() {
		player.getInterfaceManager().sendMuseumInterface();
		refreshKudos();
	}
	static int STUDY = 3141;

	/**
	 * Refreshes the kudos on the interface.
	 */
	private void refreshKudos() {
		player.getPackets().sendIComponentText(532, 1, ""+player.getKudos());
	}

	public static  boolean inArea(Player player) {
		return (player.getX() >= 3249 && player.getY() >= 3441 && player.getX() <= 3268 && player.getY() <= 3456);
		
	}

	private static boolean isAtBackDoorOutside(Player player) {
		return (player.getX() >= 3264 && player.getY() >= 3441 && player.getX() <= 3265 && player.getY() <= 3441);
	}

	private static boolean isAtBackDoorInside(Player player) {
		return (player.getX() >= 3264 && player.getY() >= 3442 && player.getX() <= 3265 && player.getY() <= 3442);
	}
/*
	private static boolean isAtGate(Player player) {
		return (player.getX() >= 3261 && player.getY() >= 3446);
	}*/

	private static void ItemCheck(Player player, WorldObject object) {
		boolean BackDoorOut = isAtBackDoorOutside(player);
		if (!player.getInventory().containsItem(11175, 1)) {
			player.getDialogueManager().startDialogue("MuseumGuardBackDoor"); //
			return;
		}
		if (BackDoorOut && player.getInventory().containsItem(11175, 1)) { // finds
																			// //
																			// from
																			// //
																			// digsite
			player.getDialogueManager().startDialogue("MuseumGuardDiscovery"); // allows
																				// //
																				// to
																				// //
																				// enter
			processDoor(object);
			return;
		}

	}

	private static void processDoor(WorldObject object) {
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				World.spawnObjectTemporary(new WorldObject(object.getId(), object.getType(), object.getRotation() + 1,
						object.getX(), object.getY(), object.getPlane()), 5000);
			}
		}, 3);
	}

	private static void processDoorQuick(Player player, WorldObject object) {
		if (player.getInventory().containsItem(11175, 1)) {
			player.getDialogueManager().startDialogue("SimpleMessage",
					"It seems you contain uncleaned finds, you cannot bring them outside...");
			return;
		}
		player.getDialogueManager().startDialogue("MuseumGuardQuickPass");
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				World.spawnObjectTemporary(new WorldObject(object.getId(), object.getType(), object.getRotation() + 1,
						object.getX(), object.getY(), object.getPlane()), 2000);
			}
		}, 2);
		return;
	}

	private static void processGate(Player player, WorldObject object) {
		if (player.getInventory().containsItem(11175, 1)) {
			return;
		}
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				World.spawnObjectTemporary(new WorldObject(object.getId(), object.getType(), object.getRotation() + 1,
						object.getX(), object.getY(), object.getPlane()), 2000);
			}
		}, 2);
		return;
	}

	private static void TakeFromSpecimenPile(Player player, WorldObject object) {
		if (player.getInventory().containsItem(UNCLEANED_FIND, 1)) {
			player.getDialogueManager().startDialogue("SimpleMessage",
					"You can only carry 1 uncleaned find due the weight, it seems you already obtain one.");
			return;
		}
		if (player.getInventory().getFreeSlots() < 1) {
			player.getDialogueManager().startDialogue("SimpleMessage", "Not enough space in your inventory.");
			return;
		}
		player.lock(3);
		player.getPackets().sendGameMessage("You reach for the pile...");
		player.animate(new Animation(7270));
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.getInventory().addItem(11175, 1);
				player.getPackets().sendGameMessage("and managed to obtain a uncleaned find.");
			}
		}, 2);
		return;
	}


	/**
	 * Why not check every tool at the same time? because this is to prevent
	 * duping if the player drops a item/equipment. Now it checks for every
	 * single item, so for ex: if you drop the leather gloves, and clikc on the
	 * tools, normally you will receive full equipment again. now if the player
	 * drops the leather glove, he will receive only a leather glove in return;
	 * 
	 * @param player
	 */

	private static void CheckTools(Player player) {
		if (player.getInventory().getFreeSlots() < 1) {
			player.getDialogueManager().startDialogue("SimpleMessage", "Not enough space in your inventory.");
			return;
		}
		if (!player.getInventory().containsItem(ROCKPICK, 1)) {
			player.getPackets().sendGameMessage("You reach for the tools and received a rockpick.");
			player.animate(new Animation(3864));
			player.getInventory().addItem(ROCKPICK, 1);

		}
		if (!player.getInventory().containsItem(TROWEL, 1)) {
			player.getPackets().sendGameMessage("You reach for the tools and received a trowel.");
			player.animate(new Animation(3864));
			player.getInventory().addItem(TROWEL, 1);

		}
		if (!player.getInventory().containsItem(BRUSH, 1)) {
			player.getPackets().sendGameMessage("You reach for the tools and received a brush.");
			player.animate(new Animation(3864));
			player.getInventory().addItem(BRUSH, 1);

		}
		// checks for both inventory and equipment if player has item
		if (!player.getInventory().containsItem(LEATHER_GLOVES, 1)
				&& (!(player.getEquipment().getGlovesId() == LEATHER_GLOVES))) {
			player.getPackets().sendGameMessage("You reach for the tools and received some leather gloves.");
			player.animate(new Animation(3864));
			player.getInventory().addItem(LEATHER_GLOVES, 1);
			return;
		}
		if (!player.getInventory().containsItem(LEATHER_BOOTS, 1)
				&& (!(player.getEquipment().getBootsId() == LEATHER_BOOTS))) {
			player.getPackets().sendGameMessage("You reach for the tools and received some leather boots.");
			player.animate(new Animation(3864));
			player.getInventory().addItem(LEATHER_BOOTS, 1);
			return;
		}
		player.getDialogueManager().startDialogue("SimpleMessage",
				"It seems you meet the specifications of equipment for processing finds!");
	}
	
	
	public static boolean isObject(final WorldObject object) {
		switch (object.getId()) {
		case 24565:
		case 24567:
		case 24559:
		case 24535:
		case 48627:
		case 48628:
		case 48629:
		case 48630:
		case 48631:
		case 48632:
		case 48633:
		case 48634:
		case 48635:
		case 48636:
		case 48637:
		case 48638:
		case 48639:
		case 48640:
		case 48641:
		case 24536:
		case 24358:
		case 24357:
		case 24617:
		case 12139:
		case 15484:
		case 12234:
		case 12138:
		case 12137:
		case 24544:
		case 24541:
		case 24545:
		case 24622:
		case 24625:
		case 24628:
		case 24629:
		case 12484:
		case 12232:
		case 38172:
		case 24623:
		case 24633:
		case 24636:
			
		return true;
		default:
		return false;
		}
	}
	

	public static void HandleObject(final Player player, WorldObject object) {
		boolean BackDoorIn = isAtBackDoorInside(player);
		switch (object.getId()) {
		case 24565:
		case 24567:
			if (BackDoorIn) {
				processDoorQuick(player, object);
				return;
			}
			ItemCheck(player, object);
			break;

		case 24559:
			TakeFromSpecimenPile(player, object);
			break;

		case 24535:
			CheckTools(player);
			break;
		/**
		 * start of Dahmaroc statue
		 */
		case 48627:
			Addstatue.Addstage1(player, object);
			break;
		case 48628:
			Addstatue.Addstage2(player, object);
			break;
		case 48629:
			Addstatue.Addstage3(player, object);
			break;
		case 48630:
			Addstatue.Addstage4(player, object);
			break;
		case 48631:
			Addstatue.Addstage5(player, object);
			break;
		case 48632:
			Addstatue.Addstage6(player, object);
			break;
		case 48633:
			Addstatue.Addstage7(player, object);
			break;
		case 48634:
			Addstatue.Addstage8(player, object);
			break;
		case 48635:
			Addstatue.Addstage9(player, object);
			break;
		case 48636:
			Addstatue.Addstage10(player, object);
			break;
		case 48637:
			Addstatue.Addstage11(player, object);
			break;
		case 48638:
			Addstatue.Addstage12(player, object);
			break;
		case 48639:
			Addstatue.Addstage13(player, object);
			break;
		case 48640:
			Addstatue.Addstage14(player, object);
			break;
		case 48641:
			Addstatue.FinalStage(player, object);
			break;
		/**
		 * End
		 */

		case 24536:
			player.getPackets().sendConfig(1010, player.getKudos());
			player.getDialogueManager().startDialogue("GatePass");
			processGate(player, object);
			break;

		case 24358:
			player.getPackets().sendConfig(1010, player.getKudos());
			Staircaises.VarrockMuseumUp(player, object);
			break;

		case 24357:
			player.getPackets().sendConfig(1010, player.getKudos());
			Staircaises.SharedStaircaise(player, object);
			break;

		case 24617:
			player.getDialogueManager().startDialogue("SimpleMessage",
					"This looks like some sort of quiz. I wonder if I can take part...");
			break;

		case 24359:
			player.getPackets().sendConfig(1010, player.getKudos());
			Staircaises.VarrockMuseumDown(player, object);
			break;

		case 24621:
			Interfaces.SandDisplay(player);
			break;

		case 12139:
			if (player.getInventory().containsItem(POTTERY, 1)) {
				Artefacts.CheckPottery(player);
			}
			break;

		case 15484:
			if (player.getInventory().containsItem(OLD_COIN, 1)) {
				Artefacts.CheckOldCoin(player);
			}
			break;

		case 12234:
			if (player.getInventory().containsItem(ANCIENT_COIN, 1)) {
				Artefacts.CheckAncientCoin(player);
			}
			break;

		case 12138:
			if (player.getInventory().containsItem(ANCIENT_SYMBOL, 1)) {
				Artefacts.CheckAncientSymbol(player);
			}
			break;

		case 12137:
			if (player.getInventory().containsItem(OLD_SYMBOL, 1)) {
				Artefacts.CheckOldSymbol(player);
			}
			break;

		case 24544:
			Interfaces.JewerlySaradomin(player);
			break;

		case 24541:
			Interfaces.UrnDisplay(player);
			break;

		case 24545:
			Interfaces.ArrowHeads(player);
			break;
		/**
		 * Start of 1st upper floor / museum
		 */
		case 24622:
			Interfaces.AncientMap(player);
			break;

		case 24625:
			Interfaces.GodSymbols(player);
			break;

		case 24628:
			Interfaces.AncientArtifact(player);
			break;

		case 24629:
			Interfaces.StoneHedge(player);
			break;

		// case 12234:
		case 12484:
			Interfaces.EmptyDisplay(player);
			break;
		// case 12137:
		// case 12138:
		case 12232:
			Interfaces.EmptyDisplay(player);
			break;
		case 38172:
			Interfaces.EmptyDisplay(player);
			break;
		case 24623:
			Interfaces.EmptyDisplay(player);
			break;
		case 24633:
			Interfaces.EmptyDisplay(player);
			break;
		case 24636:
			Interfaces.EmptyDisplay(player);
			break;
		}
		return;
	}


	@Override
	public boolean processObjectClick2(WorldObject object) {
		switch (object.getId()) {
		case 48628:
			player.getPackets().sendGameMessage("1/2 stge");
		}
		return true;

	}

	public static void ProspectRock(Player player) {
		player.lock(9);
		player.getPackets().sendGameMessage("You start prospecting the rock...");
		player.animate(new Animation(6459));
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.animate(new Animation(6459));

			}
		}, 1);
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.getPackets().sendGameMessage("You started to brush and clean the specimen...");
				player.animate(new Animation(6217));
				player.getInventory().deleteItem(11175, 1);
			}
		}, 10);
		return;
	}

	private static void Artefact(Player player) {
		Item[] reward = new Item[] { ARCHEOLOGYARTEFACTS[Utils.random(ARCHEOLOGYARTEFACTS.length)] };
		for (Item item : reward)
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.getPackets().sendGameMessage(
							"You discovered a artefact! it might have a valuable importance to some...");
					player.getInventory().addItem(item);
					player.getInventory().deleteItem(11175, 1);
					player.getDialogueManager().startDialogue("MuseumItemDiscovery");
				}
			});
		return;
	}

	private static void HandleLoot(Player player) {
		Item[] reward = new Item[] { USELESSFINDS[Utils.random(USELESSFINDS.length)] };
		for (Item item : reward)
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					if (Utils.random(15) == 0) {// <7.5% 2 items
						player.getPackets().sendGameMessage("...And successfully obtained another item.");
						player.getInventory().addItem(item);
						player.getInventory().addItem(item);
						player.getInventory().deleteItem(UNCLEANED_FIND, 1);
						return;
					}
					player.getInventory().addItem(item);
					player.getPackets().sendGameMessage("After cleaning, you observe and managed to obtain an item...");
					player.getInventory().deleteItem(UNCLEANED_FIND, 1);
				}
			});
		return;
	}

	private static void HandleCrateRewards(final Player player, final WorldObject object, Item item) {
		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == IRON_DAGGER)) {
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATE[Utils.random(STORAGECRATE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(IRON_DAGGER, 1);
						player.getPackets().sendGameMessage(
								"You place the useless items in the crate, receiving reward(s) in the process.");
					}
				}, 1);
			return;
		}
		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == POTTERY)) {
			/*
			if (Artefacts.FinishedPottery == false) {
				player.getDialogueManager().startDialogue("SimpleMessage",
						"You are not obligated to deposit a artefact yet! " + " Talk to one of the Archaeologists.");
				return;
			}
			*/
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATERARE[Utils.random(STORAGECRATERARE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(POTTERY, 1);
						player.getPackets().sendGameMessage(
								"You place the Artefact in the crate, receiving rare reward(s) in the process.");
					}
				}, 1);
			return;
		}
		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == OLD_COIN)) {
			/*
			if (Artefacts.FinishedOldCoin == false) {
				player.getDialogueManager().startDialogue("SimpleMessage",
						"You are not obligated to deposit a artefact yet! " + " Talk to one of the Archaeologists.");
				return;
			}
			*/
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATERARE[Utils.random(STORAGECRATERARE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(OLD_COIN, 1);
						player.getPackets().sendGameMessage(
								"You place the Artefact in the crate, receiving rare reward(s) in the process.");
					}
				}, 1);
			return;
		}
		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == ANCIENT_COIN)) {
			/*
			if (Artefacts.FinishedAncientCoin == false) {
				player.getDialogueManager().startDialogue("SimpleMessage",
						"You are not obligated to deposit a artefact yet! " + " Talk to one of the Archaeologists.");
				return;
			}*/
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATERARE[Utils.random(STORAGECRATERARE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(ANCIENT_COIN, 1);
						player.getPackets().sendGameMessage(
								"You place the Artefact in the crate, receiving rare reward(s) in the process.");
					}
				}, 1);
			return;
		}
		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == OLD_SYMBOL)) {
			/*
			if (Artefacts.FinishedOldSymbol == false) {
				player.getDialogueManager().startDialogue("SimpleMessage",
						"You are not obligated to deposit a artefact yet! " + " Talk to one of the Archaeologists.");
				return;
			}
			*/
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATERARE[Utils.random(STORAGECRATERARE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(OLD_SYMBOL, 1);
						player.getPackets().sendGameMessage(
								"You place the Artefact in the crate, receiving rare reward(s) in the process.");
					}
				}, 1);
			return;
		}
		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == ANCIENT_SYMBOL)) {
			/*
			if (Artefacts.FinishedAncientSymbol == false) {
				player.getDialogueManager().startDialogue("SimpleMessage",
						"You are not obligated to deposit a artefact yet! " + " Talk to one of the Archaeologists.");
				return;
			}
			*/
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATERARE[Utils.random(STORAGECRATERARE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(ANCIENT_SYMBOL, 1);
						player.getPackets().sendGameMessage(
								"You place the Artefact in the crate, receiving rare reward(s) in the process.");
					}
				}, 1);
			return;
		}

		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == UNCUT_OPAL)) {
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATE[Utils.random(STORAGECRATE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(UNCUT_OPAL, 1);
						player.getPackets().sendGameMessage(
								"You place the useless items in the crate, receiving reward(s) in the process.");
					}
				}, 1);
			return;
		}
		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == UNCUT_JADE)) {
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATE[Utils.random(STORAGECRATE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(UNCUT_JADE, 1);
						player.getPackets().sendGameMessage(
								"You place the useless items in the crate, receiving reward(s) in the process.");
					}
				}, 1);
			return;
		}

		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == BONES)) {
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATE[Utils.random(STORAGECRATE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(BONES, 1);
						player.getPackets().sendGameMessage(
								"You place the useless items in the crate, receiving reward(s) in the process.");
					}
				}, 1);
			return;
		}

		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == CHIPPED_VASE)) {
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATE[Utils.random(STORAGECRATE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(CHIPPED_VASE, 1);
						player.getPackets().sendGameMessage(
								"You place the useless items in the crate, receiving reward(s) in the process.");
					}
				}, 1);
			return;
		}

		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == ARROWHEADS)) {
			player.animate(new Animation(3864));
			Item[] reward = new Item[] { STORAGECRATE[Utils.random(STORAGECRATE.length)] };
			for (Item crate : reward)
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						player.getInventory().addItem(crate);
						player.getInventory().deleteItem(ARROWHEADS, 1);
						player.getPackets().sendGameMessage(
								"You place the useless items in the crate, receiving reward(s) in the process.");
					}
				}, 1);
			return;
		}

		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == BROKEN_GLASS)) {
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.getDialogueManager().startDialogue("SimpleMessage",
							"Broken glass is a useless item. The archeologists has no interests for this, therefore it cannot be exchanged.");
				}
			});
			return;
		}

		if (object.getDefinitions().name.equals("Storage crate") && (item.getId() == BROKEN_ARROW)) {
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.getDialogueManager().startDialogue("SimpleMessage",
							"Broken arrow is a useless item. The archeologists has no interests for this, therefore it cannot be exchanged.");
				}
			});
		}
		return;
	}

	public static boolean processNPCMuseum(final NPC npc, Player player) {
		switch (npc.getId()) {
		/**
		 * Start of Varrock NPC Handling
		 */

		// Guard
		case 368:
			player.getDialogueManager().startDialogue("Guard", npc.getId());
			break;

		// Da Vinci
		case 337:
			player.getDialogueManager().startDialogue("DaVinci", npc.getId());
			break;

		// Chancey
		case 339:
			player.getDialogueManager().startDialogue("Chancey", npc.getId());
			break;

		// TinseTorpe
		case 5937:
			player.getDialogueManager().startDialogue("TinseTorpe", npc.getId());
			break;

		// SincoDear
		case 5936:
			player.getDialogueManager().startDialogue("SincoDoar", npc.getId());
			break;

		// MariusGste
		case 5933:
			player.getDialogueManager().startDialogue("MariusGiste", npc.getId());
			break;

		// BarnabusHurma
		case 5932:
			player.getDialogueManager().startDialogue("BarnabusHurma", npc.getId());
			break;

		// Sani
		case 4905:
			player.getDialogueManager().startDialogue("Sani", npc.getId());
			break;

		// Benny
		case 5925:
			player.getDialogueManager().startDialogue("Benny", npc.getId());
			break;

		// Clive
		case 8174:
			player.getDialogueManager().startDialogue("Clive", npc.getId());
			break;

		// Reldo
		case 647:
			player.getDialogueManager().startDialogue("Reldo", npc.getId());
			break;

		// King Roald
		case 648:
			player.getDialogueManager().startDialogue("KingRoald", npc.getId());
			break;

		// Curator Haig Halen
		case 646:
			player.getDialogueManager().startDialogue("CuratorHaigHalen", npc.getId());
			break;
			
		// Teacher & Pupil
		case 5947:
			player.getDialogueManager().startDialogue("TeacherAndPupil");
			break;

		// Schoolboy
		case 5946:
			player.getDialogueManager().startDialogue("Schoolboy", npc.getId());
			break;

		// Museum Guard Backdoor
		case 5943:
			player.getDialogueManager().startDialogue("MuseumGuardBackDoor", npc.getId());
			break;

		// Museum Guard Indoor
		case 5941:
			npc.faceEntity(player);
			player.faceEntity(npc);
			player.getDialogueManager().startDialogue("MuseumGuardIndoor", npc.getId());
			break;

		// Schoolgirl
		case 5984:
			player.getDialogueManager().startDialogue("SchoolGirl", npc.getId());
			break;
		}
		return true;
	}

	public boolean handleItemOnObject(final Player player, final WorldObject object, final int interfaceId,
			final Item item) {
		if (object.getDefinitions().name.equals("Storage crate") && item.getId() == IRON_DAGGER
				|| item.getId() == UNCUT_OPAL || item.getId() == UNCUT_JADE || item.getId() == BONES
				|| item.getId() == ARROWHEADS || item.getId() == CHIPPED_VASE || item.getId() == POTTERY
				|| item.getId() == OLD_COIN || item.getId() == ANCIENT_COIN || item.getId() == OLD_SYMBOL
				|| item.getId() == ANCIENT_SYMBOL || item.getId() == BROKEN_GLASS || item.getId() == BROKEN_ARROW
				|| item.getId() == JEWELLERY) {
			if (player.getInventory().getFreeSlots() < 1) {
				player.getDialogueManager().startDialogue("SimpleMessage", "Not enough space in your inventory.");
				return true;
			}
			if (Utils.getRandom(50) == 0) {
				player.getDialogueManager().startDialogue("MuseumAntiqueLamp");
				return true;
			}
			HandleCrateRewards(player, object, item);
		}

		if (object.getDefinitions().name.equals("Specimen table") && item.getId() == 11175) {
			if (!player.getInventory().containsItem(ROCKPICK, 1) || !player.getInventory().containsItem(TROWEL, 1)
					|| !player.getInventory().containsItem(BRUSH, 1)) {
				player.getDialogueManager().startDialogue("SimpleMessage",
						"You do not meet the correct equipment to clean finds!"
								+ " You require: A specimen brush, trowel and a rockpick material.");
				return true;
			}
			if (!(player.getEquipment().getBootsId() == LEATHER_BOOTS)
					|| (!(player.getEquipment().getGlovesId() == LEATHER_GLOVES))) {
				player.getDialogueManager().startDialogue("SimpleMessage",
						"You still do not meet the correct equipment to clean finds!"
								+ " You need some leather boots and gloves for protection!");
				return true;
			}
			ProspectRock(player);
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					if (Utils.getRandom(50) == 0) {
						Artefact(player);
						return;
					}
					if (Utils.getRandom(10) == 0) {
						player.getDialogueManager().startDialogue("SimpleMessage",
								"The find crumbles to dust in your hands - oops! Better not let the professionals see that one!'");
						player.getPackets()
								.sendGameMessage("It appears the find crumbles in your hand, leaving dust...");
						return;
					}
					HandleLoot(player);
					return;
				}
			}, 15);
		}
		return false;
	}

	public static boolean isNPC(NPC npc) {
		switch (npc.getId()) {
		case 368:
		case 337:
		case 339:
		case 5937:
		case 5936:
		case 5933:
		case 5932:
		case 4905:
		case 5925:
		case 8174:
		case 647:
		case 648:
		case 646:
		case 5947:
		case 5946:
		case 5943:
		case 5941:
		case 5984:
		return true;
		default:
		return false;
		}
	
	}
}
