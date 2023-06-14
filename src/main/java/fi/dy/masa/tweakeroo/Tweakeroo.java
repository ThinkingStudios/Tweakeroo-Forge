package fi.dy.masa.tweakeroo;

import net.minecraftforge.fml.common.Mod;
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
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());
    }
}
