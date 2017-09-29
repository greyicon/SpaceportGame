package com.sgoldwax.spaceport.Enums;

import com.sgoldwax.spaceport.Exceptions.MissingObjectException;

public enum GameResources {
    ALUMINUM, OXYGEN, BIOMASS, HYDROGEN,
    ;

    public String ToString(GameResources res) throws MissingObjectException{
        switch(res) {
            case ALUMINUM:
                return "Aluminum";
            case OXYGEN:
                return "Oxygen";
        }
        throw new MissingObjectException();
    }

    public String getDescription(GameResources res) throws MissingObjectException{
        switch(res) {
            case ALUMINUM:
                return "Light and durable, it's the most basic building resource. Required for most buildings and modules.";
            case OXYGEN:
                return "";
        }
        throw new MissingObjectException();
    }
}
