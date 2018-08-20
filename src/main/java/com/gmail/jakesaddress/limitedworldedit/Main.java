/*
 * Copyright 17 August 2018 John Moe
 *
 * This file (Main.java) is part of LimitedWorldEdit.
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

import com.gmail.jakesaddress.limitedworldedit.claim.ClaimApi;
import com.gmail.jakesaddress.limitedworldedit.claim.GriefPreventionClaimApi;
import com.sk89q.worldedit.WorldEdit;
import javax.inject.Inject;
import me.ryanhamshire.griefprevention.GriefPrevention;
import me.ryanhamshire.griefprevention.api.GriefPreventionApi;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GamePostInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

@Plugin(authors = {
    "Cluracan",
    "James137137"
  },
  dependencies = {
    @Dependency(id = "griefprevention"),
    @Dependency(id = "worldedit-core"),
    @Dependency(id = "worldedit-sponge")
  },
  description = "LimitedWorldEdit for Sponge",
  id = "limitedworldedit",
  name = "LimitedWorldEdit",
  version = "0.2"
)
public class Main {

  private static final String project = "LimitedWorldEdit";
  private static final String version = "0.2";

  private static GriefPreventionApi griefPreventionApi;
  private static ClaimApi claimApi;

  @Inject
  private static Logger logger;

  @Listener
  public void onGameConstruction(GameConstructionEvent event) {
    logInfo(project + " " + version + " starting");
  }

  @Listener
  public void onGamePostInitialization(GamePostInitializationEvent event) {

    if (!Sponge.getPluginManager().getPlugin("griefprevention").isPresent()) {
      logInfo("GtriefPrevention not found, this plugin requires GriefPrevention");
    } else {
      griefPreventionApi = GriefPrevention.getApi();
      claimApi = new GriefPreventionClaimApi();
    }

    if (!Sponge.getPluginManager().getPlugin("worldedit-core").isPresent()) {
      logInfo("WorldEdit-Core not found, this plugin required WorldEdit-Core");
    }

    if (!Sponge.getPluginManager().getPlugin("worldedit-sponge").isPresent()) {
      logInfo("WorldEdit-Sponge not found, this plugin requires WorldEdit-Sponge");
    }

    WorldEdit.getInstance().getEventBus().register(new WorldEditListener());

  }

  @Listener
  public void onGameStoppingEvent(GameStoppingEvent event) {
    logInfo(project + " " + version + " stopping");
  }

  static void logInfo(String message) {
    logger.info("[" + project + "] " + message);
  }

  static ClaimApi getClaimApi() {
    return claimApi;
  }

  public static GriefPreventionApi getGriefPreventionApi() {
    return griefPreventionApi;
  }

  static Logger getLogger() {
    return logger;
  }

}
