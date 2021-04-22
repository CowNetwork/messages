package network.cow.messages.adventure

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import network.cow.messages.core.Colors
import java.awt.Color

/**
 * @author Benedikt Wüller
 */

@JvmOverloads
fun String.component(color: Color? = null) = this.component(color?.toTextColor())
fun String.component(color: NamedTextColor?) = this.component(color as TextColor?)
fun String.component(color: TextColor?) = Component.text(this).color(color)

fun String.comp() = this.component()

@JvmOverloads
fun String.componentBuilder(color: Color = Colors.INFO) = this.componentBuilder(color.toTextColor())
fun String.componentBuilder(color: NamedTextColor) = this.componentBuilder(color as TextColor)
fun String.componentBuilder(color: TextColor) = Component.text().content(this).color(color)

fun String.chat() = this.component(Colors.CHAT)

fun String.highlight() = this.component(Colors.HIGHLIGHT)
fun String.separator() = this.component(Colors.SEPARATOR)

fun String.info() = this.component(Colors.INFO)
fun String.success() = this.component(Colors.SUCCESS)
fun String.warning() = this.component(Colors.WARNING)
fun String.error() = this.component(Colors.ERROR)
fun String.debug() = this.component(Colors.DEBUG)

fun String.active() = this.component(Colors.ACTIVE)
fun String.inactive() = this.component(Colors.INACTIVE)
