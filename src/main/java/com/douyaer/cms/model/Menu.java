package com.douyaer.cms.model;

import lombok.Data;

@Data
public class Menu {
    public int id;
    public int pid;
    public String name;
    public String page;
    public Menu(int id, int pid, String name, String page) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.page = page;
    }
}