package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;

public class StudentDao {

	java.sql.Connection connection=null;
	static Statement statement=null;
	Student student;
	PreparedStatement preparestatement=null;

	public StudentDao() {
		try {
			String connectionUrl = "jdbc:mysql://localhost:3306/student_service?useSSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "pooja2016");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudent() {
		List<Student> studentList = new ArrayList<>();		
		try {
			String query = "select * from student";
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				student=new Student();
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));
				studentList.add(student);
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return studentList;

	}

	public Student getStudent(int studentId) {
		String query = "select * from student where studentId= " + studentId;
		student=new Student();
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	public void createNewStudent(Student s1) {
		student=new Student();
		String query = "insert into student values(?,?,?,?)";
		try {
			preparestatement = connection.prepareStatement(query);
			preparestatement.setInt(1, s1.getId());
			preparestatement.setString(2, s1.getFirstName());
			preparestatement.setString(3, s1.getLastName());
			preparestatement.setInt(4, s1.getDeptId());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparestatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteStudent(int studentId) {
		String deleteQuery = "delete from student where studentId=" + studentId;
		try {
			preparestatement = connection.prepareStatement(deleteQuery);
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparestatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateStudentInfo(Student updateStudent) {
		
		//if id is not there return and display message you forgot to enter id parameter which is mandatory. 
//		List<Student> studentList=getAllStudent();
//		if(!(studentList.contains(updateStudent.getId()))) {
//			System.out.println("To update student information, id parameter must pass. forgot to enter srudentId");
//			return;
//		} else {
		System.out.println("firstname "+ updateStudent.getFirstName()+ " lastname "+ updateStudent.getLastName() + " id " + updateStudent.getId());
			String updateQuery = "";
			System.out.println("query "+ updateQuery);
			System.out.println("connection with jdbc ");				
				try {				
					preparestatement = connection.prepareStatement("update student set FirstName=?, LastName=?, departmentId=? where studentId=?");
					preparestatement.setString(1, updateStudent.getFirstName());
					preparestatement.setString(2, updateStudent.getLastName());
					preparestatement.setInt(3, updateStudent.getDeptId());
					preparestatement.setInt(4, updateStudent.getId());
					int row=preparestatement.executeUpdate();
					System.out.println("row effected "+ row);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				try {
					if(connection!=null) {
						preparestatement.close();
						connection.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch(NullPointerException e) {
					e.getMessage();
				}
				
			}
		}
		

	

}
