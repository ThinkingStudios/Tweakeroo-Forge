package fi.dy.masa.tweakeroo.compat.forge;

import fi.dy.masa.tweakeroo.tweaks.PlacementTweaks;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEventHandler {
    @SubscribeEvent
    public void onPlayerDestroyItem(PlayerDestroyItemEvent event) {
        PlacementTweaks.onProcessRightClickPost(event.getEntity(), event.getHand());
    }
}
