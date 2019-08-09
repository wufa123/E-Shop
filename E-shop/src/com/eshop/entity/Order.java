package com.eshop.entity;

public class Order {
	
	private int orderId;	//订单编号
	private int goodsId;	//商品id
	private String goodsName;	//商品名称
	private int goodNum;	//商品数量
	private Integer orderMoney;	//订单金额
	private String orderTime;	//订单时间
	private String orderState;	//订单状态״̬
	private int userId;	//用户id
	private String userTrueName; 	//用户真实姓名
	private int userPhone;	//用户电话
	private String userAddress;	//用户地址ַ
	private int storeId;	//店铺id
	private String storeName;	//店铺名称
	
	//封装和构造
	public Order(){
		
	}
	
	public Order(int orderId,int goodsId,String goodsName,int goodNum,Integer orderMoney,String orderTime,String orderState,
					int userId,String userTrueName,int userPhone,String userAddress,int storeId,String storeName) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodNum = goodNum;
		this.orderMoney = orderMoney;
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.userId = userId;
		this.userTrueName = userTrueName;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.storeId = storeId;
		this.storeName = storeName;
		
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodNum="
				+ goodNum + ", orderMoney=" + orderMoney + ", orderTime=" + orderTime + ", orderState=" + orderState
				+ ", userId=" + userId + ", userTrueName=" + userTrueName + ", userPhone=" + userPhone
				+ ", userAddress=" + userAddress + ", storeId=" + storeId + ", storeName=" + storeName + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	public Integer getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Integer orderMoney) {
		this.orderMoney = orderMoney;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserTrueName() {
		return userTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
