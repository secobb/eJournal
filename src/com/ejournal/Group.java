package com.ejournal;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final int groupId;
    private List<Soldier> soldiers;

    public Group(int groupId) {
        this.groupId = groupId;
        this.soldiers = new ArrayList<>();
    }

    public int getGroupId() {
        return this.groupId;
    }

    public List<Soldier> getSolders() {
        return soldiers;
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public void removeSoldier(int soldierId) {
        soldiers.removeIf(soldier -> soldier.getId() == soldierId);
    }
}