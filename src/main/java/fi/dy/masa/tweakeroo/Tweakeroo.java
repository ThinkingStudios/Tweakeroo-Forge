package fi.dy.masa.tweakeroo;

import fi.dy.masa.malilib.compat.forge.ForgePlatformCompat;
import fi.dy.masa.tweakeroo.gui.GuiConfigs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fi.dy.masa.malilib.event.InitializationHandler;

@Mod(Reference.MOD_ID)
public class Tweakeroo
{
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    public static int renderCountItems;
    public static int renderCountXPOrbs;

    public Tweakeroo(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onInitializeClient);
    }

    public void onInitializeClient(FMLClientSetupEvent event) {
        ForgePlatformCompat.getInstance().getModClientExtensionPoint();
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());

        ForgePlatformCompat.getInstance().getMod(Reference.MOD_ID).registerModConfigScreen((screen) -> {
            GuiConfigs gui = new GuiConfigs();
            gui.setParent(screen);
            return gui;
        });
    }
}
