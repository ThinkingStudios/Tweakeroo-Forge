package fi.dy.masa.tweakeroo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fi.dy.masa.malilib.event.InitializationHandler;
import fi.dy.masa.tweakeroo.config.Configs;

public class Tweakeroo
{
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    public static int renderCountItems;
    public static int renderCountXPOrbs;

    public static void onInitialize() {
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());
    }

    public static void printDebug(String msg, Object... args)
    {
        if (Configs.Generic.DEBUG_LOGGING.getBooleanValue())
        {
            Tweakeroo.logger.info(msg, args);
        }
    }
}
