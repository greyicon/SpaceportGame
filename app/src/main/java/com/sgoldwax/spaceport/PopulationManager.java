package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameModules;
import com.sgoldwax.spaceport.Exceptions.NotEnoughPopException;

import java.util.Random;

public class PopulationManager {
    public int numPop;
    public int popCap;
    public int numVacantPop;

    private ModuleManager moduleManager;
    private PlanetManager planetManager;

    private final int NUM_POP_PER_MODULE = 10;

    public PopulationManager(ModuleManager mod, PlanetManager plt) {
        moduleManager = mod;
        planetManager = plt;
        numPop = 0;
        numVacantPop = 0;
    }

    public void addPopToHolder(PopHolder holder) throws NotEnoughPopException {
        if (numVacantPop <= 0) {throw new NotEnoughPopException();}
        numVacantPop--;
        holder.addPop();
    }

    public void removePopFromHolder(PopHolder holder) {
        numVacantPop++;
        holder.removePop();
    }

    public void updatePopCap() {
        popCap = NUM_POP_PER_MODULE * moduleManager.numModulesOfType(GameModules.POP_QUARTERS);
    }

    public PopHolder killPop() {
        PopHolder ret = null;
        if (numVacantPop > 0) {
            numVacantPop--;
            return ret;
        }
        Random rand = new Random();
        int rint = rand.nextInt() % numPop;
        for (Building bld : planetManager.buildings) {
            rint -= bld.pop;
            if (rint <= 0) {
                ret = bld;
                break;
            }
        }
        if (ret != null) {
            for (Module mod : moduleManager.modules) {
                rint -= mod.pop;
                if (rint <= 0) {
                    ret = mod;
                    break;
                }
            }
        }
        ret.removePop();
        return ret;
    }

    public int getBioCost() {
        return numPop;
    }
}
