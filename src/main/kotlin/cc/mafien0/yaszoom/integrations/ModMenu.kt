package cc.mafien0.yaszoom.integrations

import cc.mafien0.yaszoom.content.ConfigScreen
import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import net.minecraft.text.Text

class ModMenu: ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> = ConfigScreenFactory { parent ->
        ConfigScreen(Text.empty(), parent)
    }
}