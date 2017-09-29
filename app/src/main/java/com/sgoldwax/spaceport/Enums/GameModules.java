package com.sgoldwax.spaceport.Enums;

import com.sgoldwax.spaceport.Exceptions.MissingObjectException;

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
}
