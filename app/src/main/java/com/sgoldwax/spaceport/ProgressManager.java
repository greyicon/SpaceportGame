package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameBuildings;
import com.sgoldwax.spaceport.Enums.GameModules;

import java.util.ArrayList;
import java.util.List;

public class ProgressManager {
    public List<GameModules> availableModules;
    public List<GameBuildings> availableBuildings;

    public ProgressManager() {
        availableModules = new ArrayList<>();
        availableBuildings = new ArrayList<>();
    }

    public void addAvailableModule(GameModules mod) {
        availableModules.add(mod);
    }

    public void addAvailableBuilding(GameBuildings bld) {
        availableBuildings.add(bld);
    }

    // On start method: sets initial progress state
    private void init() {
        addAvailableBuilding(GameBuildings.ALUMINUM);
        addAvailableBuilding(GameBuildings.OXYGEN);
        addAvailableModule(GameModules.LIFE_SUPPORT);
    }
}
