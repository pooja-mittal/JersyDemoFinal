package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.student.data.Student;

public class StudentDao {
	
	java.sql.Connection connection;
	static Statement statement;
	Student student = new Student();
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
				
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));
				studentList.add(student);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;

	}

	public Student getStudent(int studentId) {
		String query = "select * from student where studentId= " + studentId;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));
				
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return student;
	}

	public void createNewStudent(Student s1) {
		String query = "insert into student values(?,?,?,?)";
		try {
			PreparedStatement preparestatement = (PreparedStatement) connection.prepareStatement(query);
			preparestatement.setInt(1, s1.getId());
			preparestatement.setString(2, s1.getFirstName());
			preparestatement.setString(3, s1.getLastName());
			preparestatement.setInt(4, s1.getDeptId());
			preparestatement.executeUpdate();
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
	
	public void deleteStudent(int studentId) {
		String deleteQuery="delete from student where studentId="+studentId;
		try {
			PreparedStatement preparestatement=connection.prepareStatement(deleteQuery);
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Student updateStudentInfo(int studentId)  {
		String updateQuery="update student set FirstName=?, LastName=? where studentId= " + studentId;
		
		try {
			PreparedStatement updateStatement=connection.prepareStatement(updateQuery);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(studentId<=0) {
			return null;
		} else {
			
		}
	}
	
	

}
