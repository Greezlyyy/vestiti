package dev.wiceh.skin.listeners;

import dev.wiceh.skin.Main;
import dev.wiceh.skin.menu.CambiapelleMenu;
import net.skinsrestorer.api.PlayerWrapper;
import net.skinsrestorer.api.SkinsRestorerAPI;
import net.skinsrestorer.api.exception.SkinRequestException;
import net.skinsrestorer.api.interfaces.ISkinStorage;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.mineskin.MineskinClient;
import org.mineskin.data.Skin;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Listeners implements Listener {

    private final MineskinClient mineskinClient;

    public Listeners(String apiKey) {
        this.mineskinClient = new MineskinClient("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36", apiKey);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getView().getTitle().equals("§8Vestiti")) {
                event.setCancelled(true);

                ItemStack currentItem = event.getCurrentItem();
                if (currentItem != null && currentItem.getItemMeta() != null) {
                    String displayName = ChatColor.stripColor(currentItem.getItemMeta().getDisplayName());
                    if (displayName.equalsIgnoreCase("Cambia pelle")) {
                        CambiapelleMenu.open(player);
                    }else if(displayName.equalsIgnoreCase("Vestito Elegante")) {

                        URL playerSkinTexture = player.getPlayerProfile().getTextures().getSkin();

                        combineTextures(player, playerSkinTexture, Main.getInstance().getDataFolder() + "\\Elegante.png");

                        player.sendMessage("§6§lVESTITI §aVestito indossato");

                    }else if(displayName.equalsIgnoreCase("Vestito Gucci")) {

                        URL playerSkinTexture = player.getPlayerProfile().getTextures().getSkin();

                        combineTextures(player, playerSkinTexture, Main.getInstance().getDataFolder() + "\\Gucci.png");

                        player.sendMessage("§6§lVESTITI §aVestito indossato");

                    }else if(displayName.equalsIgnoreCase("Vestito")) {

                        URL playerSkinTexture = player.getPlayerProfile().getTextures().getSkin();

                        combineTextures(player, playerSkinTexture, Main.getInstance().getDataFolder() + "\\Vestito.png");

                        player.sendMessage("§6§lVESTITI §aVestito indossato");

                    }else if(displayName.equalsIgnoreCase("Vestito Militare")) {

                        URL playerSkinTexture = player.getPlayerProfile().getTextures().getSkin();

                        combineTextures(player, playerSkinTexture, Main.getInstance().getDataFolder() + "\\Militare.png");

                        player.sendMessage("§6§lVESTITI §aVestito indossato");

                    }else if(displayName.equalsIgnoreCase("Vestito Elegante 2")) {

                        URL playerSkinTexture = player.getPlayerProfile().getTextures().getSkin();

                        combineTextures(player, playerSkinTexture, Main.getInstance().getDataFolder() + "\\Sexy.png");

                        player.sendMessage("§6§lVESTITI §aVestito indossato");

                    }else if(displayName.equalsIgnoreCase("Vestito Medievale")) {

                        URL playerSkinTexture = player.getPlayerProfile().getTextures().getSkin();

                        combineTextures(player, playerSkinTexture, Main.getInstance().getDataFolder() + "\\Medievale.png");

                        player.sendMessage("§6§lVESTITI §aVestito indossato");

                    }else if(displayName.equalsIgnoreCase("Chiudi")) {
                        player.closeInventory();
                    }
                }
            }
        }
    }

    private String combineTextures(Player player, URL playerHeadTexture, String steveBodyTexture) {
        try {
            BufferedImage playerHeadImage = ImageIO.read(new URL(playerHeadTexture.toString()));
            BufferedImage steveBodyImage = ImageIO.read(new File(steveBodyTexture));

            int width = playerHeadImage.getWidth();
            int height = playerHeadImage.getHeight();

            // Create a new BufferedImage to combine the textures
            BufferedImage combinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = combinedImage.createGraphics();

            // Draw Steve's body texture onto the combined image (you may need to adjust the position)
            g.drawImage(steveBodyImage, 0, 0, null);

            // Draw the player's head texture onto the combined image
            g.drawImage(playerHeadImage.getSubimage(0,0,64, 16), 0, 0, null);

            // Dispose of the graphics context
            g.dispose();

            // Save the combined image to a file (you can choose a different format if needed)
            File outputFile = new File(Main.getInstance().getDataFolder(), player.getName() + "_skin-combinata.png");
            ImageIO.write(combinedImage, "PNG", outputFile);

            try {
                Skin skin = this.mineskinClient.generateUpload(combinedImage).get();
                try {
                    SkinsRestorerAPI api = SkinsRestorerAPI.getApi();
                    api.setSkinData(player.getName() + "-FINAL", api.createProperty("textures", skin.data.texture.value, skin.data.texture.signature), 0L);
                    api.setSkin(player.getName(), player.getName() + "-FINAL");
                    api.applySkin(new PlayerWrapper(player));
                } catch (SkinRequestException e) {
                    Main.getInstance().getLogger().warning("Cannot apply skin!");
                    player.sendMessage("An error occurred!");
                }
            } catch (InterruptedException|java.util.concurrent.ExecutionException|IOException e) {
                Main.getInstance().getLogger().warning("Cannot upload skin to MineSkin!");
                player.sendMessage("An error occurred!");
            }

            return outputFile.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
