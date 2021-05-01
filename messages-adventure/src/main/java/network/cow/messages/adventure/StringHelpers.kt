package network.cow.messages.adventure

import dev.benedikt.localize.LocalizeService
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import network.cow.messages.core.Colors
import java.awt.Color

/**
 * @author Benedikt Wüller
 */

fun String.component(color: Color? = null) = this.component(color?.toTextColor())
fun String.component(color: NamedTextColor?) = this.component(color as TextColor?)
fun String.component(color: TextColor?) = Component.text(this).color(color)

fun String.comp() = this.component()

fun String.componentBuilder(color: Color = Colors.INFO) = this.componentBuilder(color.toTextColor())
fun String.componentBuilder(color: NamedTextColor) = this.componentBuilder(color as TextColor)
fun String.componentBuilder(color: TextColor) = Component.text().content(this).color(color)

fun String.prefix(prefix: Component) = prefix + " ｜ ".separator().decorate(TextDecoration.BOLD) + this
fun String.prefix(prefix: TextComponent.Builder) = prefix + " ｜ ".separator().decorate(TextDecoration.BOLD) + this

fun String.prefix(prefix: String, color: Color? = null) = this.prefix(prefix.component(color))
fun String.prefix(prefix: String, color: TextColor?) = this.prefix(prefix.component(color))
fun String.prefix(prefix: String, color: NamedTextColor?) = this.prefix(prefix.component(color))

fun String.boxed(color: Color? = null) = "[".component(color) + this + "]".component(color)
fun String.boxed(color: TextColor?) = "[".component(color) + this + "]".component(color)
fun String.boxed(color: NamedTextColor?) = "[".component(color) + this + "]".component(color)

fun String.chat() = this.component(Colors.CHAT)
fun String.corporate() = this.component(Colors.CORPORATE)

fun String.highlight() = this.component(Colors.HIGHLIGHT)
fun String.separator() = this.component(Colors.SEPARATOR)

fun String.info() = this.component(Colors.INFO)
fun String.success() = this.component(Colors.SUCCESS)
fun String.warning() = this.component(Colors.WARNING)
fun String.error() = this.component(Colors.ERROR)
fun String.debug() = this.component(Colors.DEBUG)

fun String.active() = this.component(Colors.ACTIVE)
fun String.inactive() = this.component(Colors.INACTIVE)

fun String.formatToComponent(vararg params: Component, color: Color? = null) : Component = this.component(color).format(*params)
fun String.formatToComponent(vararg params: Component, color: TextColor?) : Component = this.component(color).format(*params)
fun String.formatToComponent(vararg params: Component, color: NamedTextColor?) : Component = this.component(color).format(*params)

fun String.translateToComponent(locale: String, vararg params: Component, color: Color? = null) : Component = this.component(color).translate(locale, *params)
fun String.translateToComponent(locale: String, vararg params: Component, color: TextColor?) : Component = this.component(color).translate(locale, *params)
fun String.translateToComponent(locale: String, vararg params: Component, color: NamedTextColor?) : Component = this.component(color).translate(locale, *params)

fun String.translateToComponent(context: Any, vararg params: Component, color: Color? = null) : Component = this.component(color).translate(context, *params)
fun String.translateToComponent(context: Any, vararg params: Component, color: TextColor?) : Component = this.component(color).translate(context, *params)
fun String.translateToComponent(context: Any, vararg params: Component, color: NamedTextColor?) : Component = this.component(color).translate(context, *params)

fun String.translate(locale: String, vararg params: String) : String = LocalizeService.translate(locale, this, *params)

fun String.translate(context: Any, vararg params: String) : String {
    val locale = LocalizeService.getLocale(context)
    return this.translate(locale, *params)
}

fun String.space() = this.comp().space()
fun String.newline() = this.comp().newline()
fun String.newlines(amount: Int) = this.comp().newlines(amount)

fun String.gradient(from: Color, to: Color) = this.comp().gradient(from, to)
fun String.gradient(colors: Pair<Color, Color>) = this.comp().gradient(colors.first, colors.second)
