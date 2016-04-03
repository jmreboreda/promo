package com.github.jmreboreda.promo.model.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.jmreboreda.promo.model.dao.GenericDaoHibernate;
import com.github.jmreboreda.promo.model.exceptions.daoexceptions.InstanceNotFoundException;

@Repository("clientDao")
@Transactional
public class ClientDaoHibernate extends GenericDaoHibernate<ClientVO,Long> implements ClientDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ClientVO findClientByName(String name) throws InstanceNotFoundException {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select p from PersonVO p where p.name=:name");
		query.setParameter("name", name);
		
		ClientVO person = (ClientVO) query.uniqueResult();
		
		if(person == null) {
			throw new InstanceNotFoundException(name, ClientVO.class.getSimpleName());
		}
		
		return person;
	}

	@Override
	public List<ClientVO> findAllClients() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from PersonVO");
		
		@SuppressWarnings("unchecked")
		List<ClientVO> personsVO = (List<ClientVO>) query.list();

		return personsVO;
	}
	
	@Override
	public List<ClientVO> findAdoptedsByClientId(Long id){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select p from ClientVO p where p.sponsorid=:id");
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<ClientVO> adopteds = (List<ClientVO>) query.list();
		
		return adopteds;
	}
}
