package com.ejournal;

import java.util.ArrayList;
import java.util.List;

public class Group {
    // group Id
    private final int groupId;

    // list of soldiers
    private List<Soldier> soldiers;

    //constructor
    public Group(int groupId) {
        this.groupId = groupId;
        this.soldiers = new ArrayList<>();
    }

    // get id group
    public int getGroupId() {
        return this.groupId;
    }

    // get list of soldiers
    public List<Soldier> getSolders() {
        return soldiers;
    }

    // add soldier to group
    public void addSoldier(Soldier soldier) {
        soldier.setGroupId(this.groupId);
        soldiers.add(soldier);
    }

    // remove soldier
    public void removeSoldier(int soldierId) {
        soldiers.removeIf(soldier -> soldier.getId() == soldierId);
    }
}