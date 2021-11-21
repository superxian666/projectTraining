package com.firewolf.apitest_platform.domain;

public class Collection {
    private Integer id;
    private String name;
    private Integer user_id;

    public Collection(Integer id, String name, Integer user_id) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
    }

    public Collection(String name, Integer user_id) {
        this.name = name;
        this.user_id = user_id;
    }

    public Collection() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
