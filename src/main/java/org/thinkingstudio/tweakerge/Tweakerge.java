package org.thinkingstudio.tweakerge;

import fi.dy.masa.tweakeroo.Reference;
import fi.dy.masa.tweakeroo.Tweakeroo;
import fi.dy.masa.tweakeroo.compat.modmenu.ModMenuImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import org.thinkingstudio.mafglib.loader.entrypoints.ConfigScreenEntrypoint;

@Mod(value = Reference.MOD_ID, dist = Dist.CLIENT)
public class Tweakerge {
    public Tweakerge(ModContainer modContainer) {
        if (FMLLoader.getDist().isClient()) {
            modContainer.registerExtensionPoint(ConfigScreenEntrypoint.class, new ModMenuImpl());
            Tweakeroo.onInitialize();
        }
    }
}
