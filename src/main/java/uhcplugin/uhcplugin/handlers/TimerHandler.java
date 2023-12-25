package uhcplugin.uhcplugin.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TimerHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Initialize the scoreboard for players when they join
        ScoreboardManager.updateTimer();
    }

    
}