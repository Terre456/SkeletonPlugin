package com.github.terre456;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.AbstractSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;;

public class SkeletonBehaviorListener implements Listener {
  private final int damagePerShot = 3;

  @EventHandler
  public void onSkeletonSpawn(EntityShootBowEvent event) {
    if (event.getEntity() instanceof AbstractSkeleton) {
      AbstractSkeleton skeleton = (AbstractSkeleton) event.getEntity();
      ItemStack bow = event.getBow();
      if (bow != null && bow.getType() == Material.BOW) {
        if (bow.getItemMeta() instanceof Damageable) {
          Damageable meta = (Damageable) bow.getItemMeta();
          meta.setDamage(meta.getDamage() + damagePerShot);
          if (meta.getDamage() >= Material.BOW.getMaxDurability()) {
            skeleton.getEquipment().setItemInMainHand(null);
            skeleton.getWorld().playSound(skeleton.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0f, 1.0f);
          } else {
            bow.setItemMeta(meta);
            skeleton.getEquipment().setItemInMainHand(bow);
          }
        }
      }
    }
  }
}
