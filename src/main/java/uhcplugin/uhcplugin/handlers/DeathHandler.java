package uhcplugin.uhcplugin.handlers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import uhcplugin.uhcplugin.Plugin;
import uhcplugin.uhcplugin.UhcGame;

import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * DeathHandler
 */
public class DeathHandler implements Listener {
    public DeathHandler(UhcGame game, Plugin plugin) { // TODO: Why passing the UHC game???
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        
        
        player.setGameMode(GameMode.SPECTATOR);
    }
}