package com.github.jmreboreda.promo.model.mappers;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.github.jmreboreda.promo.model.client.Client;
import com.github.jmreboreda.promo.model.client.ClientVO;

public class ClientMapper {

	public static Client proccessVOBO(ClientVO clientVO, List<ClientVO> adopteds) {
		
		if(clientVO == null) {
			return null;
		}
		
		Client client = new Client();
		
		client.setId(clientVO.getId());
		client.setSponsor(clientVO.getSponsor());
		
		if(CollectionUtils.isEmpty(adopteds) == false) {
		
			for(ClientVO adoptedVO : adopteds) {
				
				Client adopted = new Client();
				adopted.setId(adoptedVO.getId());
				adopted.setSponsor(adopted.getSponsor());
				
				client.appendAdopted(adopted);
			}
		
		}
		
		return client;
	}
	
	public static ClientVO proccessBOVO(Client client) {
		
		if(client == null) {
			return null;
		}
		
		ClientVO clientVO = new ClientVO();

		clientVO.setId(client.getId());
		clientVO.setSponsor(client.getSponsor());
		
		return clientVO;
	}
	
}
