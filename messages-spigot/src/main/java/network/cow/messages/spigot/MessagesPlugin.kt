package network.cow.messages.spigot

import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Benedikt Wüller
 */
class MessagesPlugin : JavaPlugin() {

    companion object {
        var PREFIX: Component? = null
    }

    override fun onEnable() {
//        val translations = this.config.getConfigurationSection("translations")
//
//        val locales = translations?.getConfigurationSection("locales")
//        locales?.getKeys(false)?.forEach { locale ->
//            val section = locales.getConfigurationSection(locale) ?: return@forEach
//            LocalizeService.provideLocale(locale, JsonHttpLocaleProvider(*section.getStringList("paths").toTypedArray()))
//            LocalizeService.setCoreLocale(locale, section.getBoolean("core", false))
//        }
//
//        LocalizeService.fallbackLocale = translations?.getString("fallbackLocale") ?: "en_US"
    }

}
