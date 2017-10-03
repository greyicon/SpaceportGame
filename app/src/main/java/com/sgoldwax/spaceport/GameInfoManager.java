package com.sgoldwax.spaceport;

import android.widget.TextView;

import com.sgoldwax.spaceport.Enums.GameBuildings;
import com.sgoldwax.spaceport.Enums.GameResources;
import com.sgoldwax.spaceport.Exceptions.NotEnoughResourcesException;
import com.sgoldwax.spaceport.Exceptions.TooManyModulesException;

// Object used to store game info, such as resource stockpile, action to-do list, etc.
public class GameInfoManager {
    TextView logView;
    TextView resView;

    public ResourceManager resourceManager;
    public ModuleManager moduleManager;
    public PlanetManager planetManager;
    public PopulationManager populationManager;

    public GameInfoManager(TextView log, TextView res) {
        // Initialize text views
        logView = log;
        resView = res;

        // Initialize PlanetManager, add starting building
        planetManager = new PlanetManager();
        planetManager.addBuilding(GameBuildings.ALUMINUM, GameResources.ALUMINUM, 1);

        // Initialize ResourceManager, add starting resources
        resourceManager = new ResourceManager();
        resourceManager.addResource(GameResources.ALUMINUM, 10);

        // Initialize ModuleManager, adding starting modules
        moduleManager = new ModuleManager();

        // Initialize PopulationManager
        populationManager = new PopulationManager();
    }

    public void generateResources() {
        ResHolder gen = planetManager.getPlanetResourceGen();
        for (int i = 0; i < gen.size(); i++) {
            resourceManager.addResource(gen.resourcesList.get(i), gen.integerList.get(i));
        }
    }

    public void purchaseModule(Module mod) {
        try {
            resourceManager.resources.subtract(mod.cost);
            moduleManager.addModule(mod);
        } catch (NotEnoughResourcesException e) {
            log("Purchase failed: Not enough resources.");
        } catch (TooManyModulesException e) {
            log("Purchase failed: Too many modules. Build more Life Support Modules.");
        }
    }

    // Update the resource view text
    public void updateResView() {
        resView.setText(resourceManager.ToString());
    }

    // Send text to the log window
    private void log(CharSequence str) {
        logView.append(str + "\n\n");
    }


}