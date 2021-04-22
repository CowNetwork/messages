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
    if (type == CascadeType.NONE) return this.color(color)
    return this.color(color).children(this.children().map {
        if (type == CascadeType.DEEP_ONLY_NULL && it.color() != null) return@map it
        it.cascadeColor(color, type)
    })
}

fun TextComponent.Builder.cascadeColor(color: TextColor, type: CascadeType = CascadeType.DEEP_ONLY_NULL) : TextComponent.Builder {
    return (this.build().cascadeColor(color, type) as TextComponent).toBuilder()
}

fun Component.prefix(prefix: Component) = prefix + " ｜ ".separator().decorate(TextDecoration.BOLD) + this
fun Component.prefix(prefix: TextComponent.Builder) = prefix + " ｜ ".separator().decorate(TextDecoration.BOLD) + this

@JvmOverloads
fun Component.prefix(prefix: String, color: Color? = null) = this.prefix(prefix.component(color))
fun Component.prefix(prefix: String, color: TextColor?) = this.prefix(prefix.component(color))
fun Component.prefix(prefix: String, color: NamedTextColor?) = this.prefix(prefix.component(color))

@JvmOverloads
fun Component.boxed(color: Color? = null) = "[".component(color) + this + "]".component(color)
fun Component.boxed(color: TextColor?) = "[".component(color) + this + "]".component(color)
fun Component.boxed(color: NamedTextColor?) = "[".component(color) + this + "]".component(color)

@JvmOverloads fun Component.chat(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.CHAT.toTextColor(), cascadeType)

@JvmOverloads fun Component.highlight(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.HIGHLIGHT.toTextColor(), cascadeType)
@JvmOverloads fun Component.separator(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SEPARATOR.toTextColor(), cascadeType)

@JvmOverloads fun Component.info(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INFO.toTextColor(), cascadeType)
@JvmOverloads fun Component.success(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SUCCESS.toTextColor(), cascadeType)
@JvmOverloads fun Component.warning(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.WARNING.toTextColor(), cascadeType)
@JvmOverloads fun Component.error(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ERROR.toTextColor(), cascadeType)
@JvmOverloads fun Component.debug(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.DEBUG.toTextColor(), cascadeType)

@JvmOverloads fun Component.active(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ACTIVE.toTextColor(), cascadeType)
@JvmOverloads fun Component.inactive(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INACTIVE.toTextColor(), cascadeType)

@JvmOverloads fun TextComponent.Builder.chat(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.CHAT.toTextColor(), cascadeType)

@JvmOverloads fun TextComponent.Builder.highlight(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.HIGHLIGHT.toTextColor(), cascadeType)
@JvmOverloads fun TextComponent.Builder.separator(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SEPARATOR.toTextColor(), cascadeType)

@JvmOverloads fun TextComponent.Builder.info(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INFO.toTextColor(), cascadeType)
@JvmOverloads fun TextComponent.Builder.success(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.SUCCESS.toTextColor(), cascadeType)
@JvmOverloads fun TextComponent.Builder.warning(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.WARNING.toTextColor(), cascadeType)
@JvmOverloads fun TextComponent.Builder.error(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ERROR.toTextColor(), cascadeType)
@JvmOverloads fun TextComponent.Builder.debug(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.DEBUG.toTextColor(), cascadeType)

@JvmOverloads fun TextComponent.Builder.active(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.ACTIVE.toTextColor(), cascadeType)
@JvmOverloads fun TextComponent.Builder.inactive(cascadeType: CascadeType = CascadeType.DEEP_ONLY_NULL) = this.cascadeColor(Colors.INACTIVE.toTextColor(), cascadeType)

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
