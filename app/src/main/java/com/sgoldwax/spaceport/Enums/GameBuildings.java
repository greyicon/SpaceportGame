package com.sgoldwax.spaceport.Enums;

import com.sgoldwax.spaceport.Exceptions.MissingObjectException;

public enum GameBuildings {
    ALUMINUM,
    ;

    public String toString(GameBuildings bld) throws MissingObjectException {
        switch(bld) {
            case ALUMINUM:
                return "Aluminum Refinery";
        }
        throw new MissingObjectException();
    }
}
