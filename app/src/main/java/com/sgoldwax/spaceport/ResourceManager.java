package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameResources;

// Object for storing, receiving, and spending resources
public class ResourceManager {
    private final String TAG = "RESOURCE_MANAGER";

    public ResHolder resources;

    public ResourceManager() {
        resources = new ResHolder();
    }

    public void addResource(GameResources res, int i) {
        resources.add(res, i);
    }

    private int getAmountOfResource(GameResources res) {
        return resources.getInt(res);
    }

    public String toString() {
        return "Resources: \n" + resources.toString();
    }
}
