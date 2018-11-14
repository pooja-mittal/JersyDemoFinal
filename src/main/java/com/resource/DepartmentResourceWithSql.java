package com.resource;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.pojo.Department;

public class DepartmentResourceWithSql {
	
	public static void main(String[] args) {
		Department dept=new Department();
		Configuration conf=new Configuration().configure("resources\\hibernate.cfg.xml").addAnnotatedClass(Department.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory factory=conf.buildSessionFactory(reg);
		Session session= factory.openSession();	
		Transaction trans=session.beginTransaction();
//		dept.setDepartmentId(105);
//		dept.setDepartmentName("ece");
//		dept.setHodName("deepti");
//		session.save(dept);	
		
		Query query=session.createQuery("from Department where departmentId=101");
		//this query.list is used when there are many output
//		List<Department>li=query.list();
//		for(Department d: li) {
//			System.out.println(d);
//		}
		
		//for single result
		Department deptDetail=(Department) query.uniqueResult();
		System.out.println(deptDetail);
		trans.commit();
		
//		session.evict(dept);
		
	}
	
}
