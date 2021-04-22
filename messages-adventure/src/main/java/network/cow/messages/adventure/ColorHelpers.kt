package network.cow.messages.adventure

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import java.awt.Color

/**
 * @author Benedikt Wüller
 */

fun Color.toTextColor() = TextColor.color(this.red, this.green, this.blue)

fun Color.toNamedTextColor() = NamedTextColor.nearestTo(TextColor.color(this.toTextColor()))
