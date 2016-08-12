package com.bridgelabz.bridgembass.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClientKeys")
public class ClientKeys {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "Client Id")
	private String clientid;
	
	@Column(name = "Client Secret")
	private String clientsecrete;

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getClientsecrete() {
		return clientsecrete;
	}

	public void setClientsecrete(String clientsecrete) {
		this.clientsecrete = clientsecrete;
	}

}
