package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.InvalidMappingException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.pojo.Department;

public class DepartmentDaoWithMethod {

	public static Session setup() {
		Session session = null;
		try {
			Configuration conf = new Configuration().configure("com\\configuration\\file\\hibernate.cfg.xml")
					.addAnnotatedClass(Department.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties())
					.buildServiceRegistry();
			SessionFactory factory = conf.buildSessionFactory(reg);
			session = factory.openSession();
		} catch (InvalidMappingException e) {
			System.out.println(e.getMessage().toString());
		}
		
		return session;
	}
	
	public void createDept() {
		Session session =setup();
		Transaction createTrans = session.beginTransaction();
		Department dept = new Department(102, "ECE", "kaku");
		Integer pk = (Integer) session.save(dept);
		System.out.println("primary key " + pk);
		createTrans.commit();
		session.evict(dept);
	}
	
	public void updateDeptInfo() {
		Session session =setup();
		Transaction updateTrans = session.beginTransaction();
		Department dept = new Department(102, "ECE", "himanshu");
		session.saveOrUpdate(dept);
		// if all non primary we want to change then use update/merge(can be used with
		// select) otherwise use saveorupdate
		updateTrans.commit();
		session.evict(dept);
	}
	
	public void deleteDept(int departmentId) {
		Session session =setup();
		Transaction deletetrans=session.beginTransaction();
		Department dept=new Department();
		dept.setDepartmentId(departmentId);
		session.delete(dept);
		deletetrans.commit();
		session.close();
		System.out.println("delete succesffuly");
	}
	
	public void selectDept(int departmentId ) {
		Session session=setup();		
		Object obj=session.get(Department.class, departmentId);
		Department dept=(Department)obj;
		System.out.println("dept id "+ dept.getDepartmentId()+ " dept name "+ dept.getDepartmentName() + " Hod name "+ dept.getHodName());
		session.close();
		//there is no transaction command for select 
	}
	
	public void getListOFDept() {
		Session session=setup();	
		List<Department> list=session.createCriteria(Department.class).list();
		for(Department d: list) {
			System.out.println(d);
		}
	}

}
