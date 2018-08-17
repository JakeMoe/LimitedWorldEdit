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

import com.gmail.jakesaddress.limitedworldedit.hooks.API;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "limitedworldedit", name = "LimitedWorldEdit", version = "0.1", description = "LimitedWorldEdit for Sponge")
public class Main {

  @Inject
  private Logger logger;

  private static API api;

  private static Main instance;

  @Listener
  public void onGameConstruction(GameConstructionEvent event) {
    instance = this;
  }

  @Listener
  public void onGamePreInitialization(GamePreInitializationEvent event) {
//    configuration = new Configuration(getConfigLoader());
//    getConfiguration().load();
  }

  @Listener
  public void onGameInitialization(GameInitializationEvent event) {
    Sponge.getEventManager().registerListeners(this, new EventListeners());
  }

  @Listener
  public void onGameStoppingEvent(GameStoppingEvent event) {
//    getConfiguration().save();
  }

  static API getApi() {
    return api;
  }

  Main getInstance() {
    return this;
  }

  Logger getLogger() {
    return logger;
  }

}
