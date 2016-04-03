package com.github.jmreboreda.promo.model.client;

import java.util.List;

import com.github.jmreboreda.promo.model.dao.GenericDao;
import com.github.jmreboreda.promo.model.exceptions.daoexceptions.InstanceNotFoundException;

public interface ClientDao extends GenericDao<ClientVO,Long> {

	ClientVO findClientByName(String name) throws InstanceNotFoundException;
	
	List<ClientVO> findAdoptedsByClientId(Long id);
	
	List<ClientVO> findAllClients();
}
