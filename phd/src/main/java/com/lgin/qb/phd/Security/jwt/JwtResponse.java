package com.lgin.qb.phd.Security.jwt;

public class JwtResponse {

	private String token;
	private String type="Bearer";
	
	public JwtResponse(String accesstoken) {
		super();
		this.token = accesstoken;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String accesstoken) {
		this.token = accesstoken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
