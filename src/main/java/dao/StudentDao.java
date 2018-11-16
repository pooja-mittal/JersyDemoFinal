package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pojo.Student;

public class StudentDao {

	static Statement statement = null;
	Student student;
	PreparedStatement preparestatement = null;
	String connectionUrl = "jdbc:mysql://localhost:3306/student_service?useSSL=false";

	public StudentDao() {
	}

	public List<Student> getAllStudent() {
		Connection connection = null;
		List<Student> studentList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			String query = "select * from student";
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		Connection connection = null;
		student = new Student();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			statement = connection.createStatement();
			String query = "select * from student where studentId= " + studentId;
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setDeptId(resultSet.getInt(4));

			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
		Connection connection = null;
		student = new Student();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			String query = "insert into student values(?,?,?,?)";
			preparestatement = connection.prepareStatement(query);
			preparestatement.setInt(1, s1.getId());
			preparestatement.setString(2, s1.getFirstName());
			preparestatement.setString(3, s1.getLastName());
			preparestatement.setInt(4, s1.getDeptId());
			preparestatement.executeUpdate();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
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
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			String deleteQuery = "delete from student where studentId=" + studentId;
			preparestatement = connection.prepareStatement(deleteQuery);
			preparestatement.executeUpdate();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
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
		Connection connection = null;
		System.out.println("firstname " + updateStudent.getFirstName() + " lastname " + updateStudent.getLastName()
				+ " id " + updateStudent.getId());
		String updateQuery = "";
		System.out.println("query " + updateQuery);
		System.out.println("connection with jdbc ");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			preparestatement = connection
					.prepareStatement("update student set FirstName=?, LastName=?, departmentId=? where studentId=?");
			preparestatement.setString(1, updateStudent.getFirstName());
			preparestatement.setString(2, updateStudent.getLastName());
			preparestatement.setInt(3, updateStudent.getDeptId());
			preparestatement.setInt(4, updateStudent.getId());
			int row = preparestatement.executeUpdate();
			System.out.println("row effected " + row);
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					preparestatement.close();
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.getMessage();
			}

		}
	}

}
