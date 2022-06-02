package pl.kozzaaa.dragonserce.listeners;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.potion.PotionEffectType;
import pl.kozzaaa.dragonserce.commands.SerceCommand;
import pl.kozzaaa.dragonserce.utils.ChatUtil;

import static pl.kozzaaa.dragonserce.Main.config;

public class FromListeners implements Listener
{
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Location to = e.getTo();
        final Location from = e.getFrom();
        if ((from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ()) && SerceCommand.tp.containsKey(p.getName())) {
            SerceCommand.tp.remove(p.getName()).cancel();
            p.removePotionEffect(PotionEffectType.CONFUSION);
            p.removePotionEffect(PotionEffectType.SLOW);
            p.removePotionEffect(PotionEffectType.BLINDNESS);
            p.sendMessage(ChatUtil.fixColor(config.getString("serce.from")));
        }
    }
}
