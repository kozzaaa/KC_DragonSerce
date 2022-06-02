package pl.kozzaaa.dragonserce.commands;

import net.dzikoysk.funnyguilds.basic.user.User;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import pl.kozzaaa.dragonserce.Main;
import pl.kozzaaa.dragonserce.utils.ChatUtil;

import java.util.HashMap;
import java.util.Map;

import static pl.kozzaaa.dragonserce.Main.config;

public class SerceCommand implements CommandExecutor {

    Main plugin;

    public SerceCommand(Main m) {
        plugin = m;
        m.getCommand("serce").setExecutor(this);
    }

    public static Map<String, BukkitTask> tp;

    static {
        SerceCommand.tp = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final Player p = (Player) sender;
        final User user = User.get(p);
        if(!user.hasGuild()) {
            p.sendMessage(ChatUtil.fixColor(config.getString("serce.brak")));
            return false;
        }
        if(!user.isOwner()) {
            p.sendMessage(ChatUtil.fixColor(config.getString("serce.lider")));
            return false;
        }
        p.sendMessage(ChatUtil.fixColor(config.getString("serce.tp")));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 9999));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 9999));
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
        final BukkitTask bt = Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin((Class)Main.class), (Runnable)new Runnable() {
            @Override
            public void run() {
                final BukkitTask bt1 = Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin((Class)Main.class), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        final BukkitTask bt2 = Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin((Class)Main.class), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                final BukkitTask bt3 = Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin((Class)Main.class), (Runnable)new Runnable() {
                                    @Override
                                    public void run() {
                                        final BukkitTask bt4 = Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin((Class)Main.class), (Runnable)new Runnable() {
                                            @Override
                                            public void run() {
                                                p.sendMessage(ChatUtil.fixColor(config.getString("serce.god")));
                                                p.teleport(new Location(p.getWorld(),
                                                        user.getGuild().getEnderCrystal().getBlockX(),
                                                        user.getGuild().getEnderCrystal().getBlockY(),
                                                        user.getGuild().getEnderCrystal().getBlockZ()));
                                                SerceCommand.tp.remove(p.getName()).cancel();
                                            }
                                        }, 40L);
                                        SerceCommand.tp.put(p.getName(), bt4);
                                    }
                                }, 40L);
                                SerceCommand.tp.put(p.getName(), bt3);
                            }
                        }, 40L);
                        SerceCommand.tp.put(p.getName(), bt2);
                    }
                }, 40L);
                SerceCommand.tp.put(p.getName(), bt1);
            }
        }, 40L);
        SerceCommand.tp.put(p.getName(), bt);
        return false;
    }
}

