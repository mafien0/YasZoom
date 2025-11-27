package cc.mafien0.yaszoom

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.util.Identifier
import org.lwjgl.glfw.GLFW

object YasZoom : ClientModInitializer {
    val mc: MinecraftClient? = MinecraftClient.getInstance()

    const val ZOOM_LEVEL = 0.3f
    const val SENSITIVITY_MODIFIER = 0.3f
    var currentlyZooming = false
    var originalSensitivity: Double? = mc?.options?.mouseSensitivity?.getValue() ?: 1.0

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

    fun isKeyPressed(): Boolean = keyBinding.isPressed

    fun zoomStarting(): Boolean = isKeyPressed() && !currentlyZooming
    fun zoomStopping(): Boolean = !isKeyPressed() && currentlyZooming
    fun zoomStarted() { currentlyZooming = true }
    fun zoomStopped() { currentlyZooming = false }

    fun lowerSensitivity() {
        originalSensitivity = mc?.options?.mouseSensitivity?.getValue()
        mc?.options?.mouseSensitivity?.setValue(originalSensitivity?.times(SENSITIVITY_MODIFIER))
    }

    fun restoreSensitivity() {
        mc?.options?.mouseSensitivity?.setValue(originalSensitivity)
    }

    fun manageSensitivity() {
        if (zoomStarting()) {
            zoomStarted()
            lowerSensitivity()
        }
        if (zoomStopping()) {
            zoomStopped()
            restoreSensitivity()
        }
    }
}