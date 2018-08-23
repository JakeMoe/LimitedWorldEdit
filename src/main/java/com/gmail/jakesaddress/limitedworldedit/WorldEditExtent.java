/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (WEExtent.java) is part of LimitedWorldEdit.
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

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.Vector2D;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.entity.BaseEntity;
import com.sk89q.worldedit.entity.Entity;
import com.sk89q.worldedit.extent.AbstractDelegateExtent;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldedit.world.biome.BaseBiome;
import java.util.HashSet;

public class WorldEditExtent extends AbstractDelegateExtent {

  private final HashSet<ClaimRegion> mask;

  WorldEditExtent(HashSet<ClaimRegion> mask, Extent extent) {
    super(extent);
    Main.getInstance().getLogger().info("In WorldEditExtent constructor");
    this.mask = mask;
  }

  @Override
  public boolean setBlock(Vector location, BaseBlock block) throws WorldEditException {
    Main.getInstance().getLogger().info("In WorldEditExtent.setBlock");
    return WorldEditManager.maskContains(this.mask, location.getBlockX(), location.getBlockY(), location.getBlockZ()) && super.setBlock(location, block);
  }

  @Override
  public Entity createEntity(Location location, BaseEntity entity) {
    Main.getInstance().getLogger().info("In WorldEditExtent.createEntity");
    if (WorldEditManager.maskContains(this.mask, location.getBlockX(), location.getBlockY(), location.getBlockZ())) {
      return super.createEntity(location, entity);
    }
    return null;
  }

  @Override
  public boolean setBiome(Vector2D position, BaseBiome biome) {
    Main.getInstance().getLogger().info("In WorldEditExtent.setBiome");
    return WorldEditManager.maskContains(this.mask, position.getBlockX(), position.getBlockZ()) && super.setBiome(position, biome);
  }

  @Override
  public BaseBlock getBlock(Vector location) {
    Main.getInstance().getLogger().info("In WorldEditExtent.getBlock");
    if (WorldEditManager.maskContains(this.mask, location.getBlockX(), location.getBlockY(), location.getBlockZ())) {
      return super.getBlock(location);
    }
    return WorldEditManager.AIR;
  }

}
