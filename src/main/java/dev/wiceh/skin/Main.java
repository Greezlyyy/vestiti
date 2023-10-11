package dev.wiceh.skin;

import dev.wiceh.skin.commands.VestitiCommand;
import dev.wiceh.skin.commands.creaVestitoCommand;
import dev.wiceh.skin.listeners.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        getLogger().info("Plugin abilitato!");
        getCommand("vestiti").setExecutor(new VestitiCommand());
        getCommand("creaVestito").setExecutor(new creaVestitoCommand());
        getServer().getPluginManager().registerEvents(new Listeners("de1ede2bb7a1616d2bcc5342944c2d762e88d8e447e89d76408ae63431f18eaf"), this);

    }

    public static Main getInstance() {
        return instance;
    }
}
