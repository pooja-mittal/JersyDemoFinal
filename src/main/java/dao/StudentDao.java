package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.PreparedStatement;
import com.student.data.Student;

public class StudentDao {
	Connection connection = null;

	public StudentDao() {
		try {
			String connectionUrl = "jdbc:mysql://hostname:3306/student_service?useSSL=false";
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
		String query = "select * from student";
		try {
			java.sql.Statement statemant = connection.createStatement();
			ResultSet resultSet = statemant.executeQuery(query);
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));
				studentList.add(student);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return studentList;

	}

	public Student getStudent(int studentId) {
		String query = "select * from student where id= " + studentId;
		Student student = new Student();
		try {
			Statement statemant = (Statement) connection.createStatement();
			ResultSet resultSet = statemant.executeQuery(query);
			if (resultSet.next()) {
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}
	
	public void createNewStudent(Student s1) {
		String query="insert into student values(?,?,?,?)";
		try {
			PreparedStatement statement=(PreparedStatement) connection.prepareStatement(query);
			statement.setInt(1, s1.getId());
			statement.setString(2, s1.getFirstName());
			statement.setString(3, s1.getLastName());
			statement.setInt(4, s1.getDeptId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				
	}

}
