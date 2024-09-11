package com.rs.game.player.content.customshops;

import java.util.ArrayList;
import java.util.List;

import com.rs.Settings;
import com.rs.game.item.Item;
import com.rs.game.player.Player;

public class CustomStoreData {
	

	protected int INTERFACE_ID = 3010;

	protected final int COINS = 0, SKILLCAPE = 3;

	public final int[] COMPONENTS = { 25, 31, 37, 43, 49, 55, 61, 67, 73, 79, 85, 91, 97, 103, 109, 115, 121, 127, 133,
			139, 145, 151, 157, 163, 169, 175, 181, 187, 193, 199, 205, 211, 217, 223, 229, 235, 241, 247, 253, 259,
			265, 271, 277, 283, 289, 295, 301, 307, 313, 319, 325, 331, 337, 343, 349, 355, 361, 367, 373, 379, 385,
			391, 397, 403, 409, 415, 421, 427, 433, 439, 445, 451, 457, 463, 469, 475, 481, 487 };

	public static final int GENERAL_STORE = 100;
	public static final int SUPPLY_SHOP = 1;
	public static final int MELEE_SHOP = 2;
	public static final int RANGE_SHOP = 3;
	public static final int MAGIC_SHOP = 4;
	public static final int ACCESSORIES = 5;
	public static final int POTION_MEMBER_1 = 6;
	public static final int POTION_MEMBER_2 = 7;
	public static final int BARROWS_SHOP = 8;
	public static final int SKILLING_SHOP = 9; // tools
	public static final int SKILLING_SHOP_2 = 10; // herb
	public static final int SKILLING_SHOP_3 = 11; //rc
	public static final int SKILLING_SHOP_4 = 12;
	public static final int SKILLING_SHOP_5 = 13;
	
	public static final int CONSTRUCTION = 14;
	public static final int SUMMONING = 15;
	public static final int CUSTOMITEMS = 16;
	
	
	
	
	public static final int AVALON_POINTS = 101;
	public static final int PK_POINTS = 102;
	public static final int RUBY = 103;

	protected static List<Item> magic = new ArrayList<>();
	protected static List<Item> melee = new ArrayList<>();
	protected static List<Item> range = new ArrayList<>();
	protected static List<Item> supplies = new ArrayList<>();
	protected static List<Item> barrows = new ArrayList<>();
	
	protected static List<Item> skilling = new ArrayList<>();
	protected static List<Item> skilling2 = new ArrayList<>();
	protected static List<Item> skilling3 = new ArrayList<>();
	protected static List<Item> skilling4 = new ArrayList<>();
	protected static List<Item> skilling5 = new ArrayList<>();
	
	protected static List<Item> construction = new ArrayList<>();
	protected static List<Item> summoning = new ArrayList<>();
	protected static List<Item> customitems = new ArrayList<>();
	protected static List<Item> potionmember1 = new ArrayList<>();
	protected static List<Item> potionmember2 = new ArrayList<>();
	protected static List<Item> slayer = new ArrayList<>();
	protected static List<Item> accessories = new ArrayList<>();
	protected static List<Item> avalonpts = new ArrayList<>();
	protected static List<Item> pkpts = new ArrayList<>();
	protected static List<Item> ruby = new ArrayList<>();

	public static void init() {
		resetShops();
		
		//Armours
			ruby.add(new Item(24855 , 15));
			ruby.add(new Item(24857 , 50));
			ruby.add(new Item(24859 , 100));
			ruby.add(new Item(24861 , 200));
			
			//torva
			ruby.add(new Item(20135, 50));
			ruby.add(new Item(20139, 50));
			ruby.add(new Item(20143, 50));
			
			//pernix
			ruby.add(new Item(20147, 50));
			ruby.add(new Item(20151, 50));
			ruby.add(new Item(20155, 50));
			
			//virtus
			ruby.add(new Item(20159, 50));
			ruby.add(new Item(20163, 50));
			ruby.add(new Item(20167, 50));
			
			ruby.add(new Item(13738,350));
			ruby.add(new Item(13740,400));
			ruby.add(new Item(13742,350));
			
			//void
			//helm
			ruby.add(new Item(11663, 7)); 
			ruby.add(new Item(11664, 7));
			ruby.add(new Item(11665, 7));
			
			ruby.add(new Item(8842, 2));
			ruby.add(new Item(8839, 5));
			ruby.add(new Item(8840, 5));
			ruby.add(new Item(19712, 7));
			
			//elite
			ruby.add(new Item(19785, 10));
			ruby.add(new Item(19786, 10));
			
			
			
			/*
			ruby.add(new Item(22358, 10));
			ruby.add(new Item(22359, 10));
			ruby.add(new Item(22360, 10));
			ruby.add(new Item(22361, 10));*/
		
		//Weapons
		ruby.add(new Item("Dragon claws", 35));
		ruby.add(new Item(19784, 35));
		ruby.add(new Item(11694, 35));
		ruby.add(new Item(11696, 25));
		ruby.add(new Item(11698, 25));
		
		//phats
		ruby.add(new Item("Blue partyhat", 200));
		ruby.add(new Item("Red partyhat", 170));
		ruby.add(new Item("White partyhat", 170));
		ruby.add(new Item("Green partyhat", 130));
		ruby.add(new Item("Yellow partyhat", 130));
		ruby.add(new Item("Purple partyhat", 120));
		
		//Hween 
		ruby.add(new Item(1053, 70)); //hween green
		ruby.add(new Item(1055, 70)); //hween red
		ruby.add(new Item(1057, 70)); //hween red
		
		//santa
		ruby.add(new Item(1050, 75));
		
		
		ruby.add(new Item("Fire Cape", 15));
		ruby.add(new Item(23659, 30));
		
		//aura
		ruby.add(new Item(22298, 15)); // vampyrism
		ruby.add(new Item(22897, 15)); // berserk
		ruby.add(new Item(22302, 50)); //winsdom double xp
		
		ruby.add(new Item(6199, 5));
		ruby.add(new Item(2572, 50));
		ruby.add(new Item(24497, 25));
		
		ruby.add(new Item(22532, 10));
		ruby.add(new Item(22538, 10));
		ruby.add(new Item(22544, 10));
		ruby.add(new Item(22550, 10));
		
		avalonpts.add(new Item(7462, 10000));
		avalonpts.add(new Item(775, 5000));
		avalonpts.add(new Item("fighter torso", 150000));
		avalonpts.add(new Item("fighter hat", 250000));
		avalonpts.add(new Item("ganodermic visor", 500000));
		avalonpts.add(new Item("ganodermic poncho", 1000000));
		avalonpts.add(new Item("ganodermic leggings", 1000000));
		avalonpts.add(new Item("polypore staff", 750000));
		avalonpts.add(new Item("greater runic staff", 1000000));
		avalonpts.add(new Item(14632, 300000));
		avalonpts.add(new Item(4151, 200000));
		avalonpts.add(new Item(6571, 350000));
		avalonpts.add(new Item(19333, 350000));
		avalonpts.add(new Item(405, 150000));
		

		accessories.add(new Item("ring of recoil"));
		accessories.add(new Item("ring of duelling (8)"));
		accessories.add(new Item("ring of life"));
		accessories.add(new Item("amulet of power"));
		accessories.add(new Item("amulet of strength"));
		accessories.add(new Item("amulet of glory (4)"));
		accessories.add(new Item("games necklace (8)"));
		accessories.add(new Item(7458));
		accessories.add(new Item(7459));
		accessories.add(new Item(7460));
		accessories.add(new Item(7461));
		accessories.add(new Item(3842));
		accessories.add(new Item(22424));
		accessories.add(new Item(15707));
		
		
		
		melee.add(new Item(4153));
		melee.add(new Item(5698));
		melee.add(new Item(5698));
		
		melee.add(new Item(1067));
		melee.add(new Item(1101));// Iron chainbody
		melee.add(new Item(1115));// Iron platebody
		melee.add(new Item(1153));// Iron full helm
		melee.add(new Item(1191));// Iron kiteshield
		melee.add(new Item(1323));// Iron scimitar
		melee.add(new Item(1069));// Steel dart
		melee.add(new Item(1105));
		melee.add(new Item(1119));
		melee.add(new Item(1157));
		melee.add(new Item(1193));
		
		melee.add(new Item(1077));
		melee.add(new Item(1089));
		melee.add(new Item(1125));
		melee.add(new Item(1165));
		melee.add(new Item(1195));
		melee.add(new Item(1327));
		melee.add(new Item(2491));
		melee.add(new Item(2497));
		melee.add(new Item(2503));
		melee.add(new Item(2583));
		melee.add(new Item(2585));
		melee.add(new Item(2587));
		melee.add(new Item(2589));
		melee.add(new Item(2591));
		melee.add(new Item(2593));
		melee.add(new Item(2595));
		melee.add(new Item(2597));
		melee.add(new Item(6615));
		melee.add(new Item(6617));
		melee.add(new Item(6623));
		melee.add(new Item(6625));
		melee.add(new Item(6627));
		melee.add(new Item(6629));
		melee.add(new Item(6633));
		melee.add(new Item(1071));
		melee.add(new Item(1121));
		melee.add(new Item(1159));
		melee.add(new Item(1197));
		melee.add(new Item(1329));
		
		
		
		melee.add(new Item(1073));
		melee.add(new Item(1123));
		melee.add(new Item(1161));
		melee.add(new Item(1199));
		melee.add(new Item(2607));
		melee.add(new Item(2609));
		melee.add(new Item(2611));
		melee.add(new Item(2613));
		melee.add(new Item(1215));
		melee.add(new Item(1249));
		melee.add(new Item(1305));
		melee.add(new Item(1434));
		melee.add(new Item(4087));
		melee.add(new Item(4587));
		melee.add(new Item(11732));
		melee.add(new Item(9672));
		melee.add(new Item(9674));
		melee.add(new Item(9676));
		melee.add(new Item(9678));
		
		melee.add(new Item(1331));
		melee.add(new Item(1127));
		melee.add(new Item(1079));
		
		melee.add(new Item(1201));
		melee.add(new Item(1333));
		melee.add(new Item(4131));
		melee.add(new Item(1149));
		melee.add(new Item(1187));

		magic.add(new Item("saradomin staff"));
		magic.add(new Item("zamorak staff"));
		magic.add(new Item("guthix staff"));
		magic.add(new Item(15486));
		magic.add(new Item(6914));
		magic.add(new Item(6889));
		magic.add(new Item(10149));
		magic.add(new Item(10146));
		magic.add(new Item(10147));
		magic.add(new Item(10148));
		
		
		magic.add(new Item("ghostly hood"));
		magic.add(new Item("enchanted hat"));
		magic.add(new Item("ghostly robe"));
		magic.add(new Item("ghostly robe¤1"));
		magic.add(new Item(4089));
		magic.add(new Item(4091));
		magic.add(new Item(4093));
		magic.add(new Item(4095));
		magic.add(new Item(7400));
		magic.add(new Item(7399));
		magic.add(new Item(7398));
		
		magic.add(new Item(1027));
		magic.add(new Item(2579));
		magic.add(new Item(4675));
		
		magic.add(new Item(1381));
		magic.add(new Item(1383));
		magic.add(new Item(1385));
		magic.add(new Item(1387));
		magic.add(new Item(1393));
		magic.add(new Item(1395));
		magic.add(new Item(1397));
		magic.add(new Item(1399));
		magic.add(new Item(1401));
		magic.add(new Item(1403));
		magic.add(new Item(1405));
		magic.add(new Item(1407));
		
		magic.add(new Item(554));
		magic.add(new Item(555));
		magic.add(new Item(556));
		magic.add(new Item(557));
		magic.add(new Item(558));
		magic.add(new Item(559));
		magic.add(new Item(560));
		magic.add(new Item(561));
		magic.add(new Item(562));
		magic.add(new Item(563));
		magic.add(new Item(564));
		magic.add(new Item(565));
		magic.add(new Item(566));
		magic.add(new Item(9075));
		
		
		//bow
		range.add(new Item(841));
		range.add(new Item(843));
		range.add(new Item(849));
		range.add(new Item(853));
		range.add(new Item(857));
		range.add(new Item(861));
		range.add(new Item(837));
		range.add(new Item(9174));
		range.add(new Item(9177));
		range.add(new Item(9179));
		range.add(new Item(9181));
		range.add(new Item(9183));
		range.add(new Item(9185));
			
		
		
		range.add(new Item(10034));
		range.add(new Item(807));
		range.add(new Item(865));
		range.add(new Item(886));
		range.add(new Item(3093));
		range.add(new Item(809));
		range.add(new Item(866));
		range.add(new Item(888));
		range.add(new Item(9143));
		range.add(new Item(811));
		range.add(new Item(868));
		range.add(new Item(892));
		range.add(new Item(9244));
		range.add(new Item(9341));
		range.add(new Item(11230));
		range.add(new Item(869));
		range.add(new Item(867));
		range.add(new Item(890));
		range.add(new Item(810));
		
		
		
		range.add(new Item(1167));
		range.add(new Item(1129));
		range.add(new Item(1095));
		range.add(new Item(1063));
		range.add(new Item(1061));
		range.add(new Item(6328));
		range.add(new Item(1065));
		range.add(new Item(1135));
		range.add(new Item(1099));
		range.add(new Item(2487));
		range.add(new Item(2493));
		range.add(new Item(2499));
		
		range.add(new Item(2489));
		range.add(new Item(2495));
		range.add(new Item(2501));
		range.add(new Item(2491));
		range.add(new Item(2497));
		range.add(new Item(2503));
		
		range.add(new Item("ava's accumulator"));
		range.add(new Item(20068));
		range.add(new Item(19445));
		range.add(new Item(19447));
		range.add(new Item(10386));
		range.add(new Item(10388));
		
		
		

		
		supplies.add(new Item("teleport to house"));
		supplies.add(new Item("lumber yard teleport"));
		supplies.add(new Item(8015));// bones to peaches
		supplies.add(new Item("trout"));
		supplies.add(new Item("lobster"));
		supplies.add(new Item("swordfish"));
		supplies.add(new Item(7946));
		supplies.add(new Item(391));
		supplies.add(new Item(385));
		supplies.add(new Item(10476));// purple sweet
		supplies.add(new Item(2436));
		supplies.add(new Item(2440));
		supplies.add(new Item(2442));
		supplies.add(new Item(2434));
		supplies.add(new Item(2444));
		supplies.add(new Item(3040));
		supplies.add(new Item(2452));
		supplies.add(new Item("potion flask"));
		
		supplies.add(new Item(12790));//titan
		supplies.add(new Item(12825));//
		
		supplies.add(new Item(12093));//yak
		supplies.add(new Item(12435));//
		
		supplies.add(new Item(12089));//wolp
		supplies.add(new Item(12437));//
		
		supplies.add(new Item(12039));//unico
		supplies.add(new Item(12434));//

		skilling.add(new Item("hammer"));
		skilling.add(new Item(590));
		skilling.add(new Item("chisel"));
		skilling.add(new Item("knife"));
		skilling.add(new Item("saw"));
		skilling.add(new Item("pestle and mortar"));
		skilling.add(new Item("shears"));
		skilling.add(new Item("small fishing net"));
		skilling.add(new Item("big fishing net"));
		skilling.add(new Item("fly fishing rod"));
		skilling.add(new Item("feather"));
		skilling.add(new Item("fishing rod"));
		skilling.add(new Item("fishing bait"));
		skilling.add(new Item("harpoon"));
		skilling.add(new Item("lobster pot"));
		skilling.add(new Item("needle"));
		skilling.add(new Item("thread"));
		skilling.add(new Item("amulet mould"));
		skilling.add(new Item("bracelet mould"));
		skilling.add(new Item("necklace mould"));
		skilling.add(new Item("ring mould"));
		skilling.add(new Item("tiara mould"));
		skilling.add(new Item("ammo mould"));
		skilling.add(new Item("rake"));
		skilling.add(new Item("seed dibber"));
		skilling.add(new Item("spade"));
		skilling.add(new Item("gardening trowel"));
		skilling.add(new Item("secateurs"));
		skilling.add(new Item(1273));
		
		skilling.add(new Item(11260));
		skilling.add(new Item(11259));

		skilling.add(new Item("iron pickaxe"));
		skilling.add(new Item("iron hatchet"));
		skilling.add(new Item(1272));
		skilling.add(new Item("rune pickaxe"));
		skilling.add(new Item("rune hatchet"));
		skilling.add(new Item(1523));
		skilling.add(new Item(983));
		skilling.add(new Item(1269));

		skilling2.add(new Item("eye of newt"));
		skilling2.add(new Item("unicorn horn"));
		skilling2.add(new Item("limpwurt root"));
		skilling2.add(new Item("red spiders' eggs"));
		skilling2.add(new Item("white berries"));
		skilling2.add(new Item("desert goat horn"));
		skilling2.add(new Item("snape grass"));
		skilling2.add(new Item("wine of zamorak"));
		skilling2.add(new Item("potato cactus"));
		skilling2.add(new Item("crushed nest"));
		skilling2.add(new Item("papaya fruit"));
		skilling2.add(new Item("phoenix feather"));
		skilling2.add(new Item("grenwall spikes"));
		skilling2.add(new Item("ground mud runes"));
		skilling2.add(new Item("morchella mushroom"));
		skilling2.add(new Item(6810));
		skilling2.add(new Item("air talisman"));
		skilling2.add(new Item("mind talisman"));
		skilling2.add(new Item("water talisman"));
		skilling2.add(new Item("earth talisman"));
		skilling2.add(new Item("fire talisman"));
		skilling2.add(new Item("body talisman"));
		skilling2.add(new Item("cosmic talisman"));
		skilling2.add(new Item("chaos talisman"));
		skilling2.add(new Item("astral tiara"));
		skilling2.add(new Item("nature talisman"));
		skilling2.add(new Item("law talisman"));
		skilling2.add(new Item("death talisman"));
		skilling2.add(new Item("blood talisman"));
		skilling2.add(new Item(532));
		skilling2.add(new Item(571));
		skilling2.add(new Item(237));
		skilling2.add(new Item(7939));
		
		//food
		skilling2.add(new Item(335));//trout
		skilling2.add(new Item(331));//salmon
		skilling2.add(new Item(377));//lobster
		skilling2.add(new Item(371));//swordfish
		skilling2.add(new Item(7944));//monk
		skilling2.add(new Item(383));//shark
		skilling2.add(new Item(15270));//rocktail
		
		//ore
		skilling2.add(new Item(436));//copper
		skilling2.add(new Item(438));//tin
		skilling2.add(new Item(440));//iron
		skilling2.add(new Item(442));//silver
		skilling2.add(new Item(453));//coal
		skilling2.add(new Item(444));//gold
		skilling2.add(new Item(447));//mithril
		skilling2.add(new Item(449));//adamantite
		skilling2.add(new Item(451));//runite
		
		//bar
		skilling2.add(new Item(2361)); //adamant bar
		skilling2.add(new Item(2363)); //runite bar
		
		//logs
		skilling2.add(new Item(1511));//logs
		skilling2.add(new Item(1521));//oak logs
		skilling2.add(new Item(1519));//willow
		skilling2.add(new Item(6333));//teak
		skilling2.add(new Item(1517));//maple
		skilling2.add(new Item(6332));//mahogany
		skilling2.add(new Item(1515));//yew
		
		//plank
		skilling2.add(new Item(8780));
		skilling2.add(new Item(8782));//mahogany
		
		//craft
		skilling2.add(new Item(1625));
		skilling2.add(new Item(1627));
		skilling2.add(new Item(1629));
		skilling2.add(new Item(1631));
		
		/*
		 * FARMING
		 * */
		skilling3.add(new Item(5354));
		skilling3.add(new Item(5318));//potato
		skilling3.add(new Item(5319));//onion
		skilling3.add(new Item(5324));//cabbage
		skilling3.add(new Item(5320));//sweetcorn
		skilling3.add(new Item(5323));//strawberry
		skilling3.add(new Item(5321));//watermelon
		
		//flower
		skilling3.add(new Item(5096));//marigold
		skilling3.add(new Item(5097));//rosemary
		skilling3.add(new Item(5098));//nasturtium
		skilling3.add(new Item(5099));//woad
		skilling3.add(new Item(5100));//limpwurt
		skilling3.add(new Item(14589));//lily seed
		
		//herb
		skilling3.add(new Item(5291));//guam
		skilling3.add(new Item(5292)); //marrentil
		skilling3.add(new Item(5293));//tarromin
		skilling3.add(new Item(5294));//harralander
		skilling3.add(new Item(5295));//rannar
		skilling3.add(new Item(5296));//toadflax
		skilling3.add(new Item(5297));//irit
		skilling3.add(new Item(5298));//avantoe
		skilling3.add(new Item(5299));//kwuarm
		skilling3.add(new Item(5300));//snapdragon
		skilling3.add(new Item(5301));//cadantine
		skilling3.add(new Item(5302));//lantadyme
		skilling3.add(new Item(5303));//dwarf
		skilling3.add(new Item(5304));//torstol
		skilling3.add(new Item(21621));//fellstak
		
		//FRUIT TREES
		skilling3.add(new Item(5283));// apple
		skilling3.add(new Item(5284));//banana
		skilling3.add(new Item(5285));//orange
		skilling3.add(new Item(5286));//curry
		skilling3.add(new Item(5287));//pineapple
		skilling3.add(new Item(5288));//papaya
		skilling3.add(new Item(5289));//palm
		
		//TREE
		skilling3.add(new Item(5370));//oak
		skilling3.add(new Item(5313));//willow
		skilling3.add(new Item(5314));//maple
		skilling3.add(new Item(5315));//yew
		skilling3.add(new Item(5316));//magic
		
		
		

		summoning.add(new Item("spirit shard pack"));
		summoning.add(new Item("spirit shards"));
		summoning.add(new Item("pouch"));
		summoning.add(new Item("wolf bones"));
		summoning.add(new Item("raw chicken"));
		summoning.add(new Item("spider carcass"));
		summoning.add(new Item("thin snail"));
		summoning.add(new Item("iron ore"));
		summoning.add(new Item("bronze claws"));
		summoning.add(new Item("potato cactus"));
		summoning.add(new Item("vampyre dust"));
		summoning.add(new Item("willow logs"));
		summoning.add(new Item("carved evil turnip"));
		summoning.add(new Item("iron bar"));
		summoning.add(new Item("raw beef"));
		summoning.add(new Item("raw bird meat"));
		summoning.add(new Item("snake hide"));
		summoning.add(new Item("tortoise shell"));
		summoning.add(new Item("banana"));
		summoning.add(new Item("pot of flour"));
		summoning.add(new Item("water orb"));
		summoning.add(new Item("dagannoth hide"));
		summoning.add(new Item("swamp lizard"));
		summoning.add(new Item("unicorn horn"));
		summoning.add(new Item("raw rabbit"));
		summoning.add(new Item("iron platebody"));
		summoning.add(new Item("yak-hide"));
		summoning.add(new Item("steel platebody"));
		
		customitems.add(new Item(15426));
		
		potionmember1.add(new Item(23243));
		potionmember1.add(new Item(23219));
		potionmember1.add(new Item(23351));
		potionmember1.add(new Item(23255));
		potionmember1.add(new Item(23279));
		potionmember1.add(new Item(23291));
		potionmember1.add(new Item(23303));
		potionmember1.add(new Item(23423));
		
		potionmember2.add(new Item(23531));
		potionmember2.add(new Item(23609));
		potionmember2.add(new Item(23621));
		

		construction.add(new Item("steel nails"));
		construction.add(new Item("bolt of cloth"));
		construction.add(new Item("limestone brick"));
		construction.add(new Item("marble block"));
		construction.add(new Item(8784));
		
		for (int i = 4708; i < 4740; i += 2)
			barrows.add(new Item(i, 1));
		for (int i = 4745; i < 4760; i += 2)
			barrows.add(new Item(i, 1));
		for (int i = 21736; i < 21761; i += 8)
			barrows.add(new Item(i, 1));
	}

	protected List<Item> general = new ArrayList<>();
	protected static List<Item> extraStock = new ArrayList<>();

	protected static void resetShops() {
		magic.clear();
		melee.clear();
		range.clear();
		supplies.clear();
		barrows.clear();
		skilling.clear();
		skilling2.clear();
		construction.clear();
		summoning.clear();
		customitems.clear();
		potionmember1.clear();
		potionmember2.clear();
		accessories.clear();
	}

	protected List<Item> getItems(int type, int shop) {
		switch (shop) {
		case MAGIC_SHOP:
			return magic;
		case MELEE_SHOP:
			return melee;
		case RANGE_SHOP:
			return range;
		case SUPPLY_SHOP:
			return supplies;
		case GENERAL_STORE:
			return general;
		case BARROWS_SHOP:
			return barrows;
		case SKILLING_SHOP:
			return skilling;
		case SKILLING_SHOP_2:
			return skilling2;
		case SKILLING_SHOP_3:
			return skilling3;
		case SKILLING_SHOP_4:
			return skilling4;
		case SKILLING_SHOP_5:
			return skilling5;
		case CONSTRUCTION:
			return construction;
		case SUMMONING:
			return summoning;
		case CUSTOMITEMS:
			return customitems;
		case POTION_MEMBER_1:
			return potionmember1;
		case POTION_MEMBER_2:
			return potionmember2;
		case ACCESSORIES:
			return accessories;
		case AVALON_POINTS:
			return avalonpts;
		case PK_POINTS:
			return pkpts;
		case RUBY:
			return ruby;
		}
		return null;
	}

	protected int[][] getShopType(int type) {
		return type == 1 ? PKPointsData.ITEMS : AvalonPointsData.ITEMS ;
	}

	protected String getShopTitle(int type) {
		return type == 0 ? CoinStoreData.TITLE
				: type == 1 ? PKPointsData.TITLE : type == 2 ? AvalonPointsData.TITLE : SkillcapeStore.TITLE;
	}

	protected String getShopTitle(int type, int shop) {
		if (type == 0) {
			switch (shop) {
				case MAGIC_SHOP:
					return "Magic store";
				case MELEE_SHOP:
					return "Melee store";
				case RANGE_SHOP:
					return "Range store";
				case SUPPLY_SHOP:
					return "Supplies store";
				case GENERAL_STORE:
					return "General store";
				case BARROWS_SHOP:
					return "Barrows store";
				case SKILLING_SHOP:
					return "Skilling store";
				case SKILLING_SHOP_2:
					return "Skilling store 2";
				case SKILLING_SHOP_3:
					return "Skilling store 3";
				case SKILLING_SHOP_4:
					return "Skilling store 3";
				case SKILLING_SHOP_5:
					return "Skilling store 3";
				case CONSTRUCTION:
					return "Construction store";
				case SUMMONING:
					return "Summoning store";
				case CUSTOMITEMS:
					return "Event items";
				case POTION_MEMBER_1:
				case POTION_MEMBER_2:
					return "Potion";
				case ACCESSORIES:
					return "Accessories store";
				case AVALON_POINTS:
					return "Ressurge Point store";
				case RUBY:
					return "Ruby store";
				case PK_POINTS:
					return "Pk Point store";
			}
		}
		return type == 0 ? CoinStoreData.TITLE
				: type == 1 ? PKPointsData.TITLE : type == 2 ? AvalonPointsData.TITLE : SkillcapeStore.TITLE;
	}

	protected int getCurrencySprite(int type, int shop) {
		return shop == PK_POINTS ? PKPointsData.CURRENCY_SPRITE : shop == RUBY ? RubyPointsData.CURRENCY_SPRITE
				: shop == AVALON_POINTS ? AvalonPointsData.CURRENCY_SPRITE : CoinStoreData.CURRENCY_SPRITE;
	}

	protected String getPointsName(int type, int shop) {
		return shop == PK_POINTS ? "Pk Points" : shop == RUBY ? "Ruby points" :shop == AVALON_POINTS ? Settings.SERVER_NAME + " Points" : "Coins";
	}

	protected void removeCurrency(Player player, int shop, int amount) {
		switch (shop) {
		case PK_POINTS:
			player.setPKP(player.getPKP() - amount);
			break;
		case AVALON_POINTS:
			player.setRessurgePoints(player.getRessurgePoints() - amount);
			break;
		case RUBY:
			player.setRubyPoints(player.getRubyPoints() - amount);
		default:
			player.canBuy(amount);
			break;
		}
	}

}
