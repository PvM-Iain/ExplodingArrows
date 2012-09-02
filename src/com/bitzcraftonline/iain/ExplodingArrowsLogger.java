package com.bitzcraftonline.iain;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;

public class ExplodingArrowsLogger {
  private ExplodingArrows plugin;
  private Logger log;

  public ExplodingArrowsLogger(ExplodingArrows plugin)
  {
    this.plugin = plugin;
    this.log = Logger.getLogger("Minecraft");
  }

  private String buildString(String msg) {
    PluginDescriptionFile pdfFile = this.plugin.getDescription();
    return "[" + pdfFile.getName() + " " + pdfFile.getVersion() + "]: " + 
      msg;
  }

  public void info(String msg) {
    this.log.info(buildString(msg));
  }

  public void warn(String msg) {
    this.log.warning(buildString(msg));
  }

  public void severe(String msg) {
    this.log.severe(buildString(msg));
  }
}