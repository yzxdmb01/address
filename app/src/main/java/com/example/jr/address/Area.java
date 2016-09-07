package com.example.jr.address;

import java.util.List;

/**
 * Created by Administrator on 2016-09-07.
 */

public class Area {
    private String id;
    private String parentId;
    private String name;
    private String entireName;

    public List<Area> getArea() {
        return area;
    }

    public void setArea(List<Area> area) {
        this.area = area;
    }

    private List<Area> area;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntireName() {
        return entireName;
    }

    public void setEntireName(String entireName) {
        this.entireName = entireName;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", entireName='" + entireName + '\'' +
                '}';
    }
}
