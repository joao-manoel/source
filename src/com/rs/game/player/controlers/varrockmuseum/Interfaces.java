package com.rs.game.player.controlers.varrockmuseum;

import com.rs.Settings;
import com.rs.game.Animation;
import com.rs.game.player.Player;

public class Interfaces {
	
	static int STUDY = 3141;
	

	 public static void EmptyDisplay(Player player) {
		 player.getInterfaceManager().sendInterface(685);
    	player.getPackets().sendIComponentText(685, 14, "#Display Reserved");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "");
    	player.getPackets().sendIComponentText(685, 17, "");
    	player.getPackets().sendIComponentText(685, 18, "It appears there is nothing interesting about this Display...");
    	player.getPackets().sendIComponentText(685, 19, "");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void StoneHedge(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "Druids");

    	player.getPackets().sendIComponentText(685, 15, "Taverley is the site of the only known example of a surviving druidic stone circle,");
    	player.getPackets().sendIComponentText(685, 16, "but the druids of Guthix speak of many others scattered around RuneScape in the past.");
    	player.getPackets().sendIComponentText(685, 17, "");
    	player.getPackets().sendIComponentText(685, 18, "Our best dating techniques place them in the 4th Age. The druids built them to worship Guthix all across the world. ");
    	player.getPackets().sendIComponentText(685, 19, "");
    	player.getPackets().sendIComponentText(685, 20, "The Druids claim to be keeping watch for Guthix, keeping balance in the world. ");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 
	 public static void ClayPottery(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "Clay Pottery");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "Two distinct types of pottery have been recovered from the Dig Site, adding evidence to the two settlements on this site. ");
    	player.getPackets().sendIComponentText(685, 17, "");
    	player.getPackets().sendIComponentText(685, 18, "The red clay pottery appears to be much older and occasionally has purple Zarosian symbols,");
    	player.getPackets().sendIComponentText(685, 19, "");
    	player.getPackets().sendIComponentText(685, 20, "while the Saradominist artefacts are usually of a lighter shade with blue decorations. ");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
     	return;
	 }
	 
	 public static void OldCoin(Player player) {
		 player.getInterfaceManager().sendInterface(685);
    	player.getPackets().sendIComponentText(685, 14, "Old Coin");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "A coin in very good condition with Saradominist markings.");
    	player.getPackets().sendIComponentText(685, 17, "It bears the word 'Saranthium', which we have found to be the name of the city being excavated east of Varrock.");
    	player.getPackets().sendIComponentText(685, 18, "");
    	player.getPackets().sendIComponentText(685, 19, "The numbers on the coin would indicate that it is from the year 3804, ");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 20, "presumably from the 3rd Age as the Godwars were coming to an end.");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 
	 public static void OldSymbol(Player player) {
		 player.getInterfaceManager().sendInterface(685);
    	player.getPackets().sendIComponentText(685, 14, "Old Symbol");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "There is no relevant data or information to this coin.");
    	player.getPackets().sendIComponentText(685, 17, "");
    	player.getPackets().sendIComponentText(685, 18, "We only know it was supported by saradomin,");
    	player.getPackets().sendIComponentText(685, 19, "and acted as a safe passage for travelers owning one.");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void AncientSymbol(Player player) {
		 player.getInterfaceManager().sendInterface(685);
    	player.getPackets().sendIComponentText(685, 14, "Ancient Symbol");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "Two or three examples have been found, but this is the best.");
    	player.getPackets().sendIComponentText(685, 17, "");
    	player.getPackets().sendIComponentText(685, 18, "Worked in blue-enamelled iron, it has not survived the ages well. ");
    	player.getPackets().sendIComponentText(685, 19, "We believe this to be from the early years when the city was still being built.");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 20, "Because it is a symbol to Saradomin,");
    	player.getPackets().sendIComponentText(685, 21, "it is believed to be from the ruins of Saranthium as opposed to Senntisten,");
     	player.getPackets().sendIComponentText(685, 22, "which was an earlier settlement on the same location and of Zarosian religion. ");
      	return;
	 }
	 
	 public static void AncientCoin(Player player) {
		 player.getInterfaceManager().sendInterface(685);
    	player.getPackets().sendIComponentText(685, 14, "Ancient Coin");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "A battered and bent coin with Zamorakian markings.");
    	player.getPackets().sendIComponentText(685, 17, "");
    	player.getPackets().sendIComponentText(685, 18, "It bears the word 'Senntisten', which we believe to be the original name of the city, ");
    	player.getPackets().sendIComponentText(685, 19, "Saranthium, before it was rebuilt by those loyal to Saradomin.");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 20, "Partial numbers on the coin would indicate that it is from the year 3740, presumably from the 3rd Age.");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void JewerlySaradomin(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "Fine Jewerly");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "Fine silver and gold jewellery has been found concealed in one of the many urns scattered around the Dig Site.");
    	player.getPackets().sendIComponentText(685, 17, "Not much is know about it, although most of the items do have Saradominist markings. ");
    	player.getPackets().sendIComponentText(685, 18, "");
    	player.getPackets().sendIComponentText(685, 19, "");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void UrnDisplay(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "Urns & Vases");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "One of the few vases found in good condition. Its markings show some kind of celebration to Saradomin. ");
    	player.getPackets().sendIComponentText(685, 17, "");
    	player.getPackets().sendIComponentText(685, 18, "");
    	player.getPackets().sendIComponentText(685, 19, "");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void AncientMap(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "1st�2nd Ages ");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "The 1st Age is thought to have been 4,000 years long.");
    	player.getPackets().sendIComponentText(685, 17, "The world of "+Settings.SERVER_NAME+" is said to have been created by the gods Saradomin, Zamorak, and Guthix at the start of the 1st Age.");
    	player.getPackets().sendIComponentText(685, 18, "However, recent evidence from a brave adventurer suggests that Zamorak was not a god at this point in time so would not have been able to create worlds.");
    	player.getPackets().sendIComponentText(685, 19, "It's thought that for much of this time the gods were still in the process of forming the world and making the various lands, seas, plants, and animals.");
    	player.getPackets().sendIComponentText(685, 20, "This map is our approximation of the lands at that time, based upon our existing knowledge of the world ");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void AncientArtifact(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "3rd Age - 4,000 years long ");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "Finds indicate that at the beginning of the 4th Age,");
    	player.getPackets().sendIComponentText(685, 17, "the humans who had survived the god wars formed nomadic tribes that battled for survival against not only each other, ");
    	player.getPackets().sendIComponentText(685, 18, "but also the dwarves, goblins, ogres, gnomes and many more races that were competing for land and resources.");
    	player.getPackets().sendIComponentText(685, 19, "Over time, they started to make more permanent settlements throughout the world,");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 21, "but they continued to battle with their neighbours. ");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void GodSymbols(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "4th Age - 2,000 years long ");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "The scorched earth of the Wilderness is a lasting reminder of the destruction wrought during the God Wars. ");
    	player.getPackets().sendIComponentText(685, 17, "The little evidence found intact from these times would indicate that most of the mortal races only just survived this onslaught.");
    	player.getPackets().sendIComponentText(685, 18, "Stories handed down over generations tell of great, powerful entities and agents of the gods fighting cataclysmic wars. ");
    	player.getPackets().sendIComponentText(685, 19, "However, at the end of this 4,000 year long 3rd Age,");
    	player.getPackets().sendIComponentText(685, 20, "it seems that Saradomin, Guthix, and Zamorak settled for a less direct influence on our world. ");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void ArrowHeads(Player player) {
		 player.getInterfaceManager().sendInterface(685);
		 player.animate(new Animation(STUDY));
    	player.getPackets().sendIComponentText(685, 14, "ArrowHeads");
    	player.getPackets().sendIComponentText(685, 15, "");
    	player.getPackets().sendIComponentText(685, 16, "Arrowheads of crude bronze have been found along with the finds deeper in the Dig Site,");
    	player.getPackets().sendIComponentText(685, 17, "which leads us to believe that the forces occupying the city before the Saradominists used bows, as well as other methods of war. ");
    	player.getPackets().sendIComponentText(685, 18, "");
    	player.getPackets().sendIComponentText(685, 19, "");
    	player.getPackets().sendIComponentText(685, 20, "");
    	player.getPackets().sendIComponentText(685, 21, "");
     	player.getPackets().sendIComponentText(685, 22, "");
      	return;
	 }
	 
	 public static void SandDisplay(Player player) {
	player.getInterfaceManager().sendInterface(685);
	 player.animate(new Animation(STUDY));
	player.getPackets().sendIComponentText(685, 14, "The Layers of Archaeology");
	player.getPackets().sendIComponentText(685, 15, "O horizon - The top layer of soil is made up mostly of leaves and decomposed organic matter."
			+ " ");
	player.getPackets().sendIComponentText(685, 16, "A horizon (topsoil) - Plants grow in this dark-coloured layer, which is made up of decomoposed organic matter mixed with mineral particles."
			+ " ");
	player.getPackets().sendIComponentText(685, 17, "B horizon (subsoil) - Contains clay and mineral deposits it receives from layers above, when water drips through."
			+ " ");
	player.getPackets().sendIComponentText(685, 18, "E horizon - This eluviation (leaching) layer has a light colour and is made up of sand and silt. We often find significant archaeological artefacts in this layer.");
	player.getPackets().sendIComponentText(685, 19, "C horizon - Regolith consists of slightly broken up bedrock. Plant roots do not penetrate this layer.");
	player.getPackets().sendIComponentText(685, 20, "R horizon - The bedrock layer that is beneath all other layers. ");
	player.getPackets().sendIComponentText(685, 20, "");
	player.getPackets().sendIComponentText(685, 21, "");
	player.getPackets().sendIComponentText(685, 22, "");
  	return;
	 }
}
