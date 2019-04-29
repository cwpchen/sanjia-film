package com.sj.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class Purchase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String movieName;  //电影名称
	private String showTime;   //上映时间
	private String category;   //分类
	private float  score;   //评分
	private String cinameName;   //影院名字
	private String address;   //影院地址
	private Date playTime;  //场次
	private String platform;   //购票平台
	private double price;   //价格	
	private String herf;   //购票链接
	private String favoriteId;//唯一标识，只做收藏的关联字段
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getCinameName() {
		return cinameName;
	}
	public void setCinameName(String cinameName) {
		this.cinameName = cinameName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getHerf() {
		return herf;
	}
	public void setHerf(String herf) {
		this.herf = herf;
	}
	public String getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public Purchase(String movieName, String showTime, String category, float score, String cinameName,
			String address, Date playTime, String platform, double price, String herf,String favoriteId) {
		super();
		this.movieName = movieName;
		this.showTime = showTime;
		this.category = category;
		this.score = score;
		this.cinameName = cinameName;
		this.address = address;
		this.playTime = playTime;
		this.platform = platform;
		this.price = price;
		this.herf = herf;
		this.favoriteId = favoriteId;
	}
	public Date getPlayTime() {
		return playTime;
	}
	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}
	public Purchase() {
		
	}
	
	
	

}
