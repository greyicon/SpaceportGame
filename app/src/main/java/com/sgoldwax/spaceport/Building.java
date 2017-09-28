package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameBuildings;
import com.sgoldwax.spaceport.Enums.GameResources;

// Object for a planetary building, generates resources every second
public class Building {
    public GameBuildings buildingType;
    public GameResources genType;
    public int genAmount;
    public int level;

    public Building(GameBuildings type, GameResources res, int i) {
        buildingType = type;
        genType = res;
        genAmount = i;
        level = 1;
    }

    public void upgradeBuilding() {
        level++;
    }

    public void setGenAmount(int i) {
        genAmount = i;
    }

    public void doubleGenAmount() {
        genAmount *= 2;
    }

    public String toString() {
        return buildingType.toString() + " - lvl " + level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Building building = (Building) o;

        if (level != building.level) return false;
        return buildingType == building.buildingType;

    }

    @Override
    public int hashCode() {
        int result = buildingType.hashCode();
        result = 31 * result + level;
        return result;
    }
}
