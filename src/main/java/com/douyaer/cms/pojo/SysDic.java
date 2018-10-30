package com.douyaer.cms.pojo;

public class SysDic extends SysDicKey {
    private String dicValue;

    private Integer orderNum;

    public SysDic(String dicType, String dicKey, String dicValue, Integer orderNum) {
        super(dicType, dicKey);
        this.dicValue = dicValue;
        this.orderNum = orderNum;
    }

    public SysDic() {
        super();
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}