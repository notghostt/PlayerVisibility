package win.transgirls.playervisibility.mixin.hitbox;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import win.transgirls.crossfabric.annotation.VersionedMixin;
import win.transgirls.playervisibility.PlayerVisibility;
import win.transgirls.playervisibility.config.ModConfig;

@Mixin(value = EntityRenderManager.class, priority = 1001)
@VersionedMixin({">=1.21", "<=1.21.4"})
public class HitboxMixinv121m1214 {
    @Inject(method = "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;Lnet/minecraft/class_1297;FFFF)V", at = @At("HEAD"), cancellable = true)
    private static void injectRenderHitbox(MatrixStack matrices, VertexConsumer vertices, Entity entity, float tickDelta, float red, float green, float blue, CallbackInfo ci) {
        if (ModConfig.hideHitboxes && PlayerVisibility.computeHideInfoForEntityOrState(entity).hide) {
            ci.cancel();
        }
    }
}