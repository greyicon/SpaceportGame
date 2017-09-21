package com.sgoldwax.spaceport.Enums;

import com.sgoldwax.spaceport.Exceptions.MissingObjectException;

public enum GameResources {
    ALUMINUM, OXYGEN, BIOMASS, HYDROGEN,
    ;

    public String toString(GameResources res) throws MissingObjectException{
        switch(res) {
            case ALUMINUM:
                return "Aluminum";
        }
        throw new MissingObjectException();
    }

    public String getDescription(GameResources res) throws MissingObjectException{
        switch(res) {
            case ALUMINUM:
                return "Light and durable, it's the most basic building resource. Required for most buildings and modules.";
        }
        throw new MissingObjectException();
    }
}
