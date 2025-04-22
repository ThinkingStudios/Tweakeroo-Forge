package fi.dy.masa.tweakeroo.compat.modmenu;

import fi.dy.masa.tweakeroo.gui.GuiConfigs;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.thinkingstudio.mafglib.loader.entrypoints.ConfigScreenEntrypoint;

public class ModMenuImpl implements ConfigScreenEntrypoint
{
    @Override
    public IConfigScreenFactory getModConfigScreenFactory()
    {
        return (modContainer, screen) -> {
            GuiConfigs gui = new GuiConfigs();
            gui.setParent(screen);
            return gui;
        };
    }
}
