package uhcplugin.uhcplugin;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerInteractEntityEvent;


import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import uhcplugin.uhcplugin.handlers.DeathHandler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.EventExecutor;


public class UhcGame {

    private Plugin plugin;

    private int desiredNumberOfTeams = 4;
    
    private int currentNumberOfTeams = 0;

    private Scoreboard MainScoreboard;

    private List<Player> players;
        
    private Timer Timer;
  
    public UhcGame(Plugin plugin) {
        this.plugin = plugin;
        this.players = (List<Player>) plugin.getServer().getOnlinePlayers();

        this.MainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        new DeathHandler(this, this.plugin);
        spawnPlayers();

        new Timer(this.plugin);

        enableTeaming();

        enableRandomSkinCycles();
    }


    private void spawnPlayers() {        
    // if(onlinePlayers.size() == 12) {
        Location[] SpawnLocations = { // TODO: Set coords
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0),
            new Location(null, 0, 0, 0)
        };
        // TODO: Readaptable???

        for (int i = 0; i < this.players.size(); i++) {
            Player player = this.players.get(i);

            player.teleport(SpawnLocations[i]);
            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

            player.setHealth(20);
            player.setFoodLevel(20);
            // To avoid fall damage
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, durationSeconds * 20, 255));
        }
    // } else {
        
    }



    private void enableTeaming() {
        // for (int i = 0; i < this.desiredNumberOfTeams; i++) {
        //     this.MainScoreboard.registerNewTeam(String.format("Team %s", i));
        //     Bukkit.getScoreboardManager().getNewScoreboard();
        // }

        // Teaming listener + logic (assign first empty team, notify other players???)
        // Create glowing listener 
        // register compass
    }

    private void enableRandomSkinCycles() {
        // Look up crimson's plugins and IO plugin library
    }

    public void handleTeamChange(Player player, Team oldTeam, Team newTeam) {
        oldTeam.removeEntry(player);
        newTeam.addEntry(player);
    
        player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
    }
}
