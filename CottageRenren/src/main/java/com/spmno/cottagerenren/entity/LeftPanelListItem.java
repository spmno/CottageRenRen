package com.spmno.cottagerenren.entity;

import java.util.ArrayList;

/**
 * Created by spmno on 13-8-31.
 */
public class LeftPanelListItem {
    private int id;
    private String name;
    private int drawableId;
    private ArrayList<LeftPanelListItem> groups;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDrawableId() {
        return drawableId;
    }
    public void setDrawableId(int id) {
        this.drawableId = id;
    }
    public ArrayList<LeftPanelListItem> getGroups() {
        return groups;
    }
    public void setGroups(ArrayList<LeftPanelListItem> groups) {
        this.groups = groups;
    }
}
