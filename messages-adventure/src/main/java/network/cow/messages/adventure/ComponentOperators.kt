package network.cow.messages.adventure

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.event.ClickEvent
import network.cow.messages.core.Colors

/**
 * @author Benedikt Wüller
 */

operator fun Component.plus(string: String) = this.append(string.comp())
operator fun TextComponent.Builder.plus(string: String) = this.append(string.comp())

operator fun Component.plus(component: Component) = this.append(component)
operator fun Component.plus(component: TextComponent.Builder) = this.append(component)

operator fun TextComponent.Builder.plus(component: Component) = this.append(component)
operator fun TextComponent.Builder.plus(component: TextComponent.Builder) = this.append(component)
