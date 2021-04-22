package network.cow.messages.spigot

import net.kyori.adventure.text.event.ClickEvent
import network.cow.messages.adventure.active
import network.cow.messages.adventure.format
import network.cow.messages.adventure.inactive
import network.cow.messages.adventure.warning
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Benedikt Wüller
 */
class MessagesPlugin : JavaPlugin() {

    override fun onEnable() {
        val message = "Are you sure you want to do this? %1$ %2$".warning().format(
            "[Yes]".active().clickEvent(ClickEvent.runCommand("")),
            "[No]".inactive().clickEvent(ClickEvent.runCommand(""))
        )
    }

}
