# messages-adventure

Implementation of the `messages-core` module for the component system used in velocity and spigot.

## Usage

### Convert `java.awt.Color` to `TextColor`

```kotlin
val color = Color(255, 151, 216)
val textColor = color.toTextColor()
val namedTextColor = color.toNamedTextColor() // Matches the closest NamedTextColor
```

### Colors

Colors can be cascaded to child components using the `cascadeColor` helper method.

```kotlin
// Set the colors for all components (which do not have a color set manually).
val result = Component.text("first")
    .append(Component.text("second"))
    .append(Component.text("third"))
    .cascadeColor(Color.RED)

val result = Component.text("first").color(Color.BLUE) // this component will keep it's color.
    .append(Component.text("second"))
    .append(Component.text("third"))
    .cascadeColor(Color.RED)

// Set all colors, disregarding manually set ones.
val result = Component.text("first").color(Color.BLUE)
    .append(Component.text("second"))
    .append(Component.text("third"))
    .cascadeColor(Color.RED, CascadeType.DEEP_ALL)
```

For each color constant defined in the global `Colors` object, there is a helper method for strings, components and component builders to apply the
corresponding color. Those support the optional `CascadeType` parameter (see above).

```kotlin
val result = "This is a warning.".warning()
val result = ("This is ".component() + "a composed warning.").warning()
```

### Component Building

You may convert any string to a component using the `component` or `comp` helpers.

```kotlin
val component = "This is a string".comp()
val anotherComponent = "This is another string".component(color) // Instantly applies the given color.
```

Instead of using the `append` method, you can use the overloaded `+` operator using strings, components and component builders. Strings are
implicitly converted to a component with the same color as the previous component.

```kotlin
val result = "This component ".component(Color.RED) + "is composed " + Component.text("of three components.")

// the above code yields the same result as the following

val result = Component.text("This component ").color(Color.RED)
    .append(Component.text("is composed ").color(Color.RED))
    .append(Component.text("of three components."))
```

In addition to the `append` method already provided by the component system, this library provides two additional methods for prepending messages.
Those support strings, components and component builders.

```kotlin
val result = Component.text("some component").prepend("Prefix: ") // = "Prefix: some component"
val result = Component.text("another component").prefix("Prefix") // = "Prefix | some component" (automatically injects a separator)
```

There are also space and newline helpers. Again, these helper methods are provided for strings, components and component builders.

```kotlin
component + space() + anotherComponent
component.space().append(anotherComponent)

component + newline() + anotherComponent
component.newline().append(anotherComponent)

component + newlines(2) + anotherComponent
component.newlines(2).append(anotherComponent)
```
