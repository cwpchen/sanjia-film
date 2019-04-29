package com.sj.common.pojo;

import java.io.Serializable;

public class Purchase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String movie_name;  //电影名称
	private String show_time;   //上映时间
	private String category;   //分类
	private float  score;   //评分
	private String ciname_name;   //影院名字
	private String address;   //影院地址
	private String play_time;  //场次
	private String platform;   //购票平台
	private double price;   //价格	
	private String herf;   //购票链接
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getShow_time() {
		return show_time;
	}
	public void setShow_time(String show_time) {
		this.show_time = show_time;
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
	public String getCiname_name() {
		return ciname_name;
	}
	public void setCiname_name(String ciname_name) {
		this.ciname_name = ciname_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlay_time() {
		return play_time;
	}
	public void setPlay_time(String play_time) {
		this.play_time = play_time;
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
	@Override
	public String toString() {
		return "Purchase [movie_name=" + movie_name + ", show_time=" + show_time + ", category=" + category + ", score="
				+ score + ", ciname_name=" + ciname_name + ", address=" + address + ", play_time=" + play_time
				+ ", platform=" + platform + ", price=" + price + ", herf=" + herf + "]";
	}
	public Purchase(String movie_name, String show_time, String category, float score, String ciname_name,
			String address, String play_time, String platform, double price, String herf) {
		super();
		this.movie_name = movie_name;
		this.show_time = show_time;
		this.category = category;
		this.score = score;
		this.ciname_name = ciname_name;
		this.address = address;
		this.play_time = play_time;
		this.platform = platform;
		this.price = price;
		this.herf = herf;
	}
	public Purchase() {
		
	}
	
	
	

}
