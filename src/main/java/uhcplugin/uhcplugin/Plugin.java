package uhcplugin.uhcplugin;

import java.util.logging.Logger;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.command.Command;
/*
 * start-uhc java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("start-uhc");

  public void onEnable()
  {
    LOGGER.info("start-uhc enabled");
  }

  public void onDisable()
  {
    LOGGER.info("start-uhc disabled");
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) { // TODO: Check op role
      if (label.equalsIgnoreCase("startuhc")) {
        new UhcGame(this);
            return true;
      }
      if (label.equalsIgnoreCase("startuhc")) { // Change to rename command
        new UhcGame(this);
            return true;
      }   
    }
    return false;
  }
}


