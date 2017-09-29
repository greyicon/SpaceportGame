package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameModules;

public class Module {
    public GameModules type;
    public ResHolder cost;

    public Module(GameModules mod, ResHolder cost) {
        this.type = mod;
        this.cost = cost;
    }

}
