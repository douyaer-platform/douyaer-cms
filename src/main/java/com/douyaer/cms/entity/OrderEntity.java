package com.douyaer.cms.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.douyaer.cms.pojo.Order;

public class OrderEntity extends Order {

    private String storeName;
    private String goodsUrl;
    private String goodsPicUrl;
    private String taskSearchPicUrl;
    private String conditionPicUrl;
    private BigDecimal orderPrice;
    private BigDecimal goodsPrice;
    private Integer commission;
    private String tags;
    private Integer buyBackType;
    private Integer needAlitm;

    private String phone;
    private String taobaoAccount;
    private Long busUserId;
    private String busPhone;
    private String busTaobaoAccount;

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl == null ? null : goodsUrl.trim();
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsPicUrl(String goodsPicUrl) {
        this.goodsPicUrl = goodsPicUrl == null ? null : goodsPicUrl.trim();
    }

    public String getGoodPicUrl() {
        return goodsPicUrl;
    }

    public void setTaskSearchPicUrl(String taskSearchPicUrl) {
        this.taskSearchPicUrl = taskSearchPicUrl == null ? null : taskSearchPicUrl.trim();
    }

    public String getTaskSearchPicUrl() {
        return taskSearchPicUrl;
    }

    public void setConditionPicUrl(String conditionPicUrl) {
        this.conditionPicUrl = conditionPicUrl == null ? null : conditionPicUrl.trim();
    }

    public String getConditionPicUrl() {
        return conditionPicUrl;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setBuyBackType(Integer buyBackType) {
        this.buyBackType = buyBackType;
    }

    public Integer getBuyBackType() {
        return buyBackType;
    }

    public void setNeedAlitm(Integer needAlitm) {
        this.needAlitm = needAlitm;
    }

    public Integer getNeedAlitm() {
        return needAlitm;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setTaobaoAccount(String taobaoAccount) {
        this.taobaoAccount = taobaoAccount == null ? null : taobaoAccount.trim();
    }

    public String getTaobaoAccount() {
        return taobaoAccount;
    }

    public void setBusUserId(Long busUserId) {
        this.busUserId = busUserId;
    }

    public Long getBusUserId() {
        return busUserId;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone == null ? null : busPhone.trim();
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusTaobaoAccount(String busTaobaoAccount) {
        this.busTaobaoAccount = busTaobaoAccount == null ? null : busTaobaoAccount.trim();
    }

    public String getBusTaobaoAccount() {
        return busTaobaoAccount;
    }

    public OrderEntity(Long orderId, String taskId, Long userId, String ipScreenshotUrl, String searchPicUrl, 
            String comparePicUrl1, String comparePicUrl2, String comparePicUrl3, String enterStoreUrl, String viewRemarkUrl, 
            String viewBuyershowUrl, String detailPageUrl, String detailPageBottomUrl, String homePageUrl, String viewAllGoodsUrl, 
            String viewOtherGoodsUrl, String chatUrl, String buyGoodsUrl, String finishOrderUrl, String favoriteAttentionUrl, 
            String favoriteAttentionEntershopUrl, String grouponDetailUrl, String finishRemarkUrl, String brushhandRemarkDes, 
            String businessRemarkDes, String buyershowUrl1, String buyershowUrl2, String buyershowUrl3, String backBuyImg1, 
            String backBuyImg2, String backBuyImg3, String backBuyImg4, String backBuyImg5, Date createTime, Date updateTime, 
            Date submitOrderTime, Date businessRemarkTime, Date brushhandRemarkTime, Date sendMoneyTime, Date autoSendmoneyTime, Integer status,
            String storeName, String goodsUrl, String goodsPicUrl, String taskSearchPicUrl, String conditionPicUrl, 
            BigDecimal orderPrice, BigDecimal goodsPrice, Integer commission, String tags, Integer buyBackType, Integer needAlitm,
            String phone, String taobaoAccount, Long busUserId,
            String busPhone, String busTaobaoAccount) {
        super(orderId, taskId, userId, ipScreenshotUrl, searchPicUrl, comparePicUrl1, comparePicUrl2, comparePicUrl3, enterStoreUrl, viewRemarkUrl, viewBuyershowUrl, detailPageUrl, detailPageBottomUrl, homePageUrl, viewAllGoodsUrl, viewOtherGoodsUrl, chatUrl, buyGoodsUrl, finishOrderUrl, favoriteAttentionUrl, favoriteAttentionEntershopUrl, grouponDetailUrl, finishRemarkUrl, brushhandRemarkDes, businessRemarkDes, buyershowUrl1, buyershowUrl2, buyershowUrl3, backBuyImg1, backBuyImg2, backBuyImg3, backBuyImg4, backBuyImg5, createTime, updateTime, submitOrderTime, businessRemarkTime, brushhandRemarkTime, sendMoneyTime, autoSendmoneyTime, status);
        
        this.storeName = storeName;
        this.goodsUrl = goodsUrl;
        this.goodsPicUrl = goodsPicUrl;
        this.taskSearchPicUrl = taskSearchPicUrl;
        this.conditionPicUrl = conditionPicUrl;
        this.orderPrice = orderPrice;
        this.goodsPrice = goodsPrice;
        this.commission = commission;
        this.tags = tags;
        this.buyBackType = buyBackType;
        this.needAlitm = needAlitm;

        this.phone = phone;
        this.taobaoAccount = taobaoAccount;
        this.busUserId = busUserId;
        this.busPhone = busPhone;
        this.busTaobaoAccount = busTaobaoAccount;
    }

}