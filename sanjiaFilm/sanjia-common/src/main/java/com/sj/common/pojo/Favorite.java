package com.sj.common.pojo;

import java.io.Serializable;

public class Favorite implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String favoriteId; //购票信息唯一标识
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Favorite(String username, String favorite_id) {
		super();
		this.username = username;
		this.favoriteId = favoriteId;
	}
	public String getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}
	public Favorite() {
		
	}
    
    
}
