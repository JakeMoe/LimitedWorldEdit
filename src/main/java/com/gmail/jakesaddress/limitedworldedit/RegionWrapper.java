/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (RegionWrapper.java) is part of LimitedWorldEdit.
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

public class RegionWrapper {
  public final int minX;
  public final int maxX;
  public final int minY;
  public final int maxY;
  public final int minZ;
  public final int maxZ;

  public RegionWrapper(int minX, int maxX, int minZ, int maxZ) {
    this.maxX = maxX;
    this.minX = minX;
    this.maxZ = maxZ;
    this.minZ = minZ;
    this.minY = 0;
    this.maxY = 256;
  }

  public RegionWrapper(int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
    this.maxX = maxX;
    this.minX = minX;
    this.maxZ = maxZ;
    this.minZ = minZ;
    this.minY = minY;
    this.maxY = maxY;
  }

  public boolean isIn(int x, int y, int z) {
    return x >= this.minX && x <= this.maxX && z >= this.minZ && z <= this.maxZ && y >= this.minY && y <= this.maxY;
  }

  public boolean isIn(int x, int z) {
    return x >= this.minX && x <= this.maxX && z >= this.minZ && z <= this.maxZ;
  }

}
