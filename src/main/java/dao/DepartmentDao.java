package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.pojo.Department;

public class DepartmentDao {	
	Session session;
	Transaction trans;
	
	public DepartmentDao() {
		Configuration conf=new Configuration().configure("resources\\hibernate.cfg.xml").addAnnotatedClass(Department.class);
		ServiceRegistry reg=(ServiceRegistry) new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory factory=conf.buildSessionFactory(reg);
		session=factory.openSession();
		trans=(Transaction) session.beginTransaction();
	}
	
	public List<Department> getAllDeptDetail() {
		Query query=session.createQuery("from department");
		List<Department> deptList=query.list();
		trans.commit();
		for(Department d: deptList) {
			System.out.println(d);
		}		
		return deptList;		
	}
	
	public Department getParticularDeptDetail(int deptId) {
		Query query=session.createQuery("select * from department where departmentId ="+deptId);
		trans.commit();
		Department particularDept=(Department) query.uniqueResult();
		System.out.println(particularDept);
		return particularDept;
	}
	
	public void deleteParticularDept(int deptId) {
		Query query=session.createQuery("delete from department where departmentId ="+deptId);
		query.executeUpdate();
		trans.commit();		
	}
	
	public void createNewDepartment(int deptId) {
		Query query=session.createSQLQuery("insert into department values(?,?,?");
		query.executeUpdate();
		trans.commit();
	}
	
	
	

}
