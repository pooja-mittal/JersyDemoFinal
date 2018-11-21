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

	public Session setup() {
		Session session = null;
		try {
//			ClassLoader classLoader = this.getClass().getClassLoader();
//			File file=new File(classLoader.getResource("hibernate.cfg.xml").getFile());
//			
//			System.out.println("file "+ file.exists());
			Configuration conf = new Configuration().configure("com\\config\\hibernate.cfg.xml")
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
	
	public Department createDept(Department newDept) {
		Session session =setup();
		Transaction createTrans = session.beginTransaction();
		Department dept = new Department(newDept.getDepartmentId(), newDept.getDepartmentName(), newDept.getHodName());
		Integer pk = (Integer) session.save(dept);
		System.out.println("primary key " + pk);
		createTrans.commit();
		session.evict(dept);
		return dept;
	}
	
	public void updateDeptInfo(Department updateDepartment) {
		Session session =setup();
		Transaction updateTrans = session.beginTransaction();
		Department dept = new Department(updateDepartment.getDepartmentId(), updateDepartment.getDepartmentName(), updateDepartment.getHodName());
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
	
	public Department selectDept(int departmentId ) {
		Session session=setup();		
		Object obj=session.get(Department.class, departmentId);
		Department dept=(Department)obj;
		System.out.println("dept id "+ dept.getDepartmentId()+ " dept name "+ dept.getDepartmentName() + " Hod name "+ dept.getHodName());
		session.close();
		//there is no transaction command for select 
		return dept;
	}
	
	public List<Department> getListOFDept() {
		Session session=setup();	
		List<Department> list=session.createCriteria(Department.class).list();
		for(Department d: list) {
			System.out.println(d);
		}
		return list;
	}

}
