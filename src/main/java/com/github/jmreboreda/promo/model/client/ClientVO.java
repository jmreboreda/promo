package com.github.jmreboreda.promo.model.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.jmreboreda.promo.model.ValueObject;

@Entity
@Table(name = "Client")
public class ClientVO implements ValueObject {

	private static final long serialVersionUID = 8674188501454422360L;
	
	private Long id;
	private ClientVO sponsor;
	
	public ClientVO() {

	}
	
	@Id
	@SequenceGenerator(name="ClientIdGenerator", sequenceName="ClientIdSequence")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ClientIdGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "sponsorId")
	public ClientVO getSponsor() {
		return sponsor;
	}

	public void setSponsor(ClientVO sponsor) {
		this.sponsor = sponsor;
	}
}
