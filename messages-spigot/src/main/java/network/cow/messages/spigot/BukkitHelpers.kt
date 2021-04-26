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

fun Bukkit.broadcast(message: String, prefix: Component? = null) = Bukkit.getOnlinePlayers().forEach { it.send(message, prefix) }
fun Bukkit.broadcast(message: Component, prefix: Component? = null) = Bukkit.getOnlinePlayers().forEach { it.send(message, prefix) }
fun Bukkit.broadcast(message: TextComponent.Builder, prefix: Component? = null) = Bukkit.getOnlinePlayers().forEach { it.send(message, prefix) }

fun Bukkit.broadcastInfo(message: String, prefix: Component? = null) = this.broadcast(message.info(), prefix)
fun Bukkit.broadcastInfo(message: Component, prefix: Component? = null) = this.broadcast(message.info(), prefix)
fun Bukkit.broadcastInfo(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.info(), prefix)

fun Bukkit.broadcastSuccess(message: String, prefix: Component? = null) = this.broadcast(message.success(), prefix)
fun Bukkit.broadcastSuccess(message: Component, prefix: Component? = null) = this.broadcast(message.success(), prefix)
fun Bukkit.broadcastSuccess(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.success(), prefix)

fun Bukkit.broadcastWarning(message: String, prefix: Component? = null) = this.broadcast(message.warning(), prefix)
fun Bukkit.broadcastWarning(message: Component, prefix: Component? = null) = this.broadcast(message.warning(), prefix)
fun Bukkit.broadcastWarning(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.warning(), prefix)

fun Bukkit.broadcastError(message: String, prefix: Component? = null) = this.broadcast(message.error(), prefix)
fun Bukkit.broadcastError(message: Component, prefix: Component? = null) = this.broadcast(message.error(), prefix)
fun Bukkit.broadcastError(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.error(), prefix)

fun Bukkit.broadcastDebug(message: String, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
fun Bukkit.broadcastDebug(message: Component, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
fun Bukkit.broadcastDebug(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
