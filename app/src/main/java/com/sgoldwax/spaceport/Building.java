package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameBuildings;
import com.sgoldwax.spaceport.Enums.GameResources;

// Object for a planetary building, generates resources every second
public class Building implements PopHolder {
    public GameBuildings buildingType;
    public GameResources genType;
    public int level;
    public int pop;

    public Building(GameBuildings type, GameResources res, int i) {
        buildingType = type;
        genType = res;
        level = 1;
        pop = 0;
    }

    public void upgradeBuilding() {
        level++;
    }

    public int getGenAmount() {
        return (int) Math.pow(2 + Math.floor(pop / 3), level - 1);
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

    @Override
    public void removePop() {
        pop--;
    }

    @Override
    public void addPop() {
        pop++;
    }
}
