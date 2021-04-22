package network.cow.messages.adventure

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.event.ClickEvent
import network.cow.messages.core.Colors

/**
 * @author Benedikt Wüller
 */

operator fun Component.plus(string: String) = this.append(string.component(this.color() ?: Colors.INFO.toTextColor()))
operator fun TextComponent.Builder.plus(string: String) = this.append(string.component(this.build().color() ?: Colors.INFO.toTextColor()))

operator fun Component.plus(component: Component) = this.append(component)
operator fun Component.plus(component: TextComponent.Builder) = this.append(component)

operator fun TextComponent.Builder.plus(component: Component) = this.append(component)
operator fun TextComponent.Builder.plus(component: TextComponent.Builder) = this.append(component)

fun test(): Component {
    val acceptButton = "[Yes]".active().clickEvent(ClickEvent.runCommand("test"))
    val denyButton = "[No]".inactive().clickEvent(ClickEvent.runCommand("test"))
    return ("Are you sure you want to do this?".comp() + " " + acceptButton + " " + denyButton + " - ".separator() + "This will delete all data irreversibly.").warning()
}
