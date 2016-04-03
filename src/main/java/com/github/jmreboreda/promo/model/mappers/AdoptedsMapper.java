package com.github.jmreboreda.promo.model.mappers;

import com.github.jmreboreda.promo.model.client.Client;
import com.github.jmreboreda.promo.model.client.ClientVO;

public class AdoptedsMapper {

	public static Client proccessVOBO(ClientVO adoptedVO) {
		
		if(adoptedVO == null) {
			return null;
		}
		
		Client adopted = new Client();
		
		adopted.setId(adoptedVO.getId());
		adopted.setSponsor(adoptedVO.getSponsor());
		
		return adopted;
	}
	
	public static ClientVO proccessBOVO(Client adopted, ClientVO client) {
		
		if(adopted == null) {
			return null;
		}
		
		ClientVO adoptedVO = new ClientVO();
		
		adoptedVO.setId(adopted.getId());
		adoptedVO.setSponsor(client.getSponsor());
	
		return adoptedVO;
	}
	
}
