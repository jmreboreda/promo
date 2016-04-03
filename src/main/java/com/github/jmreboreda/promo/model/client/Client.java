package com.github.jmreboreda.promo.model.client;

import java.util.ArrayList;
import java.util.List;

import com.github.jmreboreda.promo.model.BusinessObject;

public class Client implements BusinessObject {

	private static final long serialVersionUID = -3817506926597055935L;

	private Long id;
	private Client sponsor;
	private List<Client> adopteds;

	public Client() {
		this.adopteds = new ArrayList<Client>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getSponsor() {
		return sponsor;
	}

	public void setSponsor(Client sponsor) {
		this.sponsor = sponsor;
	}

	public List<Client> getAdopteds() {
		return adopteds;
	}

	public void setAdopteds(List<Client> adopteds) {
		this.adopteds = adopteds;
	}
	
	public void appendAdopted(Client adopted){
		this.adopteds.add(adopted);
		
	}
	
}
