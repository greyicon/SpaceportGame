package com.sgoldwax.spaceport.Enums;

import com.sgoldwax.spaceport.Exceptions.MissingObjectException;
import com.sgoldwax.spaceport.ResHolder;

public enum GameModules {
    LIFE_SUPPORT, POP_QUARTERS,
    ;

    public String ToString(GameModules mod) throws MissingObjectException {
        switch(mod) {
            case LIFE_SUPPORT:
                return "Life Support Module";
            case POP_QUARTERS:
                return "Population Quarters";
        }
        throw new MissingObjectException();
    }

    public ResHolder getModCost() {
        ResHolder ret = new ResHolder();
        switch (this) {
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

    public int getPopCap() {
        int i = 0;
        switch (this) {
            case LIFE_SUPPORT:
                break;
            case POP_QUARTERS:
                break;
        }
        return i;
    }
}
