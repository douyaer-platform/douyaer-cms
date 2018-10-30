package com.douyaer.cms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Task {
    private String taskId;

    private Long userId;

    private String brushhandSex;

    private String provinces;

    private Date startTime;

    private Date endTime;

    private Integer orderCount;

    private BigDecimal costTotalCoin;

    private BigDecimal orderPrice;

    private Integer commission;

    private Integer finishScalpingCount;

    private String remark;

    private String storeName;

    private String goodsUrl;

    private String goodsPicUrl;

    private String searchPicUrl;

    private String conditionPicUrl;

    private BigDecimal goodsPrice;

    private String tags;

    private Short buyBackType;

    private Short needAlitm;

    private Date createTime;

    private Integer status;

    private BigDecimal refundCoin;

    private Date refundTime;

    public Task(String taskId, Long userId, String brushhandSex, String provinces, Date startTime, Date endTime, Integer orderCount, BigDecimal costTotalCoin, BigDecimal orderPrice, Integer commission, Integer finishScalpingCount, String remark, String storeName, String goodsUrl, String goodsPicUrl, String searchPicUrl, String conditionPicUrl, BigDecimal goodsPrice, String tags, Short buyBackType, Short needAlitm, Date createTime, Integer status, BigDecimal refundCoin, Date refundTime) {
        this.taskId = taskId;
        this.userId = userId;
        this.brushhandSex = brushhandSex;
        this.provinces = provinces;
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderCount = orderCount;
        this.costTotalCoin = costTotalCoin;
        this.orderPrice = orderPrice;
        this.commission = commission;
        this.finishScalpingCount = finishScalpingCount;
        this.remark = remark;
        this.storeName = storeName;
        this.goodsUrl = goodsUrl;
        this.goodsPicUrl = goodsPicUrl;
        this.searchPicUrl = searchPicUrl;
        this.conditionPicUrl = conditionPicUrl;
        this.goodsPrice = goodsPrice;
        this.tags = tags;
        this.buyBackType = buyBackType;
        this.needAlitm = needAlitm;
        this.createTime = createTime;
        this.status = status;
        this.refundCoin = refundCoin;
        this.refundTime = refundTime;
    }

    public Task() {
        super();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBrushhandSex() {
        return brushhandSex;
    }

    public void setBrushhandSex(String brushhandSex) {
        this.brushhandSex = brushhandSex == null ? null : brushhandSex.trim();
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces == null ? null : provinces.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getCostTotalCoin() {
        return costTotalCoin;
    }

    public void setCostTotalCoin(BigDecimal costTotalCoin) {
        this.costTotalCoin = costTotalCoin;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getFinishScalpingCount() {
        return finishScalpingCount;
    }

    public void setFinishScalpingCount(Integer finishScalpingCount) {
        this.finishScalpingCount = finishScalpingCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl == null ? null : goodsUrl.trim();
    }

    public String getGoodsPicUrl() {
        return goodsPicUrl;
    }

    public void setGoodsPicUrl(String goodsPicUrl) {
        this.goodsPicUrl = goodsPicUrl == null ? null : goodsPicUrl.trim();
    }

    public String getSearchPicUrl() {
        return searchPicUrl;
    }

    public void setSearchPicUrl(String searchPicUrl) {
        this.searchPicUrl = searchPicUrl == null ? null : searchPicUrl.trim();
    }

    public String getConditionPicUrl() {
        return conditionPicUrl;
    }

    public void setConditionPicUrl(String conditionPicUrl) {
        this.conditionPicUrl = conditionPicUrl == null ? null : conditionPicUrl.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Short getBuyBackType() {
        return buyBackType;
    }

    public void setBuyBackType(Short buyBackType) {
        this.buyBackType = buyBackType;
    }

    public Short getNeedAlitm() {
        return needAlitm;
    }

    public void setNeedAlitm(Short needAlitm) {
        this.needAlitm = needAlitm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getRefundCoin() {
        return refundCoin;
    }

    public void setRefundCoin(BigDecimal refundCoin) {
        this.refundCoin = refundCoin;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }
}