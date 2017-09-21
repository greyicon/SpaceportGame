package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameResources;

// DEPRECATED
// Object to store the amount of a resource player has
public class ResVal {
    public GameResources resource;
    public int amount;
    public int genPerSec;

    // Initialize object with a resource type, starting with 0 of that resource
    public ResVal(GameResources res) {
        resource = res;
        amount = 0;
        genPerSec = 0;
    }

    // Add i resources, return total
    public int addResource(int i) {
        amount += i;
        return amount;
    }

    // Remove i resouces, return total
    // Return -1 if remove amount is greater than total
    public int removeResource(int i) {
        if (i > amount) {
            return -1;
        } else {
            amount -= i;
            return amount;
        }
    }

    // Return a string of the resource-amount pair
    public String toString() {
        return resource.toString() + ": " + amount;
    }

    // Set the generation rate of this resource (per second)
    public void setGenRate(int i) {
        genPerSec = i;
    }

    // Double the per-second generation amount of this resource
    public void doubleGenRate() {
        genPerSec *= 2;
    }

    // Add perSecGen resources to amount
    // Called every second to passively generate resources
    public void tickGen() {
        amount += genPerSec;
    }
}
