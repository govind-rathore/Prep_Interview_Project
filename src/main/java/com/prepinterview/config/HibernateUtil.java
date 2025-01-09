package com.prepinterview.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prepinterview.entity.AptitudeTopic;
import com.prepinterview.entity.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(AptitudeTopic.class);

			sessionFactory = configuration.buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
