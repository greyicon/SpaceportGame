package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameBuildings;
import com.sgoldwax.spaceport.Enums.GameResources;

import java.util.ArrayList;
import java.util.List;

// Object to store all Building objects, calculates passive resource generation
public class PlanetManager {
    public List<Building> buildings;

    public PlanetManager() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(GameBuildings type, GameResources res, int i) {
        Building temp = new Building(type, res, i);
        buildings.add(temp);
    }

    public void addBuilding(Building bld) {
        buildings.add(bld);
    }

    public void upgradeBuilding(Building bld) {
        bld.upgradeBuilding();
        bld.doubleGenAmount();
    }

    public ResHolder getPlanetResourceGen() {
        ResHolder ret = new ResHolder();
        for (Building b : buildings) {
            ret.add(b.genType, b.genAmount);
        }
        return ret;
    }

    public int getResourceGenOfType(GameResources res) {
        int ret = 0;
        for (Building b : buildings) {
            if (b.genType.equals(res)) {
                ret += b.genAmount;
            }
        }
        return ret;
    }

    public String toString() {
        String str = "";
        for (Building b : buildings) {
            str += b.toString() + "\n";
        }
        return str;
    }


}
