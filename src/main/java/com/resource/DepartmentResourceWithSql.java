package com.resource;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.InvalidMappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.pojo.Department;


public class DepartmentResourceWithSql {
	static Session session;
	
	public static void main(String[] args) {	
		
//		dept.setdepartmentId(106);
//		dept.setDepartmentName("EE");
//		dept.setHodName("Usha");
		try {
			Configuration conf=new Configuration().configure("com\\configuration\\file\\hibernate.cfg.xml").addResource("com\\configuration\\file\\department.hbm.xml");
			ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
			SessionFactory factory=conf.buildSessionFactory(reg);
			 session=factory.openSession();
			 Transaction t=session.beginTransaction();
			 Department dept=new Department(106,"EE","Usha");
			 Integer pk=(Integer)session.save(dept);
			 System.out.println("primary key "+ pk);
				t.commit();
				session.evict(dept);
				session.close();
		}catch(InvalidMappingException e) {
			System.out.println(e.getMessage().toString());
		}
		
		
		
		
		
		
		
		
		
	
		
//		Query query=session.createQuery("from Department where departmentId=101");
		//this query.list is used when there are many output
//		List<Department>li=query.list();
//		for(Department d: li) {
//			System.out.println(d);
//		}
		
		//for single result
//		Department deptDetail=(Department) query.uniqueResult();
//		System.out.println(deptDetail);
//		trans.commit();
		
//		session.evict(dept);
		
	}
	
	public static void saveDept() {
		
	}
	
	
}
