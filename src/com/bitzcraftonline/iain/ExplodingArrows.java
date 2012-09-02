package com.bitzcraftonline.iain;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplodingArrows extends JavaPlugin {
  protected ExplodingArrowsLogger log;
  protected ArrayList enabledPlayers;
  public Permission explodePermission;

  public ExplodingArrows()
  {
    this.explodePermission = new Permission("explodingarrows.use");
  }

  public void onEnable()
  {
    getLogger().info("ExplodingArrows has been successfully enabled.");
    this.log = new ExplodingArrowsLogger(this);
    this.enabledPlayers = new ArrayList();
    getCommand("ea").setExecutor(new ExplodingArrowsExecutor(this));
    PluginManager manager = getServer().getPluginManager();
    manager.registerEvents(new ExplodingArrowsListener(this), this);
  }

  public void onDisable() {
    getLogger().info("ExplodingArrows has been successfully disabled.");
  }
}