# LimitedWorldEdit

## Description

LimitedWorldEdit is a Minecraft Sponge plugin that allows a player to use WorldEdit within their own claim(s), and will prevent it from applying changes outside the claiimed area.

LimitedWorldEdit is a port of [James137137's LimitedWorldEdit](https://github.com/James137137/LimitedWorldEdit) for Bukkit to Sponge, and was written for the [Lolnet](https://www.lolnet.co.nz) creative server.

## Dependencies

LimitedWorldEdit requires:
* WorldEdit
* GriefPrevention

## Installation and configuration

Simply copy the compiled jar file into your server's mods folder, and away you go. No configuration required.

## Copyright

LimitedWorldEdit is available under the terms of the GPL v3 license.

![GPLv3 Logo](gplv3-88x31.png)

## Version History
* v0.1 - 17 Aug 2018 - Jake Moe
  * Initial Commit
* v0.2 - 19 Aug 2018 - Jake Moe
  * First compile
* v0.3 - 20 Aug 2018 - Jake Moe
  * Compiles, loads, and detects GP and WE plugins. Does not seem to fire WE event.
* v0.4 - 21 Aug 2018 - Jake Moe
  * Added @Subscribe to WorldEdit event handler
* v0.5 - 23 Aug 2018 - Jake Moe
  * Added additional logging to assist with debugging
  * Tidied up this readme