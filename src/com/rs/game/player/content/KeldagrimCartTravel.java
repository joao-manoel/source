package com.rs.game.player.content;

import com.rs.cores.CoresManager;
import com.rs.game.Animation;
import com.rs.game.ForceMovement;
import com.rs.game.WorldTile;
import com.rs.game.player.Player;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.Logger;

public class KeldagrimCartTravel {
	
	public static void Start(Player player) {
		player.lock(5);
		final long time = FadingScreen.fade(player);
		CoresManager.slowExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					FadingScreen.unfade(player, time, new Runnable() {
						@Override
						public void run() {
							player.setNextWorldTile(new WorldTile(2945, 10170, 0));
							Travel(player);
						}
					});
				} catch (Throwable e) {
					Logger.handle(e);
				}
			}
		});
	}
	
	public static void Travel(Player player) {
		player.animate(new Animation(2148));
		
		WorldTasksManager.schedule(new WorldTask() {
			int x;
			
			@Override
			public void run() {
				if (x++ == 19) {
					player.animate(new Animation(-1));
					player.setNextWorldTile(new WorldTile(2909, 10174, 0,
							player.getPlane()));
					stop();
					return;
				}
				if(x == 1) {
					final WorldTile toTile = new WorldTile(2943, 10170, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 2) {
					final WorldTile toTile = new WorldTile(2941, 10170, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 3) {
					final WorldTile toTile = new WorldTile(2940, 10172, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.NORTH);
				}
				if(x == 4) {
					final WorldTile toTile = new WorldTile(2938, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 5) {
					final WorldTile toTile = new WorldTile(2936, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 6) {
					final WorldTile toTile = new WorldTile(2934, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 7) {
					final WorldTile toTile = new WorldTile(2932, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 8) {
					final WorldTile toTile = new WorldTile(2930, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 9) {
					final WorldTile toTile = new WorldTile(2928, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 10) {
					final WorldTile toTile = new WorldTile(2926, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 11) {
					final WorldTile toTile = new WorldTile(2924, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 12) {
					final WorldTile toTile = new WorldTile(2922, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 13) {
					final WorldTile toTile = new WorldTile(2920, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 14) {
					final WorldTile toTile = new WorldTile(2918, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 15) {
					final WorldTile toTile = new WorldTile(2916, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 16) {
					final WorldTile toTile = new WorldTile(2914, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 17) {
					final WorldTile toTile = new WorldTile(2912, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
				if(x == 18) {
					final WorldTile toTile = new WorldTile(2909, 10173, 0,
							player.getPlane());
					RunCart(player, toTile, ForceMovement.WEST);
				}
			}
			
		}, 1, 1);
	}
	
	public static void RunCart(Player player, WorldTile toTile, int Direct) {
		player.setNextForceMovement(new ForceMovement(toTile, 1,
				Direct));
		WorldTasksManager.schedule(new WorldTask() {

			@Override
			public void run() {
				player.setNextWorldTile(toTile);
			}
		}, 0);
	}
}
