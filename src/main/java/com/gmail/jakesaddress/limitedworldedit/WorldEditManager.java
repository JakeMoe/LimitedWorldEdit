/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (WorldEditManager.java) is part of LimitedWorldEdit.
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

import com.sk89q.worldedit.blocks.BaseBlock;
import java.util.HashSet;
import org.spongepowered.api.entity.living.player.Player;

public class WorldEditManager {

  public static final BaseBlock AIR = new BaseBlock(0, 0);

  public static boolean maskContains(HashSet<ClaimRegion> mask, int x, int y, int z) {
    for (ClaimRegion region : mask) {
      if (region.isIn(x, y, z)) {
        return true;
      }
    }
    return false;
  }

  public static boolean maskContains(HashSet<ClaimRegion> mask, int x, int z) {
    for (ClaimRegion region : mask) {
      if (region.isIn(x, z)) {
        return true;
      }
    }
    return false;
  }

  public static HashSet<ClaimRegion> getMask(Player player) {
    HashSet<ClaimRegion> regions = new HashSet<>();
    regions.addAll(Main.getClaimApi().getRegions(player));
    return regions;
  }

}
