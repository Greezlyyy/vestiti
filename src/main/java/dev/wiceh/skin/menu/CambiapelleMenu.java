package dev.wiceh.skin.menu;

import dev.wiceh.skin.Main;
import net.skinsrestorer.api.PlayerWrapper;
import net.skinsrestorer.api.SkinsRestorerAPI;
import net.skinsrestorer.api.exception.SkinRequestException;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;

public class CambiapelleMenu {

    public static void open(Player player) {
        new AnvilGUI.Builder()
                .onClick((slot, stateSnapshot) -> {
                    if(slot != AnvilGUI.Slot.OUTPUT) {
                        return Collections.emptyList();
                    }

                    if(stateSnapshot.getText() != null || !stateSnapshot.getText().trim().isEmpty()) {
                        try {
                            SkinsRestorerAPI.getApi().setSkin(player.getName(), stateSnapshot.getText());
                            SkinsRestorerAPI.getApi().applySkin(new PlayerWrapper(player));
                            player.sendMessage("§6§lVESTITI §aPelle modificata");
                        } catch (SkinRequestException e) {
                            throw new RuntimeException(e);
                        }
                        return Arrays.asList(AnvilGUI.ResponseAction.close());
                    } else {
                        return Arrays.asList(AnvilGUI.ResponseAction.replaceInputText("§f"));
                    }
                })
                .text("§f")
                .title("§eInserisci nome")
                .plugin(Main.getInstance())
                .open(player);
    }
}
