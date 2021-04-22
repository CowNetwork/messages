package network.cow.messages.adventure

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

enum class CascadeType {
    NONE,
    DEEP_ONLY_NULL,
    DEEP_ALL
}

fun Component.cascadeColor(color: TextColor, type: CascadeType = CascadeType.DEEP_ONLY_NULL) : Component {
    if (type == CascadeType.NONE) return this
    val mainColor = if (this.color() == null || type == CascadeType.DEEP_ALL) color else this.color()
    return this.color(mainColor).children(this.children().map { it.cascadeColor(color, type) })
}

fun TextComponent.Builder.cascadeColor(color: TextColor, type: CascadeType = CascadeType.DEEP_ONLY_NULL) : TextComponent.Builder {
    return (this.build().cascadeColor(color, type) as TextComponent).toBuilder()
}

fun Component.prefix(prefix: Component) = prefix + " ｜ ".separator().decorate(TextDecoration.BOLD) + this
fun Component.prefix(prefix: TextComponent.Builder) = prefix + " ｜ ".separator().decorate(TextDecoration.BOLD) + this

fun Component.prefix(prefix: String, color: Color? = null) = this.prefix(prefix.component(color))
fun Component.prefix(prefix: String, color: TextColor?) = this.prefix(prefix.component(color))
fun Component.prefix(prefix: String, color: NamedTextColor?) = this.prefix(prefix.component(color))

fun Component.boxed(color: Color? = null) = "[".component(color) + this + "]".component(color)
fun Component.boxed(color: TextColor?) = "[".component(color) + this + "]".component(color)
fun Component.boxed(color: NamedTextColor?) = "[".component(color) + this + "]".component(color)

fun Component.prepend(prefix: Component) = prefix + this
fun Component.prepend(prefix: TextComponent.Builder) = prefix + this

fun Component.prepend(prefix: String, color: Color? = null) = prefix.component(color) + this
fun Component.prepend(prefix: String, color: TextColor?) = prefix.component(color) + this
fun Component.prepend(prefix: String, color: NamedTextColor?) = prefix.component(color) + this

fun Component.chat(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.CHAT.toTextColor(), cascadeType)

fun Component.highlight(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.HIGHLIGHT.toTextColor(), cascadeType)
fun Component.separator(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SEPARATOR.toTextColor(), cascadeType)

fun Component.info(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INFO.toTextColor(), cascadeType)
fun Component.success(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SUCCESS.toTextColor(), cascadeType)
fun Component.warning(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.WARNING.toTextColor(), cascadeType)
fun Component.error(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ERROR.toTextColor(), cascadeType)
fun Component.debug(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.DEBUG.toTextColor(), cascadeType)

fun Component.active(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ACTIVE.toTextColor(), cascadeType)
fun Component.inactive(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INACTIVE.toTextColor(), cascadeType)

fun TextComponent.Builder.chat(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.CHAT.toTextColor(), cascadeType)

fun TextComponent.Builder.highlight(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.HIGHLIGHT.toTextColor(), cascadeType)
fun TextComponent.Builder.separator(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SEPARATOR.toTextColor(), cascadeType)

fun TextComponent.Builder.info(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INFO.toTextColor(), cascadeType)
fun TextComponent.Builder.success(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SUCCESS.toTextColor(), cascadeType)
fun TextComponent.Builder.warning(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.WARNING.toTextColor(), cascadeType)
fun TextComponent.Builder.error(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ERROR.toTextColor(), cascadeType)
fun TextComponent.Builder.debug(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.DEBUG.toTextColor(), cascadeType)

fun TextComponent.Builder.active(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ACTIVE.toTextColor(), cascadeType)
fun TextComponent.Builder.inactive(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INACTIVE.toTextColor(), cascadeType)

fun TextComponent.format(vararg params: Component) : Component {
    val format = this.content()
    val color = this.color()

    val placeholderRegex = Regex("%(\\d+)\\\$s?")
    val placeholders = placeholderRegex.findAll(format).toList()
    val sections = format.split(placeholderRegex)

    var component = Component.empty()
    sections.forEachIndexed { index, section ->
        component = when {
            section.isEmpty() -> component
            else -> component.append(Component.text(section).color(color))
        }

        val placeholder = placeholders.getOrNull(index) ?: return@forEachIndexed
        val parameterIndex = placeholder.groupValues[1].toInt() - 1

        component = when {
            parameterIndex < 0 || parameterIndex > params.lastIndex -> component.append(Component.text(placeholder.groupValues.first()))
            else -> component.append(params[parameterIndex])
        }
    }

    return component
}

fun Component.space() = this.append(Component.space())
fun Component.newline() = this.append(Component.newline())
fun Component.newlines(amount: Int) : Component {
    var result = this
    repeat(amount) { result = result.newline() }
    return result
}

fun TextComponent.Builder.space() = this.append(Component.space())
fun TextComponent.Builder.newline() = this.append(Component.newline())
fun TextComponent.Builder.newlines(amount: Int) : TextComponent.Builder {
    var result = this
    repeat(amount) { result = result.newline() }
    return result
}

fun space() = Component.space()
fun newline() = Component.newline()
fun newlines(amount: Int) : Component {
    var result: Component = Component.empty()
    repeat(amount) { result = result.newline() }
    return result
}
