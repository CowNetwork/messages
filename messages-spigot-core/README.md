# messages-adventure

Provides the `messages-adventure` module as spigot plugin and provides additional helpers.

## Usage

### Broadcasts

```kotlin
Bukkit.getServer().broadcast(component)
Bukkit.getServer().broadcastInfo(component)
Bukkit.getServer().broadcastSuccess(component)
Bukkit.getServer().broadcastWarning(component)
Bukkit.getServer().broadcastError(component)
Bukkit.getServer().broadcastDebug(component)
```

### Player messages

```kotlin
player.sendInfo(component)
player.sendSuccess(component)
player.sendWarning(component)
player.sendError(component)
player.sendDebug(component)
```

See [messages-adventure usage](../messages-adventure/README.md) for more information.
