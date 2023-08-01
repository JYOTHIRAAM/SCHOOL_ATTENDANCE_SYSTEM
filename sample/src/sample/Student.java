package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
	public int studentId;
	public String studentName;
	public String className;
	public String section;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Student(int studentId, String studentName, String className, String section) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.className = className;
		this.section = section;
	}
	public void addStudent() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost/t";
        String username = "root";
        String password = "raamsr@18";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        String sql = "INSERT INTO student (studentId,studentName,className,section) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, getStudentId());
            statement.setString(2,getStudentName());
            statement.setString(3,getClassName());
            statement.setString(4,getSection());
//            statement.setDate(2, new java.sql.Date(attendance.getDate().getTime()));
//            statement.setBoolean(3,attendance.isPresent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}