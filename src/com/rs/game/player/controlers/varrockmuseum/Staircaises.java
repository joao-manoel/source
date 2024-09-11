package com.rs.game.player.controlers.varrockmuseum;

import com.rs.game.Animation;
import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.player.Player;
import com.rs.game.player.content.FadingScreen;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;

public class Staircaises {
	
	/**
	 * Handles Animations
	 */
	static int RAPIDTAKE = 11665;
	static int CLIMB = 828;
	static int CDOWN = 827;
	static int PICKLOCK = 881;
	static int LOOK = 9069;
	static int FORCEPULL = 9497;
	static int FALLS = 3094;
	static int OPENCHEST = 536;
	static int TAKEFROMSHELF = 1649;
	static int STATICSTARE = 6383;
	static int THINK = 857;
	static int PRAY = 645;
	static int KNOCK = 9105;
	static int TAKE = 7270;
	static int TAKE2 = 2282;
	static int SEARCH = 9086;
	
	
	 public static void BlueMoonInnReturn(Player player, final WorldObject object) {
		final WorldTile toTile = new WorldTile(3226, 3393, 0);
		player.animate(new Animation(CDOWN));	
		player.getPackets().sendGameMessage("You climb down the staircaise...");
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.setNextWorldTile(toTile);
				player.unlock();
			}
		}, 2);
	}
	 
	 public static void VarrockMuseumDown(Player player, final WorldObject object) {
		if (object.getX() == 3266 && object.getY() == 3453) { //Varrock Museum (staircaise)
		final WorldTile toTile = new WorldTile(3266, 3451, 0);
		player.animate(new Animation(CDOWN));	
		player.getPackets().sendGameMessage("You climb down the staircaise...");
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.setNextWorldTile(toTile);
				player.unlock();
			}
		}, 2);
	}
 }
	 public static void VarrockMuseumUp(Player player, final WorldObject object) {
		final long time = FadingScreen.fade(player);
		 final WorldTile toTile = new WorldTile(3266, 3455, 1);
		 FadingScreen.unfade(player, time, new Runnable() {
				@Override
				public void run() {
					
				}
			});
			player.animate(new Animation(CLIMB));
			player.getPackets().sendGameMessage("You climb up the ladder...");
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.setNextWorldTile(toTile);
					player.unlock();
				}
			}, 2);

	 }
	 
	        public static void SharedStaircaise(Player player, final WorldObject object) {
	    	if (object.getX() == 3230 && object.getY() == 3383) { //Varrock Cooking house > south
			final WorldTile toTile = new WorldTile(3230, 3382, 1);
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.setNextWorldTile(toTile);
					player.unlock();	
		         }	
			}, 1);
			return;
	    }
	    	
			if (object.getX() == 3253 && object.getY() == 3443 && object.getPlane() == 1) { //Varrock Museum (staircaise)
				final WorldTile toTile = new WorldTile(3254, 3446, 2);
			player.animate(new Animation(CLIMB));	
			player.getPackets().sendGameMessage("You climb up the staircaise...");
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					player.setNextWorldTile(toTile);
					player.unlock();
				}
			}, 1);
			return;
	    }
	  }
		
	 
	 public static void TavernCellarToSurface(Player player, final WorldObject object) {
	 final WorldTile toTile = new WorldTile(3230, 3401, 0);
		player.animate(new Animation(CLIMB));
		player.getPackets().sendGameMessage("You climb up the ladder...");
		WorldTasksManager.schedule(new WorldTask() {
			@Override
			public void run() {
				player.setNextWorldTile(toTile);
				player.unlock();
			}
		}, 1);
	}

}
