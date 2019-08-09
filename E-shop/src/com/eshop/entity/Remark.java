package com.eshop.entity;

import java.util.Date;

public class Remark {

    private int remarkId;
    private int userId;
    private String userName;
    private String remark;
    private String remarkLevel;
    private Date remarTime;
    private int orderId;
    private String goodsName;
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(int remarkId) {
        this.remarkId = remarkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkLevel() {
        return remarkLevel;
    }

    public void setRemarkLevel(String remarkLevel) {
        this.remarkLevel = remarkLevel;
    }

    public Date getRemarTime() {
        return remarTime;
    }

    public void setRemarTime(Date remarTime) {
        this.remarTime = remarTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

}
