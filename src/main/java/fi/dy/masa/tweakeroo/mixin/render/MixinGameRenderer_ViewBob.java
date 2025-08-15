package fi.dy.masa.tweakeroo.mixin.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import fi.dy.masa.tweakeroo.config.Configs;

/**
 * Separated out for Iris compatibility by adjusting the Mixin Priority
 */
@Mixin(value = GameRenderer.class, priority = 999)
public abstract class MixinGameRenderer_ViewBob
{
    @Shadow
    protected abstract void bobView(MatrixStack matrices, float tickDelta);

    @WrapOperation(method = "renderWorld", require = 0, at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/render/GameRenderer;bobView(Lnet/minecraft/client/util/math/MatrixStack;F)V"))
    private void disableWorldViewBob(GameRenderer renderer, MatrixStack matrices, float tickDelta, Operation<Void> original)
    {
        if (Configs.Disable.DISABLE_WORLD_VIEW_BOB.getBooleanValue() == false)
        {
            this.bobView(matrices, tickDelta);
        }
        else
        {
            original.call(renderer, matrices, tickDelta);
        }
    }
}
