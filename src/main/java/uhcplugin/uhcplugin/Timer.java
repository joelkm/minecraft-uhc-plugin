package uhcplugin.uhcplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;


public class Timer {
    private Plugin plugin;

    Timer(Plugin plugin) {
        this.plugin = plugin;
        this.start();
    }

    private void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
            // Update the timer on the scoreboard
            ScoreboardManager.updateTimer();

            // Check for specific time intervals and trigger actions
            int currentTime = ScoreboardManager.getCurrentTime();
            if (currentTime == 300) {
                // Execute action at 5 minutes (300 seconds)
                // Your action code here
            } else if (currentTime == 600) {
                // Execute action at 10 minutes (600 seconds)
                // Your action code here
            }
            // Add more conditions as needed
        }, 0L, 20L); // Update every second (20 ticks)
    }

    public static void updateScoreboard() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Scoreboard scoreboard = player.getScoreboard();
            Objective objective = scoreboard.getObjective("timer");

            if (objective == null) {
                objective = scoreboard.registerNewObjective("timer", "dummy", "Timer");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            }

            objective.setDisplayName("Timer: " + formatTime(currentTime));
            objective.getScore(" ").setScore(0); // Blank line for formatting
            currentTime++;
        }
    }
}
