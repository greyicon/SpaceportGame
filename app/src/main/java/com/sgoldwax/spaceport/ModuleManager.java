package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameModules;
import com.sgoldwax.spaceport.Exceptions.TooManyModulesException;

import java.util.ArrayList;
import java.util.List;

// Object for storing all Module objects
public class ModuleManager {
    public List<Module> modules;
    public int modCap;

    public ModuleManager() {
        modules = new ArrayList<Module>();
        modules.add(new Module(GameModules.LIFE_SUPPORT));
        modCap = 3;
    }

    public void addModule(Module mod) throws TooManyModulesException {
        if (modules.size() < modCap) {
            modules.add(mod);
            return;
        }
        throw new TooManyModulesException();
    }

    public int numModulesOfType(GameModules mod) {
        int i = 0;
        for (Module m : modules) {
            if (m.type.equals(mod)) {
                i++;
            }
        }
        return i;
    }
}
