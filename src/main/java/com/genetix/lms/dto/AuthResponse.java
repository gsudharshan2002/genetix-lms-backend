package com.genetix.lms.dto;


public class AuthResponse {
	private String token;
    private String role;
    public AuthResponse(String token2, String name) {
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
