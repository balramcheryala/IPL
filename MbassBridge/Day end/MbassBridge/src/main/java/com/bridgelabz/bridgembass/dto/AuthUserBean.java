package com.bridgelabz.bridgembass.dto;

public class AuthUserBean {

	private String id;
	private String email;
	private String providers;
	private String created;
	private String 	signedin;
	private String 	useruid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProviders() {
		return providers;
	}
	public void setProviders(String providers) {
		this.providers = providers;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getSignedin() {
		return signedin;
	}
	public void setSignedin(String signedin) {
		this.signedin = signedin;
	}
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	
	
	
}
