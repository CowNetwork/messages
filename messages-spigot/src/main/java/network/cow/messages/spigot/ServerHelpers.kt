package network.cow.messages.spigot

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import network.cow.messages.adventure.debug
import network.cow.messages.adventure.error
import network.cow.messages.adventure.info
import network.cow.messages.adventure.success
import network.cow.messages.adventure.warning
import org.bukkit.Bukkit
import org.bukkit.Server

/**
 * @author Benedikt Wüller
 */

fun Server.broadcast(message: String, prefix: Component? = null) = Bukkit.getOnlinePlayers().forEach { it.send(message, prefix) }
fun Server.broadcast(message: Component, prefix: Component? = null) = Bukkit.getOnlinePlayers().forEach { it.send(message, prefix) }
fun Server.broadcast(message: TextComponent.Builder, prefix: Component? = null) = Bukkit.getOnlinePlayers().forEach { it.send(message, prefix) }

fun Server.broadcastInfo(message: String, prefix: Component? = null) = this.broadcast(message.info(), prefix)
fun Server.broadcastInfo(message: Component, prefix: Component? = null) = this.broadcast(message.info(), prefix)
fun Server.broadcastInfo(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.info(), prefix)

fun Server.broadcastSuccess(message: String, prefix: Component? = null) = this.broadcast(message.success(), prefix)
fun Server.broadcastSuccess(message: Component, prefix: Component? = null) = this.broadcast(message.success(), prefix)
fun Server.broadcastSuccess(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.success(), prefix)

fun Server.broadcastWarning(message: String, prefix: Component? = null) = this.broadcast(message.warning(), prefix)
fun Server.broadcastWarning(message: Component, prefix: Component? = null) = this.broadcast(message.warning(), prefix)
fun Server.broadcastWarning(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.warning(), prefix)

fun Server.broadcastError(message: String, prefix: Component? = null) = this.broadcast(message.error(), prefix)
fun Server.broadcastError(message: Component, prefix: Component? = null) = this.broadcast(message.error(), prefix)
fun Server.broadcastError(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.error(), prefix)

fun Server.broadcastDebug(message: String, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
fun Server.broadcastDebug(message: Component, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
fun Server.broadcastDebug(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
