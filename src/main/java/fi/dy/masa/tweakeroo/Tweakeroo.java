package fi.dy.masa.tweakeroo;

import fi.dy.masa.malilib.compat.neoforge.ForgePlatformUtils;
import fi.dy.masa.tweakeroo.gui.GuiConfigs;
import fi.dy.masa.tweakeroo.tweaks.PlacementTweaks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerDestroyItemEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fi.dy.masa.malilib.event.InitializationHandler;

@Mod(Reference.MOD_ID)
public class Tweakeroo {
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    public static int renderCountItems;
    public static int renderCountXPOrbs;

    public Tweakeroo() {
        if (FMLLoader.getDist().isClient()) {
            this.onInitializeClient();

            NeoForge.EVENT_BUS.addListener(PlayerDestroyItemEvent.class, event -> {
                PlacementTweaks.onProcessRightClickPost(event.getEntity(), event.getHand());
            });
        }
    }

    public void onInitializeClient() {
        ForgePlatformUtils.getInstance().getClientModIgnoredServerOnly();
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());

        ForgePlatformUtils.getInstance().getMod(Reference.MOD_ID).registerModConfigScreen((screen) -> {
            GuiConfigs gui = new GuiConfigs();
            gui.setParent(screen);
            return gui;
        });
    }
}
