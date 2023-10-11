package dev.wiceh.skin.commands;

import dev.wiceh.skin.Main;
import dev.wiceh.skin.menu.VestitiMenu;
import net.minecraft.util.thread.Mailbox;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class creaVestitoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("vestiti.crea")) {
                if(args.length == 0) {
                    player.sendMessage("§cUtilizzo: §7/creaVestito <nomeFile>");
                }else if(args.length == 1){
                    String nomeFile = args[0];
                    File file = new File(Main.getInstance().getDataFolder() + "\\" + nomeFile + ".png");
                    if(file.exists()) {
                        if(player.getInventory().getItemInHand() != null || !player.getInventory().getItemInHand().getType().equals(Material.AIR)) {
                            VestitiMenu.inventory.addItem(player.getInventory().getItemInHand());
                            player.sendMessage("§aVestito aggiunto!");
                        }else {
                            player.sendMessage("§cDevi tenere in mano un'oggetto!");
                        }
                    }else {
                        player.sendMessage("§cQuesto file non esiste!");
                    }
                }else {
                    player.sendMessage("§cUtilizzo: §7/creaVestito <nomeFile>");
                }
            }else {
                player.sendMessage("§cNon hai il permesso per eseguire questo comando!");
            }
        }
        return true;
    }
}
