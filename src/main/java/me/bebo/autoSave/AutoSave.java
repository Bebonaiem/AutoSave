package me.bebo.autoSave;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoSave extends JavaPlugin {

    private int taskId;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        printBanner();
        startAutoSaveTask();
    }

    private void printBanner() {
        String banner = """
                \n
                █████╗ ██╗   ██╗████████╗ ██████╗      ███████╗ █████╗ ██╗   ██╗███████╗
                ██╔══██╗██║   ██║╚══██╔══╝██╔═══██╗    ██╔════╝██╔══██╗██║   ██║██╔════╝
                ███████║██║   ██║   ██║   ██║   ██║    ███████╗███████║██║   ██║█████╗  
                ██╔══██║██║   ██║   ██║   ██║   ██║    ╚════██║██╔══██║╚██╗ ██╔╝██╔══╝  
                ██║  ██║╚██████╔╝   ██║   ╚██████╔╝    ███████║██║  ██║ ╚████╔╝ ███████╗
                ╚═╝  ╚═╝ ╚═════╝    ╚═╝    ╚═════╝     ╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝
                               AutoSave v%s - Automatic World Saving
                ============================================================================
                """.formatted(getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + banner);
        getLogger().info("AutoSave v" + getDescription().getVersion() + " enabled!");
    }

    private void startAutoSaveTask() {
        long interval = config.getLong("interval", 300) * 20L;

        if (taskId != 0) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[AutoSave] Reloading autosave task...");
            Bukkit.getScheduler().cancelTask(taskId);
        }

        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            Bukkit.getServer().savePlayers();
            Bukkit.getWorlds().forEach(world -> world.save());

            if (config.getBoolean("debug", false)) {
                getLogger().info("Saved all data. Next save in " + (interval/20) + "s");
            }
        }, interval, interval);
    }

    @Override
    public void onDisable() {
        if (taskId != 0) {
            Bukkit.getScheduler().cancelTask(taskId);
        }
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[AutoSave] Plugin disabled!");
    }
}