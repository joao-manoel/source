package com.rs.game.player.controlers.varrockmuseum;

import com.rs.game.Animation;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.player.Player;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;

public class Addstatue {

    private static int AddROCK = 12835;
    
    public static boolean FinishedStatue(WorldObject object) {
	return object.getId() == 48642 && object.getX() == 3254 && object.getY() == 3445 && object.getPlane() == 0;
    }
    
    public static boolean resetStatue(Player player, WorldObject object) {
	return object.getId() == 48627 && object.getX() == 3254 && object.getY() == 3445 && object.getPlane() == 0;
    }
    
    
    public static void Addstage1(final Player player,
            WorldObject object) {
	
	 if (!player.getInventory().containsItem(15522 , 1)) {
	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock in order to build the Dahmaroc statue."
	    		+ " Obtain more information from Marius Giste, the Archeologist.");
	    return;
	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48628);
	   World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the first stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
   
    
    public static void Addstage2(final Player player,
            WorldObject object) {
	
   	 if (!player.getInventory().containsItem(15522 , 1))  {
	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
		    	+ " Learn more about these rocks by talking to Marius Giste.");
	    return;
	 
	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48629);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the second stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    
    
    public static void Addstage3(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48630);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the third stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    
    public static void Addstage4(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48631);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the fourth' stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    
    public static void Addstage5(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48632);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the fifth' stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    public static void Addstage6(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48633);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the six'th stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    public static void Addstage7(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48634);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the seven'th stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    public static void Addstage8(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48635);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the eight'th stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    public static void Addstage9(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48636);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the ninth stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    public static void Addstage10(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48637);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the ten'th stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    
    public static void Addstage11(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48638);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the eleventh stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    public static void Addstage12(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48639);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the twelfth stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    
    public static void Addstage13(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48640);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the thirtienth stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    
    public static void Addstage14(final Player player,
            WorldObject object) {
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48641);
	    World.spawnObject(o);
            player.getPackets().sendGameMessage(
                    "You add the before final stage to the statue of Dahmaroc...");
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
            stop();
        }
    }, 2);
}
    
    public static void FinalStage(final Player player,
            WorldObject object) {
		//boolean FinishedStatue = object.getId() == 48462 && object.getX() == 3254 && object.getY() == 3445 && object.getPlane() == 0;
   	 if (!player.getInventory().containsItem(15522 , 1)) {
    	    player.getDialogueManager().startDialogue("SimpleMessage", "You need a strange rock to help restoring the Statue of Dahmaroc."
    		    	+ " Learn more about these rocks by talking to Marius Giste.");
    	    return;
    	 
    	 }
    player.animate(new Animation(AddROCK));
    player.lock(5);
    WorldTasksManager.schedule(new WorldTask() {
		@Override
        public void run() {
	    WorldObject o = new WorldObject(object);
	    o.setId(48642);
	    World.spawnObjectTemporary(o, 3600000); //>timer starts when obj demolishes (1h to receive rewards)
            player.getPackets().sendGameMessage(
                    "You add the last stage to the statue of Dahmaroc...");
            World.sendWorldMessage("<img=7><col=cbc7f0>The Dahmaroc statue is completed!,</col> <col=edecfa>"+player.getDisplayName()+"</col><col=cbc7f0> contributed the final rock. ", false);
            World.sendWorldMessage("<col=cbc7f0>All players who contributed to the statue can receive their rewards from the Curator.", false);
            player.getInventory().deleteItem(15522, 1);
            player.ContributedtoStatue = true;
	        FinishedStatue(object);
            if (player.ContributedtoStatue == true && FinishedStatue(o) == true) {
            	player.CanReceive = true;
           }
         stop();
        }
    }, 2);
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
        	 WorldObject o = new WorldObject(object);
     	    o.setId(48627);
     	   World.spawnObject(o);
     	   World.sendWorldMessage("<col=a43737>The Dahmaroc statue was demolished, and returned to original state.", 
     			   false);
            player.ContributedtoStatue = false;
            player.CanReceive = false;
            stop();
        }
    }, 7200);
}
    
}
    
