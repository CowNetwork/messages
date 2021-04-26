package network.cow.messages.spigot

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import network.cow.messages.adventure.comp
import network.cow.messages.adventure.debug
import network.cow.messages.adventure.error
import network.cow.messages.adventure.info
import network.cow.messages.adventure.prefix
import network.cow.messages.adventure.success
import network.cow.messages.adventure.warning
import org.bukkit.entity.Player

/**
 * @author Benedikt Wüller
 */

fun Player.send(message: String, prefix: Component? = null) = this.send(message.comp(), prefix)

fun Player.send(message: Component, prefix: Component? = null) {
    val finalMessage = when (val finalPrefix = prefix ?: MessagesPlugin.PREFIX) {
        null -> message
        else -> message.prefix(finalPrefix)
    }
    this.sendMessage(finalMessage)
}

fun Player.send(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.build(), prefix)

fun Player.sendInfo(message: String, prefix: Component? = null) = this.send(message.info(), prefix)
fun Player.sendInfo(message: Component, prefix: Component? = null) = this.send(message.info(), prefix)
fun Player.sendInfo(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.info(), prefix)

fun Player.sendSuccess(message: String, prefix: Component? = null) = this.send(message.success(), prefix)
fun Player.sendSuccess(message: Component, prefix: Component? = null) = this.send(message.success(), prefix)
fun Player.sendSuccess(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.success(), prefix)

fun Player.sendWarning(message: String, prefix: Component? = null) = this.send(message.warning(), prefix)
fun Player.sendWarning(message: Component, prefix: Component? = null) = this.send(message.warning(), prefix)
fun Player.sendWarning(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.warning(), prefix)

fun Player.sendError(message: String, prefix: Component? = null) = this.send(message.error(), prefix)
fun Player.sendError(message: Component, prefix: Component? = null) = this.send(message.error(), prefix)
fun Player.sendError(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.error(), prefix)

fun Player.sendDebug(message: String, prefix: Component? = null) = this.send(message.debug(), prefix)
fun Player.sendDebug(message: Component, prefix: Component? = null) = this.send(message.debug(), prefix)
fun Player.sendDebug(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.debug(), prefix)
