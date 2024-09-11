package com.rs.game.npc.combat;

import com.rs.game.Animation;
import com.rs.game.Entity;
import com.rs.game.ForceTalk;
import com.rs.game.Graphics;
import com.rs.game.Hit;
import com.rs.game.Hit.HitLook;
import com.rs.game.World;
import com.rs.game.npc.NPC;
import com.rs.game.npc.familiar.Steeltitan;
import com.rs.game.player.CombatDefinitions;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.actions.combat.PlayerCombat;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.Utils;

public abstract class CombatScript {
	
	
	/*
	 * Returns ids and names
	 */
	public abstract Object[] getKeys();

	/*
	 * Returns Move Delay
	 */
	public abstract int attack(NPC npc, Entity target);

	public static void delayHit(NPC npc, int delay, final Entity target, final Hit... hits) {
		for (Hit hit : hits) {
			if (target instanceof Player) {
				Player p2 = (Player) target;
				p2.setAttackedBy(npc);
				p2.setAttackedByDelay(Utils.currentTimeMillis() + 5000);
			}
			handleProtectPrayers(npc, target, hit);
			handleAbsorb(target, hit);
			handleSOL(target, hit);
			handleDivine(target, hit);
			handleElysian(target, hit);
			if (npc.getId() == 13448)
				sendSoulSplit(hit, npc, target);
			if (npc.getId() == 2027) {
				if (hit.getDamage() != 0 && Utils.random(3) == 0) {
					target.gfx(new Graphics(398));
					npc.heal(hit.getDamage());
				}
			}
			if (npc.getId() == 6367) {
				if (hit.getLook() == HitLook.MAGIC_DAMAGE && hit.getDamage() > 0)
					target.addFreezeDelay(20000, false);
			}
		}
		WorldTasksManager.schedule(new WorldTask() {

			@Override
			public void run() {
				for (Hit hit : hits) {
					NPC npc = (NPC) hit.getSource();
					if (npc.isDead() || npc.hasFinished() || target.isDead() || target.hasFinished())
						return;
					if (target instanceof Player)
						npc.getCombat().addAttackedByDelay(target);
					target.applyHit(hit);
					handleRingOfRecoil(npc, target, hit);
					handleVengHit(target, hit);
					if (npc.getId() == 6367) {
						if (hit.getDamage() == 0)
							target.gfx(new Graphics(85, 0, 96));
						if (hit.getDamage() > 0 && target.getFreezeDelay() > Utils.currentTimeMillis())
							target.gfx(new Graphics(1677));
						if (hit.getDamage() > 0 && target.getFreezeDelay() < Utils.currentTimeMillis())
							target.gfx(new Graphics(369));
					}
					if (npc.getId() == 1007 && hit.getLook() == HitLook.MAGIC_DAMAGE) {
						if (hit.getDamage() == 0)
							target.gfx(new Graphics(85, 0, 96));
						if (hit.getDamage() > 0)
						target.gfx(new Graphics(78, 0, 0));
					}
					if (npc.getId() == 1264 && hit.getLook() == HitLook.MAGIC_DAMAGE) {
						if (hit.getDamage() == 0)
							target.gfx(new Graphics(85, 0, 96));
						if (hit.getDamage() > 0)
						target.gfx(new Graphics(76, 0, 0));
					}
					if (hit.getDamage() == 0) {
						if (npc.getId() == 9172)// aquanite splash
							target.gfx(new Graphics(2122));
					}
					npc.getCombat().doDefenceEmote(target);
					int damage = hit.getDamage() > target.getHitpoints() ? target.getHitpoints() : hit.getDamage();
					if ((damage >= npc.getCombatDefinitions().getMaxHit() * 0.90)
							&& (hit.getLook() == HitLook.RANGE_DAMAGE))
						hit.setCriticalMark();
					if ((damage >= npc.getCombatDefinitions().getMaxHit() * 0.90)
							&& (hit.getLook() == HitLook.MAGIC_DAMAGE))
						hit.setCriticalMark();
					if ((damage >= npc.getCombatDefinitions().getMaxHit() * 0.90)
							&& (hit.getLook() == HitLook.MELEE_DAMAGE))
						hit.setCriticalMark();
					if (target instanceof Player) {
						Player p2 = (Player) target;
						p2.closeInterfaces();
						if (p2.getCombatDefinitions().isAutoRelatie() && !p2.getActionManager().hasSkillWorking()
								&& !p2.hasWalkSteps())
							p2.getActionManager().setAction(new PlayerCombat(npc));
					} else {
						NPC n = (NPC) target;
						if (!n.isUnderCombat() || n.canBeAttackedByAutoRelatie())
							n.setTarget(npc);
					}

				}
			}

		}, delay);
	}

	public static void sendSoulSplit(final Hit hit, final NPC npc, final Entity target) {
		Player p2 = (Player) target;
		if (target instanceof Player) {
			World.sendSoulsplitProjectile(npc, target, 2263);
			if (npc.getHitpoints() > 0 && npc.getHitpoints() <= npc.getMaxHitpoints()) {
				npc.heal(hit.getDamage() / 5);
				p2.getPrayer().drainPrayer(hit.getDamage() / 5);
			}
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					target.gfx(new Graphics(2264));
					World.sendSoulsplitProjectile(target, npc, 2263);
				}
			}, 1);
		}
	}

	public static void handleRingOfRecoil(NPC npc, Entity target, Hit hit) {
		if (target instanceof NPC)
			return;
		int damage = (int) (hit.getDamage() * 0.1);
		if (target instanceof Player) {
			Player p2 = (Player) target;
			if (p2.getEquipment().getRingId() == 2550) {
				if (hit.getLook() == HitLook.MELEE_DAMAGE || hit.getLook() == HitLook.RANGE_DAMAGE
						|| hit.getLook() == HitLook.MAGIC_DAMAGE) {
					if (hit.getDamage() > 9) {
						if (p2.getRecoilHits() == 0) {
							npc.applyHit(new Hit(p2, damage > 60 ? 60 : damage, HitLook.REFLECTED_DAMAGE));
							p2.setRecoilHits(400);
							p2.setRecoilHits(p2.getRecoilHits() - damage);
							p2.getPackets().sendGameMessage("Your ring of recoil started degrading.");
						} else if (p2.getRecoilHits() >= damage) {
							npc.applyHit(new Hit(p2, damage > 60 ? 60 : damage, HitLook.REFLECTED_DAMAGE));
							p2.setRecoilHits(p2.getRecoilHits() - damage);
						} else if (p2.getRecoilHits() - damage <= 0) {
							p2.getEquipment().deleteItem(2550, 1);
							p2.getAppearence().generateAppearenceData();
							hit.getSource()
									.applyHit(new Hit(target, (int) (hit.getDamage() * 0.75), HitLook.REGULAR_DAMAGE));
							npc.applyHit(new Hit(p2, damage > 60 ? 60 : damage, HitLook.REFLECTED_DAMAGE));
							p2.setRecoilHits(400);
							p2.setRecoilHits(p2.getRecoilHits() - damage);
							p2.getPackets().sendGameMessage("Your ring of recoil has shattered.");
						}
					}
				}
			}
		}
	}

	private static void handleVengHit(Entity target, Hit hit) {
		if (target instanceof NPC) {
			return;
		}
		Player p2 = (Player) target;
		if (p2.castedVeng && hit.getDamage() >= 4) {
			p2.castedVeng = false;
			p2.setNextForceTalk(new ForceTalk("Taste vengeance!"));
			hit.getSource().applyHit(new Hit(target, (int) (hit.getDamage() * 0.75), HitLook.REGULAR_DAMAGE));
		}
	}

	public static void handleAbsorb(Entity target, Hit hit) {
		if (target instanceof NPC) {
			return;
		}
		Player p2 = (Player) target;
		if (hit.getLook() == HitLook.MELEE_DAMAGE) {
			int reducedDamage = (hit.getDamage() - 200)
					* p2.getCombatDefinitions().getBonuses()[CombatDefinitions.ABSORVE_MELEE_BONUS] / 100;
			if (hit.getDamage() - reducedDamage > 200 && p2.getHitpoints() > 200) {
				if (reducedDamage > 0) {
					hit.setDamage(hit.getDamage() - reducedDamage);
					hit.setSoaking(new Hit(target, reducedDamage, HitLook.ABSORB_DAMAGE));
				}
			}
		} else if (hit.getLook() == HitLook.RANGE_DAMAGE) {
			int reducedDamage = (hit.getDamage() - 200)
					* p2.getCombatDefinitions().getBonuses()[CombatDefinitions.ABSORVE_RANGE_BONUS] / 100;
			if (hit.getDamage() - reducedDamage > 200 && p2.getHitpoints() > 200) {
				if (reducedDamage > 0) {
					hit.setDamage(hit.getDamage() - reducedDamage);
					hit.setSoaking(new Hit(target, reducedDamage, HitLook.ABSORB_DAMAGE));
				}
			}
		} else if (hit.getLook() == HitLook.MAGIC_DAMAGE) {
			int reducedDamage = (hit.getDamage() - 200)
					* p2.getCombatDefinitions().getBonuses()[CombatDefinitions.ABSORVE_MAGE_BONUS] / 100;
			if (hit.getDamage() - reducedDamage > 200 && p2.getHitpoints() > 200) {
				if (reducedDamage > 0) {
					hit.setDamage(hit.getDamage() - reducedDamage);
					hit.setSoaking(new Hit(target, reducedDamage, HitLook.ABSORB_DAMAGE));
				}
			}
		}
	}

	public static void handleDivine(Entity target, Hit hit) {
		if (target instanceof NPC)
			return;
		if (target instanceof Player) {
			Player p2 = (Player) target;
			int shieldId = p2.getEquipment().getShieldId();
			if (shieldId == 13740) {
				int drain = (int) (Math.ceil(hit.getDamage() * 0.3) / 2);
				if (p2.getPrayer().getPrayerpoints() >= drain) {
					hit.setDamage((int) (hit.getDamage() * 0.70));
					p2.getPrayer().drainPrayer(drain);
				}
			}
		}
	}

	public static void handleElysian(Entity target, Hit hit) {
		if (target instanceof NPC)
			return;
		if (target instanceof Player) {
			Player p2 = (Player) target;
			int shieldId = p2.getEquipment().getShieldId();
			if (shieldId == 13742) {
				if (Utils.getRandom(10) <= 7)
					hit.setDamage((int) (hit.getDamage() * 0.75));
			}
		}
	}

	public static void handleSOL(Entity target, Hit hit) {
		if (target instanceof NPC)
			return;
		if (target instanceof Player) {
			Player p2 = (Player) target;
			if (hit.getLook() == HitLook.MELEE_DAMAGE) {
				int weaponId = p2.getEquipment().getWeaponId();
				if (p2.polDelay > Utils.currentTimeMillis()) {
					if (weaponId != 15486) {
						p2.setPolDelay(0);
					} else {
						p2.gfx(new Graphics(2320, 0, 100));
						hit.setDamage((int) (hit.getDamage() * 0.5));
					}
				}
			}
		}
	}

	public static void handleProtectPrayers(NPC npc, Entity target, Hit hit) {
		if (target instanceof NPC)
			return;
		Player p2 = (Player) target;
		if (p2.getPrayer().hasPrayersOn() && hit.getDamage() != 0) {
			int deflectedDamage = (int) (hit.getDamage() * 0.1);
			if (hit.getLook() == HitLook.MAGIC_DAMAGE) {
				if (p2.getPrayer().usingPrayer(0, 17))
					hit.setDamage((int) (hit.getDamage() * npc.getMagePrayerMultiplier()));
				else if (p2.getPrayer().usingPrayer(1, 7)) {
					if (Utils.getRandom(2) <= 1 && hit.getDamage() > 10) {
						npc.applyHit(new Hit(target, deflectedDamage, HitLook.REFLECTED_DAMAGE));
						p2.gfx(new Graphics(2228));
						p2.setNextAnimationNoPriority(new Animation(12573), p2);
					}
					hit.setDamage((int) (hit.getDamage() * npc.getMagePrayerMultiplier()));
				}
			}
			if (hit.getLook() == HitLook.RANGE_DAMAGE) {
				if (p2.getPrayer().usingPrayer(0, 18))
					hit.setDamage((int) (hit.getDamage() * npc.getRangePrayerMultiplier()));
				else if (p2.getPrayer().usingPrayer(1, 8)) {
					if (Utils.getRandom(2) <= 1 && hit.getDamage() > 10) {
						npc.applyHit(new Hit(target, deflectedDamage, HitLook.REFLECTED_DAMAGE));
						p2.gfx(new Graphics(2229));
						p2.setNextAnimationNoPriority(new Animation(12573), p2);
					}
					hit.setDamage((int) (hit.getDamage() * npc.getRangePrayerMultiplier()));
				}
			}
			if (hit.getLook() == HitLook.MELEE_DAMAGE) {
				if (p2.getPrayer().usingPrayer(0, 19))
					hit.setDamage((int) (hit.getDamage() * npc.getMeleePrayerMultiplier()));
				else if (p2.getPrayer().usingPrayer(1, 9)) {
					if (Utils.getRandom(2) <= 1 && hit.getDamage() > 10) {
						npc.applyHit(new Hit(target, deflectedDamage, HitLook.REFLECTED_DAMAGE));
						p2.gfx(new Graphics(2230));
						p2.setNextAnimationNoPriority(new Animation(12573), p2);
					}
					hit.setDamage((int) (hit.getDamage() * npc.getMeleePrayerMultiplier()));
				}
			}
		}
	}

	public static Hit getRangeHit(NPC npc, int damage) {
		return new Hit(npc, damage, HitLook.RANGE_DAMAGE);
	}

	public static Hit getMagicHit(NPC npc, int damage) {
		return new Hit(npc, damage, HitLook.MAGIC_DAMAGE);
	}

	public static Hit getRegularHit(NPC npc, int damage) {
		return new Hit(npc, damage, HitLook.REGULAR_DAMAGE);
	}

	public static Hit getMeleeHit(NPC npc, int damage) {
		return new Hit(npc, damage, HitLook.MELEE_DAMAGE);
	}

	public static int getRandomMaxHit(NPC npc, int maxHit, int attackStyle,
			Entity target) {
		int[] bonuses = npc.getBonuses();
		double att = bonuses == null ? 0
				: attackStyle == NPCCombatDefinitions.RANGE ? bonuses[CombatDefinitions.RANGE_ATTACK]
						: attackStyle == NPCCombatDefinitions.MAGE ? bonuses[CombatDefinitions.MAGIC_ATTACK]
								: bonuses[CombatDefinitions.STAB_ATTACK];
		double def;
		if (target instanceof Player) {
			Player p2 = (Player) target;
			def = p2.getSkills().getLevel(Skills.DEFENCE)
					+ (2
					* p2.getCombatDefinitions().getBonuses()[attackStyle == NPCCombatDefinitions.RANGE ? CombatDefinitions.RANGE_DEF
							: attackStyle == NPCCombatDefinitions.MAGE ? CombatDefinitions.MAGIC_DEF
									: CombatDefinitions.STAB_DEF]);
			def *= p2.getPrayer().getDefenceMultiplier();
			if (attackStyle == NPCCombatDefinitions.MELEE) {
				if (p2.getFamiliar() instanceof Steeltitan)
					def *= 1.15;
			}
		} else {
			NPC n = (NPC) target;
			def = n.getBonuses() == null ? 0
					: n.getBonuses()[attackStyle == NPCCombatDefinitions.RANGE ? CombatDefinitions.RANGE_DEF
							: attackStyle == NPCCombatDefinitions.MAGE ? CombatDefinitions.MAGIC_DEF
									: CombatDefinitions.STAB_DEF];
			def *= 2;
		}
		double prob = att / def;
		if (prob > 0.90) // max, 90% prob hit so even lvl 138 can miss at lvl 3
			prob = 0.90;
		else if (prob < 0.05) // minimun 5% so even lvl 3 can hit lvl 138
			prob = 0.05;
		if (prob < Math.random())
			return 0;
		return Utils.getRandom(maxHit);
	}

}
