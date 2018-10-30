package com.douyaer.cms.pojo;

import java.util.Date;

public class Admin {
    private Long id;

    private String name;

    private String password;

    private Date ctime;

    private Date mtime;

    public Admin(Long id, String name, String password, Date ctime, Date mtime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.ctime = ctime;
        this.mtime = mtime;
    }

    public Admin() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
}