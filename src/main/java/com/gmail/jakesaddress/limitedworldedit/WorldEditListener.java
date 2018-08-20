/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (WorldEditListener.java) is part of LimitedWorldEdit.
 *
 * LimitedWorldEdit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LimitedWorldEdit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LimitedWorldEdit.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.gmail.jakesaddress.limitedworldedit;

import com.sk89q.worldedit.event.extent.EditSessionEvent;
import com.sk89q.worldedit.extension.platform.Actor;
import java.util.HashSet;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;

public class WorldEditListener {

  public  void onEditSession(EditSessionEvent event) {

    Main.getInstance().getLogger().info("Checking edit perms");

    Actor actor = event.getActor();
    if (actor == null || !actor.isPlayer()) {
      Main.getInstance().getLogger().info("Failed player check, skipping");
      return;
    }

    Player player = Sponge.getServer().getPlayer(actor.getUniqueId()).get();
    if (player.hasPermission("LimitedWorldEdit.bypass")) {
      Main.getInstance().getLogger().info("Player has LimitedWorldEdit.bypass permission node");
      return;
    }

    Main.getInstance().getLogger().info("Applying limits");
    HashSet<ClaimRegion> mask = WorldEditManager.getMask(player);
    event.setExtent(new WorldEditExtent(mask, event.getExtent()));

  }

}
