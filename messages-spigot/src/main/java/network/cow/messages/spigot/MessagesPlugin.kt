package network.cow.messages.spigot

import dev.benedikt.localize.LocalizeService
import dev.benedikt.localize.json.JsonHttpLocaleProvider
import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Benedikt Wüller
 */
class MessagesPlugin : JavaPlugin() {

    companion object {
        var PREFIX: Component? = null

        @JvmStatic
        fun setPrefix(prefix: Component?) {
            PREFIX = prefix
        }
    }

    override fun onEnable() {
        val translations = this.config.getConfigurationSection("translations")

        val locales = translations?.getConfigurationSection("locales")
        locales?.getKeys(false)?.forEach { locale ->
            val section = locales.getConfigurationSection(locale) ?: return@forEach
            LocalizeService.provideLocale(locale, JsonHttpLocaleProvider(*section.getStringList("paths").toTypedArray()))
            LocalizeService.setCoreLocale(locale, section.getBoolean("core", false))
        }

        LocalizeService.fallbackLocale = translations?.getString("fallbackLocale") ?: "en_US"
    }

}
