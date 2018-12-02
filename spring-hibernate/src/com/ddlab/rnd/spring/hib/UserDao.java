package com.ddlab.rnd.spring.hib;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserDao {
	HibernateTemplate template;

	public void setSessionFactory(SessionFactory factory) {
		template = new HibernateTemplate(factory);
	}

	public void saveEmployee(User user) {
		template.save(user);
	}
}