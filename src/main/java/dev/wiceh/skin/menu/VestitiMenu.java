package dev.wiceh.skin.menu;

import de.tr7zw.nbtapi.NBTItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class VestitiMenu {

    public static Inventory inventory = Bukkit.createInventory(null, 9*4, "§8Vestiti");

    public static void open(Player player) {
        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack paginaPrecedente = new ItemStack(Material.GLASS_PANE);
        ItemMeta precedenteMeta = paginaPrecedente.getItemMeta();
        precedenteMeta.setDisplayName(ChatColor.of("#f34646") + "« Pagina precedente");
        paginaPrecedente.setItemMeta(precedenteMeta);

        NBTItem precedenteNBT = new NBTItem(paginaPrecedente);
        precedenteNBT.setInteger("CustomModelData", 11);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack paginaSuccessiva = new ItemStack(Material.GLASS_PANE);
        ItemMeta sucessivaMeta = paginaSuccessiva.getItemMeta();
        sucessivaMeta.setDisplayName(ChatColor.of("#04f380") + "» Pagina successiva");
        paginaSuccessiva.setItemMeta(sucessivaMeta);

        NBTItem successivaNBT = new NBTItem(paginaSuccessiva);
        successivaNBT.setInteger("CustomModelData", 9);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack cambiaPelle = new ItemStack(Material.GLASS_PANE);
        ItemMeta pelleMeta = cambiaPelle.getItemMeta();
        pelleMeta.setDisplayName(ChatColor.of("#f3af00") + "Cambia pelle");
        cambiaPelle.setItemMeta(pelleMeta);

        NBTItem pelleNBT = new NBTItem(cambiaPelle);
        pelleNBT.setInteger("CustomModelData", 17);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack vestitoElegante = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) vestitoElegante.getItemMeta();
        meta.setDisplayName("§cVestito Elegante");
        meta.setColor(Color.RED);
        vestitoElegante.setItemMeta(meta);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack vestitoGucci = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta gucciMeta = (LeatherArmorMeta) vestitoGucci.getItemMeta();
        gucciMeta.setDisplayName("§2Vestito Gucci");
        gucciMeta.setColor(Color.GREEN);
        vestitoGucci.setItemMeta(gucciMeta);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack vestito = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta vestitoMeta = (LeatherArmorMeta) vestito.getItemMeta();
        vestitoMeta.setDisplayName("§8Vestito");
        vestitoMeta.setColor(Color.BLACK);
        vestito.setItemMeta(vestitoMeta);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack vestitoMilitare = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta militareMeta = (LeatherArmorMeta) vestitoMilitare.getItemMeta();
        militareMeta.setDisplayName("§aVestito Militare");
        militareMeta.setColor(Color.LIME);
        vestitoMilitare.setItemMeta(militareMeta);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack chiudi = new ItemStack(Material.BARRIER);
        ItemMeta chiudiMeta = chiudi.getItemMeta();
        chiudiMeta.setDisplayName("§cChiudi");
        chiudiMeta.setLore(Arrays.asList("§7Clicca per chiudere il menù."));
        chiudi.setItemMeta(chiudiMeta);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack vestitoElegante2 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta elegante2Meta = (LeatherArmorMeta) vestitoElegante2.getItemMeta();
        elegante2Meta.setDisplayName("§8Vestito Elegante 2");
        elegante2Meta.setColor(Color.BLACK);
        vestitoElegante2.setItemMeta(elegante2Meta);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////
        ItemStack vestitoMedievale = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta medievaleMeta = (LeatherArmorMeta) vestitoMedievale.getItemMeta();
        medievaleMeta.setDisplayName("§6Vestito Medievale");
        vestitoMedievale.setItemMeta(medievaleMeta);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        inventory.setItem(0, vestito);
        inventory.setItem(1, vestitoElegante);
        inventory.setItem(2, vestitoGucci);
        inventory.setItem(3, vestitoMilitare);
        inventory.setItem(4, vestitoElegante2);
        inventory.setItem(5, vestitoMedievale);
        inventory.setItem(30, precedenteNBT.getItem());
        inventory.setItem(31, pelleNBT.getItem());
        inventory.setItem(32, successivaNBT.getItem());
        inventory.setItem(35, chiudi);

        player.openInventory(inventory);
    }
}
