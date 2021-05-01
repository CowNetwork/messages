package network.cow.messages.spigot

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import network.cow.messages.adventure.comp
import network.cow.messages.adventure.debug
import network.cow.messages.adventure.error
import network.cow.messages.adventure.info
import network.cow.messages.adventure.prefix
import network.cow.messages.adventure.success
import network.cow.messages.adventure.translate
import network.cow.messages.adventure.translateToComponent
import network.cow.messages.adventure.warning
import org.bukkit.command.CommandSender

/**
 * @author Benedikt Wüller
 */

fun CommandSender.send(message: String, prefix: Component? = null) = this.send(message.comp(), prefix)
fun CommandSender.send(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.build(), prefix)
fun CommandSender.send(message: Component, prefix: Component? = null) {
    val finalMessage = when (val finalPrefix = prefix ?: MessagesPlugin.PREFIX) {
        null -> message
        else -> message.prefix(finalPrefix)
    }
    this.sendMessage(finalMessage)
}

fun CommandSender.sendTranslated(key: String, vararg params: Component, prefix: Component? = null) {
    val message = key.translateToComponent(this, *params)
    this.send(message, prefix)
}
fun CommandSender.sendTranslated(component: Component, vararg params: Component, prefix: Component? = null) {
    val message = component.translate(this, *params)
    this.send(message, prefix)
}
fun CommandSender.sendTranslated(component: TextComponent.Builder, vararg params: Component, prefix: Component? = null) {
    val message = component.build().translate(this, *params)
    this.send(message, prefix)
}

fun CommandSender.sendInfo(message: String, prefix: Component? = null) = this.send(message.info(), prefix)
fun CommandSender.sendInfo(message: Component, prefix: Component? = null) = this.send(message.info(), prefix)
fun CommandSender.sendInfo(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.info(), prefix)

fun CommandSender.sendTranslatedInfo(key: String, vararg params: Component, prefix: Component?) = this.sendTranslated(key.info(), *params, prefix = prefix)
fun CommandSender.sendTranslatedInfo(key: Component, vararg params: Component, prefix: Component?) = this.sendTranslated(key.info(), *params, prefix = prefix)
fun CommandSender.sendTranslatedInfo(key: TextComponent.Builder, vararg params: Component, prefix: Component?) = this.sendTranslated(key.info(), *params, prefix = prefix)

fun CommandSender.sendSuccess(message: String, prefix: Component? = null) = this.send(message.success(), prefix)
fun CommandSender.sendSuccess(message: Component, prefix: Component? = null) = this.send(message.success(), prefix)
fun CommandSender.sendSuccess(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.success(), prefix)

fun CommandSender.sendTranslatedSuccess(key: String, vararg params: Component, prefix: Component?) = this.sendTranslated(key.success(), *params, prefix = prefix)
fun CommandSender.sendTranslatedSuccess(key: Component, vararg params: Component, prefix: Component?) = this.sendTranslated(key.success(), *params, prefix = prefix)
fun CommandSender.sendTranslatedSuccess(key: TextComponent.Builder, vararg params: Component, prefix: Component?) = this.sendTranslated(key.success(), *params, prefix = prefix)

fun CommandSender.sendWarning(message: String, prefix: Component? = null) = this.send(message.warning(), prefix)
fun CommandSender.sendWarning(message: Component, prefix: Component? = null) = this.send(message.warning(), prefix)
fun CommandSender.sendWarning(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.warning(), prefix)

fun CommandSender.sendTranslatedWarning(key: String, vararg params: Component, prefix: Component?) = this.sendTranslated(key.warning(), *params, prefix = prefix)
fun CommandSender.sendTranslatedWarning(key: Component, vararg params: Component, prefix: Component?) = this.sendTranslated(key.warning(), *params, prefix = prefix)
fun CommandSender.sendTranslatedWarning(key: TextComponent.Builder, vararg params: Component, prefix: Component?) = this.sendTranslated(key.warning(), *params, prefix = prefix)

fun CommandSender.sendError(message: String, prefix: Component? = null) = this.send(message.error(), prefix)
fun CommandSender.sendError(message: Component, prefix: Component? = null) = this.send(message.error(), prefix)
fun CommandSender.sendError(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.error(), prefix)

fun CommandSender.sendTranslatedError(key: String, vararg params: Component, prefix: Component?) = this.sendTranslated(key.error(), *params, prefix = prefix)
fun CommandSender.sendTranslatedError(key: Component, vararg params: Component, prefix: Component?) = this.sendTranslated(key.error(), *params, prefix = prefix)
fun CommandSender.sendTranslatedError(key: TextComponent.Builder, vararg params: Component, prefix: Component?) = this.sendTranslated(key.error(), *params, prefix = prefix)

fun CommandSender.sendDebug(message: String, prefix: Component? = null) = this.send(message.debug(), prefix)
fun CommandSender.sendDebug(message: Component, prefix: Component? = null) = this.send(message.debug(), prefix)
fun CommandSender.sendDebug(message: TextComponent.Builder, prefix: Component? = null) = this.send(message.debug(), prefix)

fun CommandSender.sendTranslatedDebug(key: String, vararg params: Component, prefix: Component?) = this.sendTranslated(key.debug(), *params, prefix = prefix)
fun CommandSender.sendTranslatedDebug(key: Component, vararg params: Component, prefix: Component?) = this.sendTranslated(key.debug(), *params, prefix = prefix)
fun CommandSender.sendTranslatedDebug(key: TextComponent.Builder, vararg params: Component, prefix: Component?) = this.sendTranslated(key.debug(), *params, prefix = prefix)
