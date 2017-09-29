package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameModules;
import com.sgoldwax.spaceport.Enums.GameResources;

public class Module {
    public GameModules type;
    public ResHolder cost;

    public Module(GameModules mod) {
        this.type = mod;
        cost = initCost(mod);
    }

    private ResHolder initCost(GameModules mod) {
        ResHolder ret = new ResHolder();
        switch (mod) {
            case LIFE_SUPPORT:
                ret.add(GameResources.ALUMINUM, 200);
                ret.add(GameResources.OXYGEN, 200);
                break;
            case POP_QUARTERS:
                ret.add(GameResources.ALUMINUM, 300);
                ret.add(GameResources.BIOMASS, 150);
        }
        return ret;
    }

}
