package com.sj.common.pojo;

import java.io.Serializable;

public class Favorite implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String favorite_id; //购票信息唯一标识
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFavorite_id() {
		return favorite_id;
	}
	public void setFavorite_id(String favorite_id) {
		this.favorite_id = favorite_id;
	}
	@Override
	public String toString() {
		return "Favorite [username=" + username + ", favorite_id=" + favorite_id + "]";
	}
	public Favorite(String username, String favorite_id) {
		super();
		this.username = username;
		this.favorite_id = favorite_id;
	}
	public Favorite() {
		
	}
    
    
}
