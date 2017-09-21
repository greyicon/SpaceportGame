package com.sgoldwax.spaceport;

import android.util.Log;

import com.sgoldwax.spaceport.Enums.GameResources;
import com.sgoldwax.spaceport.Exceptions.MissingObjectException;

import java.util.ArrayList;
import java.util.List;

// Object for storing, receiving, and spending resources
public class ResourceManager {
    private final String TAG = "RESOURCE_MANAGER";

    private ResHolder resources;

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

    public void updateResources() {
        //TODO
    }


}
