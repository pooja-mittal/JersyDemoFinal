package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.pojo.StudentWithDepartment;

public class StdntWithDeptDao {
	public Session setup() {
		Configuration conf = new Configuration().configure("com\\config\\hibernateJoin.cfg.xml")
				.addAnnotatedClass(StudentWithDepartment.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = conf.buildSessionFactory(reg);
		Session session = factory.openSession();
		return session;
		
	}
	
	public List<StudentWithDepartment> getAllDeptDetail() {
		Session session=setup();
		Transaction trans=session.beginTransaction();
		Query query=session.createSQLQuery("insert into studentwithdepartment(id, departmentName, firstName, hodName, lastName) select s.studentId, s.FirstName, s.LastName, d.departmentName, d.hodName from student as s join department as d on s.departmentId=d.departmentId");
		query.executeUpdate();
		List<StudentWithDepartment> stdntDeptList=query.list();
		for(StudentWithDepartment d: stdntDeptList) {
			System.out.println(d);
		}		
		trans.commit();
		return stdntDeptList;		
	}
	
}
