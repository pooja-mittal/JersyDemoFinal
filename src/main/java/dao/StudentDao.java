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
	Student student;

	public StudentDao() {
		try {
			String connectionUrl = "jdbc:mysql://localhost:3306/student_service?useSSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudent() {
		List<Student> studentList = new ArrayList<>();
		
		try {
			String query = "select * from studentDao";
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
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;

	}

	public Student getStudent(int studentId) {
		String query = "select * from studentDao where studentId= " + studentId;
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
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void createNewStudent(Student s1) {
		String query = "insert into studentDao values(?,?,?,?)";
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
		String deleteQuery = "delete from studentDao where studentId=" + studentId;
		try {
			PreparedStatement preparestatement = connection.prepareStatement(deleteQuery);
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateStudentInfo(Student updateStudent) {
		//if id is not there return and display message you forgot to enter id parameter which is mandatory. 
		String updateQuery = "update studentDao set FirstName=?, LastName=? where studentId=? ";
		try {
			PreparedStatement updateStatement = connection.prepareStatement(updateQuery);			
			updateStatement.setString(1, updateStudent.getFirstName());
			updateStatement.setString(2, updateStudent.getLastName());
			updateStatement.setInt(3, updateStudent.getId());
			updateStatement.executeUpdate();
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

}
