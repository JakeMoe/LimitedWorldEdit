/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (ClaimRegion.java) is part of LimitedWorldEdit.
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

public class ClaimRegion {
  private final int minX;
  private final int maxX;
  private final int minY;
  private final int maxY;
  private final int minZ;
  private final int maxZ;

  public ClaimRegion(int minX, int maxX, int minZ, int maxZ) {
    this.maxX = maxX;
    this.minX = minX;
    this.maxZ = maxZ;
    this.minZ = minZ;
    this.minY = 0;
    this.maxY = 256;
  }

  public ClaimRegion(int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
    this.maxX = maxX;
    this.minX = minX;
    this.maxZ = maxZ;
    this.minZ = minZ;
    this.minY = minY;
    this.maxY = maxY;
  }

  boolean isIn(int x, int y, int z) {
    return x >= this.minX && x <= this.maxX && z >= this.minZ && z <= this.maxZ && y >= this.minY && y <= this.maxY;
  }

  boolean isIn(int x, int z) {
    return x >= this.minX && x <= this.maxX && z >= this.minZ && z <= this.maxZ;
  }

}
