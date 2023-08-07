package fi.dy.masa.tweakeroo.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import fi.dy.masa.tweakeroo.config.Configs;
import fi.dy.masa.tweakeroo.config.FeatureToggle;
import fi.dy.masa.tweakeroo.renderer.RenderUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.render.BackgroundRenderer.class)
public abstract class MixinBackgroundRenderer
{
    @Inject(method = "setupFog", require = 0,
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;fogDensity(F)V", ordinal = 1))
    private static void reduceLavaFog(
            Camera arg, BackgroundRenderer.FogType arg2, float g, boolean bl, float partialTicks, CallbackInfo ci)
    {
        if (FeatureToggle.TWEAK_LAVA_VISIBILITY.getBooleanValue() &&
                !Configs.Generic.LAVA_VISIBILITY_OPTIFINE.getBooleanValue())
        {
            RenderUtils.overrideLavaFog(MinecraftClient.getInstance().getCameraEntity());
        }
    }

    @Inject(method = "setupFog", require = 0,
               at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;fogEnd(F)V", shift = At.Shift.AFTER))
    private static void disableRenderDistanceFog(
            Camera arg, BackgroundRenderer.FogType arg2, float g, boolean thickFog, float partialTicks, CallbackInfo ci)
    {
        if (Configs.Disable.DISABLE_RENDER_DISTANCE_FOG.getBooleanValue() && !thickFog)
        {
            float renderDistance = MinecraftClient.getInstance().gameRenderer.getViewDistance();
            RenderSystem.fogStart(renderDistance * 1.6F);
            RenderSystem.fogEnd(renderDistance * 2.0F);
        }
    }
}
