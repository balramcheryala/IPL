package com.bridgelabz.bridgembass.database.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import com.bridgelabz.bridgembass.database.model.AuthUser;

@Service
public class AuthUserDAO implements GenericDao<AuthUser, String> {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public AuthUser load(final String id) {
		return hibernateTemplate.load(AuthUser.class, id);
	}

	@Override
	public AuthUser get(final String id) {
		return hibernateTemplate.get(AuthUser.class, id);
	}

	@Override
	public List<AuthUser> getAll() {
		return hibernateTemplate.loadAll(AuthUser.class);
	}

	@Override
	public Serializable save(AuthUser object) {
		return hibernateTemplate.save(object);
	}

	@Override
	public void saveOrUpdate(AuthUser object) {
		hibernateTemplate.saveOrUpdate(object);

	}

	@Override
	public void delete(AuthUser object) {
		hibernateTemplate.delete(object);

	}

	@Override
	public Long count() {
		return new Long(hibernateTemplate.loadAll(AuthUser.class).size());
	}

	@Override
	public void flush() {
		hibernateTemplate.flush();

	}

}
