package cc.mafien0.yaszoom

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.util.Identifier
import org.lwjgl.glfw.GLFW

object YasZoom : ClientModInitializer {
    const val ZOOM_LEVEL = 0.23f
    val mc: MinecraftClient? = MinecraftClient.getInstance()

    // Keybind
    val category: KeyBinding.Category = KeyBinding.Category.create(
        Identifier.of("yaszoom", "category")
    )
    val keyBinding = KeyBinding(
        "yaszoom.key.zoom", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_C, category
    )

    override fun onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(keyBinding)
    }

    fun isZooming(): Boolean = keyBinding.isPressed
    fun enableSmoothCamera() = mc?.options?.smoothCameraEnabled = true
    fun disableSmoothCamera() = mc?.options?.smoothCameraEnabled = false

    fun manageSmoothCamera() {
        if (isZooming()) {
            enableSmoothCamera()
        } else {
            disableSmoothCamera()
        }
    }
}