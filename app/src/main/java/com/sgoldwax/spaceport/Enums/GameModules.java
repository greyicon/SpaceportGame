package com.sgoldwax.spaceport.Enums;

import com.sgoldwax.spaceport.Exceptions.MissingObjectException;

public enum GameModules {
    LIFE_SUPPORT,
    ;

    public String ToString(GameModules mod) throws MissingObjectException {
        switch(mod) {
            case LIFE_SUPPORT:
                return "Life Support Module";
        }
        throw new MissingObjectException();
    }
}
