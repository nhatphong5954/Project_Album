package com.example.project_album.Model;

public class Album {
    private int id;
    private int resource_id;
    private String name;

    public Album(int id, int resource_id, String name) {
        this.id = id;
        this.resource_id = resource_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
