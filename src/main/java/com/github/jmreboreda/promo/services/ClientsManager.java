package com.github.jmreboreda.promo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.jmreboreda.promo.model.client.Client;
import com.github.jmreboreda.promo.model.client.ClientDao;
import com.github.jmreboreda.promo.model.client.ClientVO;
import com.github.jmreboreda.promo.model.exceptions.daoexceptions.InstanceNotFoundException;
import com.github.jmreboreda.promo.model.mappers.AdoptedsMapper;
import com.github.jmreboreda.promo.model.mappers.ClientMapper;

@Service("clientsManager")
@Transactional
public class ClientsManager {

	@Autowired
	private ClientDao clientDao;
	
	public void createClient(Client client) {

		if(client == null) {
			throw new NullPointerException("Client cannot be null");
		}	
		
		ClientVO clientVO = ClientMapper.proccessBOVO(client);
		clientDao.create(clientVO);
		client.setId(clientVO.getId());
				
		if( CollectionUtils.isEmpty(client.getAdopteds()) == false ) {
			
			for(Client adopted : client.getAdopteds()) {
				ClientVO adoptedVO = AdoptedsMapper.proccessBOVO(adopted, clientVO);
				clientDao.create(adoptedVO);
				adopted.setId(adoptedVO.getId());
			}
		}	
	}
	
	public Client findClientById(Long id) {

		ClientVO clientVO = null;
		
		try {
			clientVO = clientDao.find(id);
			
		} catch (InstanceNotFoundException e) {
			return null;
		}	
		
		List<ClientVO> adoptedsVO = clientDao.findAdoptedsByClientId(id);
		
		Client client = ClientMapper.proccessVOBO(clientVO, adoptedsVO);
		
		return client;

	}
}
