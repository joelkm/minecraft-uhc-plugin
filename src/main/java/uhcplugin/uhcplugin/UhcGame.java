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

    private List<Player> players
    
    private List<Team> Teams;
    
    private 
    

  
    public UhcGame(Plugin plugin) {
        this.plugin = plugin;
        this.players = (List<Player>) plugin.getServer().getOnlinePlayers();

        new DeathHandler(this, this.plugin);
        spawnPlayers();

        this.scoreboards = createScoreboards();
        new Timer(this.plugin);

        enableTeaming();
            // enable teaming (createTeams, click event, proxy event)
        enableRandomSkinCycles();
    }


    private void spawnPlayers() {        
        // if(onlinePlayers.size() == 12) {
            Location[] COORDS_SET = { // TODO: Set coords
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

            for (int i = 0; i < this.players.size(); i++) {
                Player player = this.players.get(i);
                Location SpawnCoords = COORDS_SET[i];

                teleportPlayer(player, SpawnCoords.getX(), SpawnCoords.getY(), SpawnCoords.getZ());
                
                player.setHealth(20);
                player.setFoodLevel(20);
                // To avoid fall damage
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, durationSeconds * 20, 255));
            }
        // } else {
            
        }
      // TODO: Readaptable???

    private void teleportPlayer(Player player, double x, double y, double z) {
      // while (player.getWorld().getBlockAt(x, y, z).getType().isSolid() /* or biome in CAVE_BIOMES */) {
      //   y++; 
      // }
  
      player.teleport(player.getWorld().getBlockAt(x, y, z).getLocation().add(0.5, 0, 0.5)); // TODO: x,y,z to int
    }

    private void startTimer() {
      new Timer(this.plugin);
    }

    private void enableTeaming() {
        for (int i = 0; i < 4; i++) {
            Scoreboard.registerNewTeam(String.format("Team %s", i));
            
        }
      // clck event
      // proxi event (compass + glow)
    }

    private void enableRandomSkinCycles() {
  
    }
}
