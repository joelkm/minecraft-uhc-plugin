package uhcplugin.uhcplugin;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.Location;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import uhcplugin.uhcplugin.game.PlayersStatusManager;
import uhcplugin.uhcplugin.handlers.DeathHandler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.EventExecutor;


public class UhcGame {

    private Plugin plugin;

    private Scoreboard MainScoreboard;

    private List<Player> players;
    
    private List<Player> players;

    private List<Team> Teams;
    
    private Timer Timer;
  
    public UhcGame(Plugin plugin) {
        this.plugin = plugin;
        this.players = (List<Player>) plugin.getServer().getOnlinePlayers();

        new DeathHandler(this, this.plugin);
        spawnPlayers();

        this.MainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        this.scoreboards = createScoreboards();
        new Timer(this.plugin);

        enableTeaming();
            // enable teaming (createTeams, click event, proxy event)
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
                player.setScoreboard();

                player.setHealth(20);
                player.setFoodLevel(20);
                // To avoid fall damage
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, durationSeconds * 20, 255));
            }
        // } else {
            
        }

    private void enableTeaming() {
        for (int i = 0; i < 4; i++) {
            Scoreboard.registerNewTeam(String.format("Team %s", i));   
        }
    }

    private void enableRandomSkinCycles() {
  
    }

    public void handleTeamChange(Player player, Team oldTeam, Team newTeam) {
        oldTeam.removeEntry(player);
        newTeam.addEntry(player);
    
        player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
    }
}
