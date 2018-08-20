/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (ClaimApi.java) is part of LimitedWorldEdit.
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

package com.gmail.jakesaddress.limitedworldedit.claim;

import com.gmail.jakesaddress.limitedworldedit.ClaimRegion;
import java.util.List;
import org.spongepowered.api.entity.living.player.Player;

public interface ClaimApi {

  List<ClaimRegion> getRegions(Player player);

}
