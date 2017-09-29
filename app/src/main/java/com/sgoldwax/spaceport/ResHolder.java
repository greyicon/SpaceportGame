package com.sgoldwax.spaceport;

import com.sgoldwax.spaceport.Enums.GameResources;
import com.sgoldwax.spaceport.Exceptions.NotEnoughResourcesException;

import java.util.ArrayList;
import java.util.List;

public class ResHolder {
    public List<GameResources> resourcesList;
    public List<Integer> integerList;

    public ResHolder() {
        resourcesList = new ArrayList<>();
        integerList = new ArrayList<>();
    }

    public void add(GameResources res, int i) {
        if (resourcesList.contains(res)) {
            int index = resourcesList.indexOf(res);
            int add = integerList.get(index);
            integerList.set(index, add + i);
        } else {
            resourcesList.add(res);
            integerList.add(i);
        }
    }

    private boolean canSubtract(ResHolder holder) {
        for (int i = 0; i < size(); i++) {
            GameResources res = this.resourcesList.get(i);
            int num = holder.getInt(res);
            if (holder.resourcesList.contains(res)) {
                if (num >= this.integerList.get(i)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void subtract(ResHolder holder) throws NotEnoughResourcesException {
        if (!canSubtract(holder)) {throw new NotEnoughResourcesException();}
        for (Integer i : holder.integerList) {
            i *= -1;
        }
        this.add(holder);
        for (Integer i : holder.integerList) {
            i *= -1;
        }
    }

    public int getInt(GameResources res) {
        int index = resourcesList.indexOf(res);
        return integerList.get(index);
    }

    public int size() {
        return resourcesList.size();
    }

    public void add(ResHolder holder) {
        for (int i = 0; i < holder.size(); i++) {
            this.add(holder.resourcesList.get(i), holder.integerList.get(i));
        }
    }

    public String ToString() {
        String ret = "";
        for (int i = 0; i < resourcesList.size(); i++) {
            ret += resourcesList.get(i) + ": " + integerList.get(i) + "\n";
        }
        return ret;
    }
}
