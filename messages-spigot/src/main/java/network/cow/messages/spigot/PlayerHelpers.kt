package network.cow.messages.spigot

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import network.cow.messages.adventure.debug
import network.cow.messages.adventure.error
import network.cow.messages.adventure.info
import network.cow.messages.adventure.success
import network.cow.messages.adventure.warning
import org.bukkit.entity.Player

/**
 * @author Benedikt Wüller
 */

fun Player.sendInfo(message: String) = this.sendMessage(message.info())
fun Player.sendInfo(message: Component) = this.sendMessage(message.info())
fun Player.sendInfo(message: TextComponent.Builder) = this.sendMessage(message.info())

fun Player.sendSuccess(message: String) = this.sendMessage(message.success())
fun Player.sendSuccess(message: Component) = this.sendMessage(message.success())
fun Player.sendSuccess(message: TextComponent.Builder) = this.sendMessage(message.success())

fun Player.sendWarning(message: String) = this.sendMessage(message.warning())
fun Player.sendWarning(message: Component) = this.sendMessage(message.warning())
fun Player.sendWarning(message: TextComponent.Builder) = this.sendMessage(message.warning())

fun Player.sendError(message: String) = this.sendMessage(message.error())
fun Player.sendError(message: Component) = this.sendMessage(message.error())
fun Player.sendError(message: TextComponent.Builder) = this.sendMessage(message.error())

fun Player.sendDebug(message: String) = this.sendMessage(message.debug())
fun Player.sendDebug(message: Component) = this.sendMessage(message.debug())
fun Player.sendDebug(message: TextComponent.Builder) = this.sendMessage(message.debug())
