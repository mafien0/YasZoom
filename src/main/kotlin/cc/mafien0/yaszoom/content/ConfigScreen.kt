package cc.mafien0.yaszoom.content

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.toast.SystemToast
import net.minecraft.text.Text

class ConfigScreen(title: Text, val parent: Screen) : Screen(title) {
    override fun init() {
//        val buttonWidget = ButtonWidget.builder(Text.literal("Hello World!")) {
//            client!!.toastManager.add(
//                SystemToast.create(
//                    client!!,
//                    SystemToast.Type.NARRATOR_TOGGLE,
//                    Text.literal("Hello World!"),
//                    Text.literal("This is a toast")
//                )
//            )
//        }.dimensions(40,40, 120, 20).build()
//        addDrawableChild(buttonWidget)
    }

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        super.render(context, mouseX, mouseY, delta)
        context.drawText(textRenderer, "Special Button", 40, 40 - textRenderer.fontHeight - 10, 0xFFFFFFFF.toInt(), true)
    }

    override fun close() {
        client!!.setScreen(parent)
    }
}