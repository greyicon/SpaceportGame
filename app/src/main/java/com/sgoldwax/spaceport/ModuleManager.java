package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameModules;
import com.sgoldwax.spaceport.Exceptions.TooManyModulesException;

import java.util.ArrayList;
import java.util.List;

// Object for storing all Module objects
public class ModuleManager {
    public List<GameModules> modules;
    int modCap;

    public ModuleManager() {
        modules = new ArrayList<GameModules>();
        modules.add(GameModules.LIFE_SUPPORT);
        modCap = 3;
    }

    public void addModule(GameModules mod) throws TooManyModulesException {
        if (modules.size() < modCap) {
            modules.add(mod);
            return;
        }
        throw new TooManyModulesException();
    }


}
