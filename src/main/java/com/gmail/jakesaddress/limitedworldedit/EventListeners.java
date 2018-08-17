/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (EventListeners.java) is part of LimitedWorldEdit.
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
import org.spongepowered.api.event.Listener;

public class EventListeners {

  @Listener
  void onEditSession(EditSessionEvent event) {

    Actor actor = event.getActor();
    if (actor == null || !actor.isPlayer()) {
      return;
    }

    Player player = Sponge.getServer().getPlayer(actor.getUniqueId()).get();
    if (player.hasPermission("LimitedWorldEdit.bypass")) {
      return;
    }

    HashSet<RegionWrapper> mask = WEManager.getMask(player);
    event.setExtent(new WEExtent(mask, event.getExtent()));

  }

}
