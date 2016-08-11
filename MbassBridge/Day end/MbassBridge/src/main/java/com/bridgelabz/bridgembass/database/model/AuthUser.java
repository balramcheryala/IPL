package com.bridgelabz.bridgembass.database.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MBAASSUSER")
public class AuthUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Providers")
	private String Providers;
	
	@Column(name="CreatedDate")
	@Temporal(TemporalType.DATE)
	private Date Created;
	
	@Column(name="SignedInDate")
	@Temporal(TemporalType.DATE)
	private Date SignedIn;
	
	@Column(name="UserUID")
	private String UserUID;

	public String getEmail() {
		return Email;
	}

	public Date getCreated() {
		return Created;
	}

	public void setCreated(Date created) {
		Created = created;
	}

	public Date getSignedIn() {
		return SignedIn;
	}

	public void setSignedIn(Date signedIn) {
		SignedIn = signedIn;
	}

	public String getUserUID() {
		return UserUID;
	}

	public void setUserUID(String userUID) {
		UserUID = userUID;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getProviders() {
		return Providers;
	}

	public void setProviders(String providers) {
		Providers = providers;
	}

	@Override
	public String toString() {
		return "AuthUser [id=" + id + ", Email=" + Email + ", Providers=" + Providers + ", Created=" + Created
				+ ", SignedIn=" + SignedIn + ", UserUID=" + UserUID + "]";
	}
	
}
