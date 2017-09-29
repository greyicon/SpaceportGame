package com.sgoldwax.spaceport.Enums;

import com.sgoldwax.spaceport.Exceptions.MissingObjectException;

public enum GameBuildings {
    ALUMINUM, OXYGEN, BIOMASS,
    ;

    public String ToString(GameBuildings bld) throws MissingObjectException {
        switch(bld) {
            case ALUMINUM:
                return "Aluminum Refinery";
            case OXYGEN:
                return "Atmospheric Condensor";
            case BIOMASS:
                return "Hydroponics Farm";
        }
        throw new MissingObjectException();
    }
}
