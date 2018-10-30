package com.douyaer.cms.pojo;

import java.util.Date;

public class Order {
    private Long orderId;

    private String taskId;

    private Long userId;

    private String ipScreenshotUrl;

    private String searchPicUrl;

    private String comparePicUrl1;

    private String comparePicUrl2;

    private String comparePicUrl3;

    private String enterStoreUrl;

    private String viewRemarkUrl;

    private String viewBuyershowUrl;

    private String detailPageUrl;

    private String detailPageBottomUrl;

    private String homePageUrl;

    private String viewAllGoodsUrl;

    private String viewOtherGoodsUrl;

    private String chatUrl;

    private String buyGoodsUrl;

    private String finishOrderUrl;

    private String favoriteAttentionUrl;

    private String favoriteAttentionEntershopUrl;

    private String grouponDetailUrl;

    private String finishRemarkUrl;

    private String brushhandRemarkDes;

    private String businessRemarkDes;

    private String buyershowUrl1;

    private String buyershowUrl2;

    private String buyershowUrl3;

    private String backBuyImg1;

    private String backBuyImg2;

    private String backBuyImg3;

    private String backBuyImg4;

    private String backBuyImg5;

    private Date createTime;

    private Date updateTime;

    private Date submitOrderTime;

    private Date businessRemarkTime;

    private Date brushhandRemarkTime;

    private Date sendMoneyTime;

    private Date autoSendmoneyTime;

    private Integer status;

    public Order(Long orderId, String taskId, Long userId, String ipScreenshotUrl, String searchPicUrl, String comparePicUrl1, String comparePicUrl2, String comparePicUrl3, String enterStoreUrl, String viewRemarkUrl, String viewBuyershowUrl, String detailPageUrl, String detailPageBottomUrl, String homePageUrl, String viewAllGoodsUrl, String viewOtherGoodsUrl, String chatUrl, String buyGoodsUrl, String finishOrderUrl, String favoriteAttentionUrl, String favoriteAttentionEntershopUrl, String grouponDetailUrl, String finishRemarkUrl, String brushhandRemarkDes, String businessRemarkDes, String buyershowUrl1, String buyershowUrl2, String buyershowUrl3, String backBuyImg1, String backBuyImg2, String backBuyImg3, String backBuyImg4, String backBuyImg5, Date createTime, Date updateTime, Date submitOrderTime, Date businessRemarkTime, Date brushhandRemarkTime, Date sendMoneyTime, Date autoSendmoneyTime, Integer status) {
        this.orderId = orderId;
        this.taskId = taskId;
        this.userId = userId;
        this.ipScreenshotUrl = ipScreenshotUrl;
        this.searchPicUrl = searchPicUrl;
        this.comparePicUrl1 = comparePicUrl1;
        this.comparePicUrl2 = comparePicUrl2;
        this.comparePicUrl3 = comparePicUrl3;
        this.enterStoreUrl = enterStoreUrl;
        this.viewRemarkUrl = viewRemarkUrl;
        this.viewBuyershowUrl = viewBuyershowUrl;
        this.detailPageUrl = detailPageUrl;
        this.detailPageBottomUrl = detailPageBottomUrl;
        this.homePageUrl = homePageUrl;
        this.viewAllGoodsUrl = viewAllGoodsUrl;
        this.viewOtherGoodsUrl = viewOtherGoodsUrl;
        this.chatUrl = chatUrl;
        this.buyGoodsUrl = buyGoodsUrl;
        this.finishOrderUrl = finishOrderUrl;
        this.favoriteAttentionUrl = favoriteAttentionUrl;
        this.favoriteAttentionEntershopUrl = favoriteAttentionEntershopUrl;
        this.grouponDetailUrl = grouponDetailUrl;
        this.finishRemarkUrl = finishRemarkUrl;
        this.brushhandRemarkDes = brushhandRemarkDes;
        this.businessRemarkDes = businessRemarkDes;
        this.buyershowUrl1 = buyershowUrl1;
        this.buyershowUrl2 = buyershowUrl2;
        this.buyershowUrl3 = buyershowUrl3;
        this.backBuyImg1 = backBuyImg1;
        this.backBuyImg2 = backBuyImg2;
        this.backBuyImg3 = backBuyImg3;
        this.backBuyImg4 = backBuyImg4;
        this.backBuyImg5 = backBuyImg5;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.submitOrderTime = submitOrderTime;
        this.businessRemarkTime = businessRemarkTime;
        this.brushhandRemarkTime = brushhandRemarkTime;
        this.sendMoneyTime = sendMoneyTime;
        this.autoSendmoneyTime = autoSendmoneyTime;
        this.status = status;
    }

    public Order() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public String getIpScreenshotUrl() {
        return ipScreenshotUrl;
    }

    public void setIpScreenshotUrl(String ipScreenshotUrl) {
        this.ipScreenshotUrl = ipScreenshotUrl == null ? null : ipScreenshotUrl.trim();
    }

    public String getSearchPicUrl() {
        return searchPicUrl;
    }

    public void setSearchPicUrl(String searchPicUrl) {
        this.searchPicUrl = searchPicUrl == null ? null : searchPicUrl.trim();
    }

    public String getComparePicUrl1() {
        return comparePicUrl1;
    }

    public void setComparePicUrl1(String comparePicUrl1) {
        this.comparePicUrl1 = comparePicUrl1 == null ? null : comparePicUrl1.trim();
    }

    public String getComparePicUrl2() {
        return comparePicUrl2;
    }

    public void setComparePicUrl2(String comparePicUrl2) {
        this.comparePicUrl2 = comparePicUrl2 == null ? null : comparePicUrl2.trim();
    }

    public String getComparePicUrl3() {
        return comparePicUrl3;
    }

    public void setComparePicUrl3(String comparePicUrl3) {
        this.comparePicUrl3 = comparePicUrl3 == null ? null : comparePicUrl3.trim();
    }

    public String getEnterStoreUrl() {
        return enterStoreUrl;
    }

    public void setEnterStoreUrl(String enterStoreUrl) {
        this.enterStoreUrl = enterStoreUrl == null ? null : enterStoreUrl.trim();
    }

    public String getViewRemarkUrl() {
        return viewRemarkUrl;
    }

    public void setViewRemarkUrl(String viewRemarkUrl) {
        this.viewRemarkUrl = viewRemarkUrl == null ? null : viewRemarkUrl.trim();
    }

    public String getViewBuyershowUrl() {
        return viewBuyershowUrl;
    }

    public void setViewBuyershowUrl(String viewBuyershowUrl) {
        this.viewBuyershowUrl = viewBuyershowUrl == null ? null : viewBuyershowUrl.trim();
    }

    public String getDetailPageUrl() {
        return detailPageUrl;
    }

    public void setDetailPageUrl(String detailPageUrl) {
        this.detailPageUrl = detailPageUrl == null ? null : detailPageUrl.trim();
    }

    public String getDetailPageBottomUrl() {
        return detailPageBottomUrl;
    }

    public void setDetailPageBottomUrl(String detailPageBottomUrl) {
        this.detailPageBottomUrl = detailPageBottomUrl == null ? null : detailPageBottomUrl.trim();
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl == null ? null : homePageUrl.trim();
    }

    public String getViewAllGoodsUrl() {
        return viewAllGoodsUrl;
    }

    public void setViewAllGoodsUrl(String viewAllGoodsUrl) {
        this.viewAllGoodsUrl = viewAllGoodsUrl == null ? null : viewAllGoodsUrl.trim();
    }

    public String getViewOtherGoodsUrl() {
        return viewOtherGoodsUrl;
    }

    public void setViewOtherGoodsUrl(String viewOtherGoodsUrl) {
        this.viewOtherGoodsUrl = viewOtherGoodsUrl == null ? null : viewOtherGoodsUrl.trim();
    }

    public String getChatUrl() {
        return chatUrl;
    }

    public void setChatUrl(String chatUrl) {
        this.chatUrl = chatUrl == null ? null : chatUrl.trim();
    }

    public String getBuyGoodsUrl() {
        return buyGoodsUrl;
    }

    public void setBuyGoodsUrl(String buyGoodsUrl) {
        this.buyGoodsUrl = buyGoodsUrl == null ? null : buyGoodsUrl.trim();
    }

    public String getFinishOrderUrl() {
        return finishOrderUrl;
    }

    public void setFinishOrderUrl(String finishOrderUrl) {
        this.finishOrderUrl = finishOrderUrl == null ? null : finishOrderUrl.trim();
    }

    public String getFavoriteAttentionUrl() {
        return favoriteAttentionUrl;
    }

    public void setFavoriteAttentionUrl(String favoriteAttentionUrl) {
        this.favoriteAttentionUrl = favoriteAttentionUrl == null ? null : favoriteAttentionUrl.trim();
    }

    public String getFavoriteAttentionEntershopUrl() {
        return favoriteAttentionEntershopUrl;
    }

    public void setFavoriteAttentionEntershopUrl(String favoriteAttentionEntershopUrl) {
        this.favoriteAttentionEntershopUrl = favoriteAttentionEntershopUrl == null ? null : favoriteAttentionEntershopUrl.trim();
    }

    public String getGrouponDetailUrl() {
        return grouponDetailUrl;
    }

    public void setGrouponDetailUrl(String grouponDetailUrl) {
        this.grouponDetailUrl = grouponDetailUrl == null ? null : grouponDetailUrl.trim();
    }

    public String getFinishRemarkUrl() {
        return finishRemarkUrl;
    }

    public void setFinishRemarkUrl(String finishRemarkUrl) {
        this.finishRemarkUrl = finishRemarkUrl == null ? null : finishRemarkUrl.trim();
    }

    public String getBrushhandRemarkDes() {
        return brushhandRemarkDes;
    }

    public void setBrushhandRemarkDes(String brushhandRemarkDes) {
        this.brushhandRemarkDes = brushhandRemarkDes == null ? null : brushhandRemarkDes.trim();
    }

    public String getBusinessRemarkDes() {
        return businessRemarkDes;
    }

    public void setBusinessRemarkDes(String businessRemarkDes) {
        this.businessRemarkDes = businessRemarkDes == null ? null : businessRemarkDes.trim();
    }

    public String getBuyershowUrl1() {
        return buyershowUrl1;
    }

    public void setBuyershowUrl1(String buyershowUrl1) {
        this.buyershowUrl1 = buyershowUrl1 == null ? null : buyershowUrl1.trim();
    }

    public String getBuyershowUrl2() {
        return buyershowUrl2;
    }

    public void setBuyershowUrl2(String buyershowUrl2) {
        this.buyershowUrl2 = buyershowUrl2 == null ? null : buyershowUrl2.trim();
    }

    public String getBuyershowUrl3() {
        return buyershowUrl3;
    }

    public void setBuyershowUrl3(String buyershowUrl3) {
        this.buyershowUrl3 = buyershowUrl3 == null ? null : buyershowUrl3.trim();
    }

    public String getBackBuyImg1() {
        return backBuyImg1;
    }

    public void setBackBuyImg1(String backBuyImg1) {
        this.backBuyImg1 = backBuyImg1 == null ? null : backBuyImg1.trim();
    }

    public String getBackBuyImg2() {
        return backBuyImg2;
    }

    public void setBackBuyImg2(String backBuyImg2) {
        this.backBuyImg2 = backBuyImg2 == null ? null : backBuyImg2.trim();
    }

    public String getBackBuyImg3() {
        return backBuyImg3;
    }

    public void setBackBuyImg3(String backBuyImg3) {
        this.backBuyImg3 = backBuyImg3 == null ? null : backBuyImg3.trim();
    }

    public String getBackBuyImg4() {
        return backBuyImg4;
    }

    public void setBackBuyImg4(String backBuyImg4) {
        this.backBuyImg4 = backBuyImg4 == null ? null : backBuyImg4.trim();
    }

    public String getBackBuyImg5() {
        return backBuyImg5;
    }

    public void setBackBuyImg5(String backBuyImg5) {
        this.backBuyImg5 = backBuyImg5 == null ? null : backBuyImg5.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getSubmitOrderTime() {
        return submitOrderTime;
    }

    public void setSubmitOrderTime(Date submitOrderTime) {
        this.submitOrderTime = submitOrderTime;
    }

    public Date getBusinessRemarkTime() {
        return businessRemarkTime;
    }

    public void setBusinessRemarkTime(Date businessRemarkTime) {
        this.businessRemarkTime = businessRemarkTime;
    }

    public Date getBrushhandRemarkTime() {
        return brushhandRemarkTime;
    }

    public void setBrushhandRemarkTime(Date brushhandRemarkTime) {
        this.brushhandRemarkTime = brushhandRemarkTime;
    }

    public Date getSendMoneyTime() {
        return sendMoneyTime;
    }

    public void setSendMoneyTime(Date sendMoneyTime) {
        this.sendMoneyTime = sendMoneyTime;
    }

    public Date getAutoSendmoneyTime() {
        return autoSendmoneyTime;
    }

    public void setAutoSendmoneyTime(Date autoSendmoneyTime) {
        this.autoSendmoneyTime = autoSendmoneyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}