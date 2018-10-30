package com.douyaer.cms.pojo;

public class SysDicKey {
    private String dicType;

    private String dicKey;

    public SysDicKey(String dicType, String dicKey) {
        this.dicType = dicType;
        this.dicKey = dicKey;
    }

    public SysDicKey() {
        super();
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType == null ? null : dicType.trim();
    }

    public String getDicKey() {
        return dicKey;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey == null ? null : dicKey.trim();
    }
}