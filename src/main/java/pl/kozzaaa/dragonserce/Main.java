package pl.kozzaaa.dragonserce;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import pl.kozzaaa.dragonserce.commands.SerceCommand;
import pl.kozzaaa.dragonserce.listeners.FromListeners;

public final class Main extends JavaPlugin {

    public static FileConfiguration config;
    public static Main plugin;

    @Override
    public void onEnable() {
        Main.plugin = this;
        Main.config = this.getConfig();
        config.options().copyDefaults(true);
        saveConfig();

        new SerceCommand(this);

        getServer().getPluginManager().registerEvents(new FromListeners(), this);


        final PluginDescriptionFile pluginDescriptionFile = this.getDescription();
        if (!pluginDescriptionFile.getName().contains("KC_DragonSerce")) {
            Bukkit.getConsoleSender().sendMessage("§4§m------------------------------");
            Bukkit.getConsoleSender().sendMessage(" §c> §cKC_DragonSerce 1.0-SNAPSHOT");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage(" §c> §cWykryto zmiane §4nazwy §cpluginu!");
            Bukkit.getConsoleSender().sendMessage(" §c> §cCofnij zmiany w plugin.yml");
            Bukkit.getConsoleSender().sendMessage("§4§m------------------------------");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (!pluginDescriptionFile.getAuthors().contains("kozzaaa")) {
            Bukkit.getConsoleSender().sendMessage("§4§m------------------------------");
            Bukkit.getConsoleSender().sendMessage(" §c> §cKC_plugin 1.0-SNAPSHOT");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage(" §c> §cWykryto zmiane §4autora §cpluginu!");
            Bukkit.getConsoleSender().sendMessage(" §c> §cCofnij zmiany w plugin.yml");
            Bukkit.getConsoleSender().sendMessage("§4§m------------------------------");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        Bukkit.getConsoleSender().sendMessage("§2§m------------------------------");
        Bukkit.getConsoleSender().sendMessage(" §2> §aKC_DragonSerce 1.0-SNAPSHOT");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" §2> §aTwoj §2server §aposiada aktualna licencje pluginu!");
        Bukkit.getConsoleSender().sendMessage(" §2> §aPlugin stworzony przez §2kozzaaa §adla §2KCode");
        Bukkit.getConsoleSender().sendMessage(" §2> §aNasz server discord: §2https://discord.gg/TnFh3qRMJ7");
        Bukkit.getConsoleSender().sendMessage("§2§m------------------------------");
    }
}
