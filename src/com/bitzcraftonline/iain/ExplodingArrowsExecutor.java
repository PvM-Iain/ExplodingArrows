package com.bitzcraftonline.iain;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

class ExplodingArrowsExecutor implements CommandExecutor {
  private ExplodingArrows plugin;

  public ExplodingArrowsExecutor(ExplodingArrows plugin)
  {
    this.plugin = plugin;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
      sender.sendMessage(ChatColor.RED + 
        "Sorry, this command can only be used in-game.");
      return true;
    }

    Player player = (Player)sender;
    String playerName = player.getName();

    if (player.hasPermission("explodingarrows.use"))
    {
      if (this.plugin.enabledPlayers.contains(playerName)) {
        this.plugin.enabledPlayers.remove(playerName);
        player.sendMessage(ChatColor.GREEN + 
          "Exploding Arrows are disabled.");
      } else {
        this.plugin.enabledPlayers.add(playerName);
        player.sendMessage(ChatColor.GREEN + 
          "Exploding Arrows are enabled.");
      }
    }
    else player.sendMessage(ChatColor.RED + 
        "Sorry, You do not have permission to do that. If you believe this is wrong, contact the server administrator.");

    return true;
  }
}
