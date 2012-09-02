package com.bitzcraftonline.iain;

import java.util.ArrayList;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ExplodingArrowsListener  implements Listener {
  private ExplodingArrows plugin;

  public ExplodingArrowsListener(ExplodingArrows plugin)
  {
    this.plugin = plugin;
  }

  @EventHandler(priority=EventPriority.NORMAL)
  public void onProjectileHit(ProjectileHitEvent event) {
    Entity entity = event.getEntity();
    if ((entity instanceof Arrow)) {
      Arrow arrow = (Arrow)entity;
      Entity shooter = arrow.getShooter();
      if ((shooter instanceof Player)) {
        Player player = (Player)shooter;
        if ((this.plugin.enabledPlayers.contains(player.getName())) && 
          (player.hasPermission("explodingarrows.use")))
          player.getWorld().createExplosion(arrow.getLocation(), 5.0F);
      }
    }
  }
}
