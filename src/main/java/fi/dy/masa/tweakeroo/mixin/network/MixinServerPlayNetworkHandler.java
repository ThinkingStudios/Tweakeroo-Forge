package fi.dy.masa.tweakeroo.mixin.network;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.util.math.Vec3d;
import fi.dy.masa.tweakeroo.config.Configs;

@Mixin(value = ServerPlayNetworkHandler.class, priority = 1005)
public class MixinServerPlayNetworkHandler
{
    @WrapOperation(method = "onPlayerInteractBlock", require = 0,
              at = @At(value = "INVOKE",
                       target = "Lnet/minecraft/util/math/Vec3d;subtract(Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/Vec3d;"))
    private Vec3d tweakeroo_removeHitPosCheck(Vec3d hitVec, Vec3d blockCenter, Operation<Vec3d> original)
    {
        if (Configs.Generic.ITEM_USE_PACKET_CHECK_BYPASS.getBooleanValue())
        {
            return Vec3d.ZERO;
        }

        return original.call(hitVec, blockCenter);
    }
}
