package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.student.data.Department;

public class DepartmentResourceWithSql {
	
	public static void main(String[] args) {
		Department dept=new Department();
		Configuration conf=new Configuration().configure("resources\\hibernate.cfg.xml").addAnnotatedClass(Department.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory factory=conf.buildSessionFactory(reg);
		Session session= factory.openSession();	
//		session.save(dept);
		Transaction trans=session.beginTransaction();
		dept=(Department) session.get(Department.class, 101);
		trans.commit();
		System.out.println(dept);
//		session.evict(dept);
		
	}
	
}
