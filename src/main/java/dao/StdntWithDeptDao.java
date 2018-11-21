package dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.pojo.StudentWithDepartment;

public class StdntWithDeptDao {
	public Session setup() {
		Configuration conf = new Configuration().configure("com\\config\\hibernate.cfg.xml")
				.addAnnotatedClass(StudentWithDepartment.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = conf.buildSessionFactory(reg);
		Session session = factory.openSession();
		return session;
		
	}
	
	public void stdntJoinDept() {
		Session session=setup();
	
		
	}

}
