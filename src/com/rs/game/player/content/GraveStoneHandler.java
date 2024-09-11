package com.rs.game.player.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.rs.cores.CoresManager;
import com.rs.game.Animation;
import com.rs.game.World;
import com.rs.game.WorldTile;
import com.rs.game.item.FloorItem;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.utils.Logger;
import com.rs.utils.Utils;


/**
 * 
 * @author Josh'
 *
 */
@SuppressWarnings("serial")
public class GraveStoneHandler extends NPC {

	private String gsUsername;
    
    private int hintIconID;
    
    private int gs;
    
	private static final List<GraveStoneHandler> worldGS = new ArrayList<GraveStoneHandler>();

    public static GraveStoneHandler getGraveStoneByUsername(String gsUsername) {
		for (GraveStoneHandler grave : worldGS)
		    if (grave.gsUsername.equals(gsUsername))
		    	return grave;
		return null;
    }
    
    private Player getPlayer() {
    	return World.getPlayer(gsUsername);
    }
    
    private String getInscriptionDisplay(String u) {
    	u = Utils.formatPlayerNameForDisplay(u);
		switch (gs) {
		    case 0:
		    case 1:
		    	return "In memory of <i>" + u + "</i>,<br>who died here.";
		    case 2:
		    case 3:
		    	return "In loving memory of our dear friend <i>" + u + "</i>,who <br>died in this place @X@ minutes ago.";
		    case 4:
		    case 5:
		    	return "In your travels, pause awhile to remember <i>" + u + "</i>,<br>who passed away at this spot.";
		    case 6:
		    	return "<i>" + u + "</i>, <br>an enlightened servant of Saradomin,<br>perished in this place.";
		    case 7:
		    	return "<i>" + u + "</i>, <br>a most bloodthirsty follower of Zamorak,<br>perished in this place.";
		    case 8:
		    	return "<i>" + u + "</i>, <br>who walked with the Balance of Guthix,<br>perished in this place.";
		    case 9:
		    	return "<i>" + u + "</i>, <br>a vicious warrior dedicated to Bandos,<br>perished in this place.";
		    case 10:
		    	return "<i>" + u + "</i>, <br>a follower of the Law of Armadyl,<br>perished in this place.";
		    case 11:
		    	return "<i>" + u + "</i>, <br>servant of the Unknown Power,<br>perished in this place.";
		    case 12:
		    	return "Ye frail mortals who gaze upon this sight, forget not<br>the fate of <i>" + u + "</i>, once mighty, now surrendered to the inescapable grasp of destiny.<br><i>Requiescat in pace.</i>";
		    case 13:
		    	return "Here lies <i>" + u + "</i>, friend of dwarves. Great in<br>life, glorious in death. His/Her name lives on in<br>song and story.";
		}
		return "" + u + " died here nigga.";
    }
    
    public static int getMaxAmountOnTimer(int grave) {
    	switch (grave) {
    	case 0:
    	 	return 500;
    	case 1:
    	case 2:
    	   	return 600;
    	case 3:
    	 	return 800;
    	case 4:
    	case 5:
    	case 6:
    	case 7:
    	case 8:
    	case 9:
    	case 10:
    	case 11:
    	   	return 1000;
    	case 12:
    	  	return 1200;
    	case 13:
    	   	return 1500;
    	}
    	return 500;
    }
    
    private String inscription;
    
    public void sendGraveInscription(Player player) {
    	player.getInterfaceManager().sendInterface(266);
    	player.getVarsManager().setVarBit(4191, gs == 0 ? 0 : 1);
		if (timer <= 50)
		    player.getPackets().sendIComponentText(266, 22,
		    		"The inscription is too unclear to read.");
		else if (player == getPlayer())
		    player.getPackets().sendIComponentText(266, 22,
		    		"It looks like it'll survive another " + (timer / 100)
		    		+ " minutes. Isn't there something a bit odd about reading your own gravestone?");
		else
			player.getPackets().sendIComponentText(266, 22, inscription);
    }
    
    private int timer;
    
    /*
    private void decrementTimer() {
    	timer--;
    	if (timer == 0)
    		decrementStage(-1, "Your grave has collapsed!");
    	else if (timer == 50)
    		decrementStage(2, "Your grave is collapsing.");
    	else if (timer == 100)
    		decrementStage(1, "Your grave is about to collapse.");
    	
    }
    */
    
    public void addLeftTime(boolean clean) {
		if (clean) {
		    for (FloorItem item : floorItems)
			World.turnPublic(item, 60);
		} else {
		    CoresManager.slowExecutor.schedule(new Runnable() {
			@Override
			public void run() {
			    try {
				for (FloorItem item : floorItems)
				    World.turnPublic(item, 60);
			    }
			    catch (Throwable e) {
			    	Logger.handle(e);
			    }
			}
		    }, (long) (timer * 0.6), TimeUnit.SECONDS);
		}
    }
    
    
    public void decrementStage(int stage, String message) {
    	Player player = getPlayer();
    	if (player != null) {
    	    player.getPackets().sendGameMessage("<col=7E2217>" + message);
    	    player.getPackets().sendRunScript(2434, timer);
    	}
    	if (stage == -1) {
    	    addLeftTime(true);
    	    finish();
    	} else
    	    setNextNPCTransformation(getNPCId(gs) + stage);
    }
    
    private boolean gsBlessed;
    
    public void repairGravestone(Player player, boolean blessing) {
    	if (player.getSkills().getLevel(Skills.PRAYER) < (blessing ? 70 : 2)) {
    		player.getPackets().sendGameMessage(
    				"You need a prayer level of atleast "+(blessing ? "70" : "2")
    				+" to "+(blessing ? "bless" : "repair")+" this gravestone.");
    		return;
    	}
    	if (player.getUsername().equals(gsUsername)) {
    		player.getPackets().sendGameMessage("You can't "+(blessing ? "bless" : "repair")+" your own gravestone.");
    	    return;
    	}
    	if (blessing && gsBlessed) {
    		player.getPackets().sendGameMessage("This gravestone has already been blessed.");
    		return;
    	}
    	if (!blessing && timer >= 100) {
    		player.getPackets().sendGameMessage(
    				"This gravestone is beyond repair, it looks like it will survive another " 
    						+ timer / 100 + " minutes.");
    		return;
    	}
    	timer += blessing ? 6000 : 500;
    	gsBlessed = true;
    	decrementStage(0, player.getDisplayName() + " has " + (blessing ? "blessed" : "repaired") + " your gravestone. It should survive another " + (timer / 100) + " minutes.");
    	player.getPackets().sendGameMessage(
    			"You "+(blessing ? "bless": "repair")+" " + gsUsername  +"'s gravestone, It should survive another " + (timer / 100) + " minutes.");
    	player.lock(2);
    	player.animate(new Animation(645));
    }
    
    public void demolish(Player player) {
    	if (!player.getUsername().equals(gsUsername)) {
    		player.getPackets().sendGameMessage("You can't demolish someone elses gravestone!");
    	    return;
    	}
    	//
    	//addLeftTime(true);
    	player.getPackets().sendGameMessage(
    			"It looks like it'll survive another " + (timer / 100) + " minutes. You demolish it anyway.");
    	finish();
    }

    public static int getNPCId(int currentGrave) {
		if (currentGrave == 13)
		    return 13296;
		return 6565 + (currentGrave * 3);
    }
    
    @Override
    public void finish() {
		synchronized (worldGS) {
			worldGS.remove(this);
		}
		Player player = getPlayer();
		if (player != null) {
		    player.getPackets().sendRunScript(2434, 0);
		    player.getHintIconsManager().removeHintIcon(hintIconID);
		    player.getPackets().sendGlobalConfig(623, -1);
	
		}
		super.finish();
    }


    /**
     * ROBBED FROM MX2 TY
     * @param player
     * @param atWilderness
     * @param skulled
     * @param protectPrayer
     * @return
     */
    public static Integer[][] getItemSlotsKeptOnDeath(final Player player, boolean atWilderness, boolean skulled, boolean protectPrayer) {
    	ArrayList<Integer> droppedItems = new ArrayList<Integer>();
    	ArrayList<Integer> protectedItems = atWilderness ? null : new ArrayList<Integer>();
    	ArrayList<Integer> lostItems = new ArrayList<Integer>();
    	for (int i = 1; i < 44; i++) {
    	    Item item = i >= 16 ? player.getInventory().getItem(i - 16) : player.getEquipment().getItem(i - 1);
    	    if (item == null)
    	    	continue;
    	    int stageOnDeath = item.getDefinitions().getStageOnDeath();
    	    if (!atWilderness && stageOnDeath == 1)
    	    	protectedItems.add(i);
    	    else if (stageOnDeath == -1)
    	    	lostItems.add(i);
    	    else
    	    	droppedItems.add(i);
    	}
    	int keptAmount = skulled ? 0 : 3;
    	if (protectPrayer)
    	    keptAmount++;
    	if (droppedItems.size() < keptAmount)
    	    keptAmount = droppedItems.size();
    		Collections.sort(droppedItems, new Comparator<Integer>() {
    	    @Override
    	    public int compare(Integer o1, Integer o2) {
    		Item i1 = o1 >= 16 ? player.getInventory().getItem(o1 - 16) : player.getEquipment().getItem(o1 - 1);
    		Item i2 = o2 >= 16 ? player.getInventory().getItem(o2 - 16) : player.getEquipment().getItem(o2 - 1);
    		int price1 = i1.getDefinitions().value;
    		int price2 = i2.getDefinitions().value;
    		if (price1 > price2)
    		    return -1;
    		if (price1 < price2)
    		    return 1;
    		return 0;
    	    }

    	});
    	Integer[] keptItems = new Integer[keptAmount];
    	for (int i = 0; i < keptAmount; i++)
    	    keptItems[i] = droppedItems.remove(0);
    	return new Integer[][] { keptItems, droppedItems.toArray(new Integer[droppedItems.size()]), atWilderness ? new Integer[0] : protectedItems.toArray(new Integer[protectedItems.size()]), atWilderness ? new Integer[0] : lostItems.toArray(new Integer[lostItems.size()]) };

    }
    
    /**
     * ROBBED FROM MX2 TY
     * @param player
     * @param slots
     * @return
     */
    public static Item[][] getItemsKeptOnDeath(Player player, Integer[][] slots) {
    	ArrayList<Item> droppedItems = new ArrayList<Item>();
    	ArrayList<Item> keptItems = new ArrayList<Item>();
    	
    	for (int i : slots[0]) { 
    	    Item item = i >= 16 ? player.getInventory().getItem(i - 16) : player.getEquipment().getItem(i - 1);
    	    if (item == null) 
    	    	continue;
    	    if (ItemConstants.degradeOnDrop(item))
				player.getCharges().degradeCompletly(item);
    	    if (item.getAmount() > 1) {
	    		droppedItems.add(new Item(item.getId(), item.getAmount() - 1));
	    		item.setAmount(1);
	    	    }
    	    keptItems.add(item);
    	}
    	for (int i : slots[1]) { 
    	    Item item = i >= 16 ? player.getInventory().getItem(i - 16) : player.getEquipment().getItem(i - 1);
    	    if (item == null) 
    		continue;
    	    droppedItems.add(item);
    	}
    	for (int i : slots[2]) { //items protected by default
    	    Item item = i >= 16 ? player.getInventory().getItem(i - 16) : player.getEquipment().getItem(i - 1);
    	    if (item == null) 
    		continue;
    	    keptItems.add(item);
    	}
    	return new Item[][] { keptItems.toArray(new Item[keptItems.size()]), droppedItems.toArray(new Item[droppedItems.size()]) };

    }
    
    private List<FloorItem> floorItems;
    public GraveStoneHandler(Player player, WorldTile deathTile, Item[] items) {
		super(getNPCId(player.getGraveStone()), deathTile, -1, true);
		gs = player.getGraveStone();
		setDirection(Utils.getFaceDirection(0, -1));
		animate(new Animation(gs == 1 ? 7396 : 7394));
		gsUsername = player.getUsername();
		timer = getMaxAmountOnTimer(gs);
		inscription = getInscriptionDisplay(player.getDisplayName());
		floorItems = new ArrayList<FloorItem>();
		for (Item item : items) {
		    FloorItem i = World.addGroundItem(item, deathTile, player, true, -1, 1);
		    if (i != null)
			floorItems.add(i);
		}
		synchronized (worldGS) {
		    GraveStoneHandler oldStone = getGraveStoneByUsername(gsUsername);
		    if (oldStone != null) {
			addLeftTime(false);
			oldStone.finish();
		    }
		    worldGS.add(this);
		}
		player.getPackets().sendRunScript(2434, timer);
		hintIconID = player.getHintIconsManager().addHintIcon(this, 0, -1, true);
		player.getPackets().sendGlobalConfig(623, deathTile.getTileHash());
		player.getPackets().sendGlobalConfig(624, 0);
		player.getPackets().sendGlobalString(53, "Your gravestone marker");
		player.getPackets().sendGameMessage("Your items are under your gravestone. Use the World Map if you can't find your gravestone, or to place a marker on where to go.");
		player.getPackets().sendGameMessage("It looks like it will survive another " + (timer / 100) + " minutes.");
	}
}
