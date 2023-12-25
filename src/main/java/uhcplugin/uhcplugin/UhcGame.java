package uhcplugin.uhcplugin;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.Location;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;


import uhcplugin.uhcplugin.handlers.DeathHandler;

public class UhcGame {
    private List<Player> alivePlayers;    
    
    private List<Team> emptyTeams;

  
    public UhcGame() {
      setDeathListener();
      setSpawns();
      startTimer();
      enableTeaming();      // enable teaming (createTeams, click event, proxy event)
      enableRandomSkinCycles();
    }

    public void setDeathListener() {
      new DeathHandler(Plugin.this);
    }
        
    private void setSpawns() {
      List<Player> onlinePlayers = (List<Player>) getServer().getOnlinePlayers(); // TODO: Review
      
      if(onlinePlayers.size() == 12) {
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

        for (int i = 0; i < onlinePlayers.size(); i++) {
          Player player = onlinePlayers.get(i);
          Location SpawnCoords = COORDS_SET[i];

          teleportPlayer(player, SpawnCoords.getX(), SpawnCoords.getY(), SpawnCoords.getZ());
          player.setHealth(20);
          player.setFoodLevel(20);
          makePlayerInvulnerable(player, 60);
        }
      }
      // TODO: Readaptable???
    }

    private void teleportPlayer(Player player, double x, double y, double z) {
      // while (player.getWorld().getBlockAt(x, y, z).getType().isSolid() /* or biome in CAVE_BIOMES */) {
      //   y++; 
      // }
  
      player.teleport(player.getWorld().getBlockAt(x, y, z).getLocation().add(0.5, 0, 0.5)); // TODO: x,y,z to int
    }

    public void makePlayerInvulnerable(Player player, int durationSeconds) {
      player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, durationSeconds * 20, 255));
    }

    private void startTimer() {
      
    }

    private void enableTeaming() {
      registerNewTeam();
      // clck event
      // proxi event (compass + glow)
    }

    private void enableRandomSkinCycles() {
  
    }
}
