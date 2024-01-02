package uhcplugin.uhcplugin.handlers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import org.bukkit.scoreboard.Team;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import uhcplugin.uhcplugin.Plugin;

import org.bukkit.ChatColor;

public class TeamingHandler implements Listener{
    public TeamingHandler(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void onPlayerRightClick(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Player) {
            Player player = event.getPlayer();
            Player target = (Player) event.getRightClicked();

            Team PlayerTeam = player.getScoreboard().getEntryTeam(player.getName());
            Team TargetTeam = target.getScoreboard().getEntryTeam(target.getName());
            
            if (TargetTeam != null) {
                return;
            }

            if (PlayerTeam == null) {
                // create team (create team scoreboard, register team, add player, set player scoreboard)
            }

            if (PlayerTeam.getEntries().size() == 3) {
                return;
            }

            // Add target

            // TODO: Reveal skins 💀💀💀
            String[] playerMsg = {
                ChatColor.GREEN + target.getName() + " se ha unido a tu equipo!", 
                "Puedes consultar el estado de los miembros en el panel derecho",
                "Tambien podeis cambiar el nombre de vuestro equipo usando /teamname <nombre del equipo>"
            };
            String[] targetMsg = {
                ChatColor.GREEN + player.getName() + " te ha elegido para su equipo!", 
                "Puedes consultar el estado de los miembros en el panel derecho",
                "Tambien podeis cambiar el nombre de vuestro equipo usando /teamname <nombre del equipo>"
            };

            player.sendMessage(playerMsg);
            target.sendMessage(targetMsg);
            
        }
    }
}
