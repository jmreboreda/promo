package com.github.jmreboreda.promo.model.dao;

import java.io.Serializable;

import com.github.jmreboreda.promo.model.exceptions.daoexceptions.InstanceNotFoundException;



public interface GenericDao <E, PK extends Serializable>{

	void create(E entity);
		
	E find(PK id) throws InstanceNotFoundException;
	
	boolean exists(PK id);
	
	E update(E entity);

	void remove(PK id) throws InstanceNotFoundException;	
	
}
