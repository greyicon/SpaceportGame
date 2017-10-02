package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameModules;
import com.sgoldwax.spaceport.Enums.GameResources;

public class Module implements PopHolder{
    public GameModules type;
    public ResHolder cost;
    public int pop;
    public int popCap;

    public Module(GameModules mod) {
        this.type = mod;
        cost = mod.getModCost();
        pop = 0;
        popCap = type.getPopCap();
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
