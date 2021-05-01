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
import org.bukkit.entity.Player

/**
 * @author Benedikt Wüller
 */

fun Server.broadcast(message: String, prefix: Component? = null, players: Collection<Player> = Bukkit.getOnlinePlayers()) {
    players.forEach { it.send(message, prefix) }
    Bukkit.getConsoleSender().send(message, prefix)
}
fun Server.broadcast(message: Component, prefix: Component? = null, players: Collection<Player> = Bukkit.getOnlinePlayers()) {
    players.forEach { it.send(message, prefix) }
    Bukkit.getConsoleSender().send(message, prefix)
}
fun Server.broadcast(message: TextComponent.Builder, prefix: Component? = null, players: Collection<Player> = Bukkit.getOnlinePlayers()) {
    players.forEach { it.send(message, prefix) }
    Bukkit.getConsoleSender().send(message, prefix)
}

fun Server.broadcastTranslated(key: String, vararg params: Component, prefix: Component? = null, players: Collection<Player> = Bukkit.getOnlinePlayers()) {
    players.forEach { it.sendTranslated(key, *params, prefix = prefix) }
    Bukkit.getConsoleSender().sendTranslated(key, *params, prefix = prefix)
}
fun Server.broadcastTranslated(key: Component, vararg params: Component, prefix: Component? = null, players: Collection<Player> = Bukkit.getOnlinePlayers()) {
    players.forEach { it.sendTranslated(key, *params, prefix = prefix) }
    Bukkit.getConsoleSender().sendTranslated(key, *params, prefix = prefix)
}
fun Server.broadcastTranslated(key: TextComponent.Builder, vararg params: Component, prefix: Component? = null, players: Collection<Player> = Bukkit.getOnlinePlayers()) {
    players.forEach { it.sendTranslated(key, *params, prefix = prefix) }
    Bukkit.getConsoleSender().sendTranslated(key, *params, prefix = prefix)
}

fun Server.broadcastInfo(message: String, prefix: Component? = null) = this.broadcast(message.info(), prefix)
fun Server.broadcastInfo(message: Component, prefix: Component? = null) = this.broadcast(message.info(), prefix)
fun Server.broadcastInfo(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.info(), prefix)

fun Server.broadcastTranslatedInfo(message: String, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedInfo(message: Component, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedInfo(message: TextComponent.Builder, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)

fun Server.broadcastSuccess(message: String, prefix: Component? = null) = this.broadcast(message.success(), prefix)
fun Server.broadcastSuccess(message: Component, prefix: Component? = null) = this.broadcast(message.success(), prefix)
fun Server.broadcastSuccess(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.success(), prefix)

fun Server.broadcastTranslatedSuccess(message: String, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedSuccess(message: Component, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedSuccess(message: TextComponent.Builder, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)

fun Server.broadcastWarning(message: String, prefix: Component? = null) = this.broadcast(message.warning(), prefix)
fun Server.broadcastWarning(message: Component, prefix: Component? = null) = this.broadcast(message.warning(), prefix)
fun Server.broadcastWarning(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.warning(), prefix)

fun Server.broadcastTranslatedWarning(message: String, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedWarning(message: Component, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedWarning(message: TextComponent.Builder, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)

fun Server.broadcastError(message: String, prefix: Component? = null) = this.broadcast(message.error(), prefix)
fun Server.broadcastError(message: Component, prefix: Component? = null) = this.broadcast(message.error(), prefix)
fun Server.broadcastError(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.error(), prefix)

fun Server.broadcastTranslatedError(message: String, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedError(message: Component, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedError(message: TextComponent.Builder, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)

fun Server.broadcastDebug(message: String, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
fun Server.broadcastDebug(message: Component, prefix: Component? = null) = this.broadcast(message.debug(), prefix)
fun Server.broadcastDebug(message: TextComponent.Builder, prefix: Component? = null) = this.broadcast(message.debug(), prefix)

fun Server.broadcastTranslatedDebug(message: String, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedDebug(message: Component, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
fun Server.broadcastTranslatedDebug(message: TextComponent.Builder, vararg params: Component,prefix: Component? = null) = this.broadcastTranslated(message.info(), *params, prefix = prefix)
