package network.cow.messages.spigot

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import network.cow.messages.adventure.debug
import network.cow.messages.adventure.error
import network.cow.messages.adventure.info
import network.cow.messages.adventure.success
import network.cow.messages.adventure.warning
import org.bukkit.Bukkit

/**
 * @author Benedikt Wüller
 */

fun Bukkit.broadcast(message: String) = Bukkit.getOnlinePlayers().forEach { it.sendMessage(message) }
fun Bukkit.broadcast(message: Component) = Bukkit.getOnlinePlayers().forEach { it.sendMessage(message) }
fun Bukkit.broadcast(message: TextComponent.Builder) = Bukkit.getOnlinePlayers().forEach { it.sendMessage(message) }

fun Bukkit.broadcastInfo(message: String) = this.broadcast(message.info())
fun Bukkit.broadcastInfo(message: Component) = this.broadcast(message.info())
fun Bukkit.broadcastInfo(message: TextComponent.Builder) = this.broadcast(message.info())

fun Bukkit.broadcastSuccess(message: String) = this.broadcast(message.success())
fun Bukkit.broadcastSuccess(message: Component) = this.broadcast(message.success())
fun Bukkit.broadcastSuccess(message: TextComponent.Builder) = this.broadcast(message.success())

fun Bukkit.broadcastWarning(message: String) = this.broadcast(message.warning())
fun Bukkit.broadcastWarning(message: Component) = this.broadcast(message.warning())
fun Bukkit.broadcastWarning(message: TextComponent.Builder) = this.broadcast(message.warning())

fun Bukkit.broadcastError(message: String) = this.broadcast(message.error())
fun Bukkit.broadcastError(message: Component) = this.broadcast(message.error())
fun Bukkit.broadcastError(message: TextComponent.Builder) = this.broadcast(message.error())

fun Bukkit.broadcastDebug(message: String) = this.broadcast(message.debug())
fun Bukkit.broadcastDebug(message: Component) = this.broadcast(message.debug())
fun Bukkit.broadcastDebug(message: TextComponent.Builder) = this.broadcast(message.debug())
