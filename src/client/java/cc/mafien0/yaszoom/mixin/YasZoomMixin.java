package cc.mafien0.yaszoom.mixin;

import cc.mafien0.yaszoom.YasZoom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class YasZoomMixin {
    @Inject(method = "getFov(Lnet/minecraft/client/render/Camera;FZ)F", at = @At("RETURN"), cancellable = true)
    public void getZoomLevel(CallbackInfoReturnable<Float> callbackInfo) {

        if (YasZoom.INSTANCE.isKeyPressed()) {
            float fov = callbackInfo.getReturnValue();
            callbackInfo.setReturnValue(fov * YasZoom.ZOOM_LEVEL);
        }

        YasZoom.INSTANCE.manageSensitivity();

    }
}