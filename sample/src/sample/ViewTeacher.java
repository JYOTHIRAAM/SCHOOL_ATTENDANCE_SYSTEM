package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTeacher extends Teacher {
	public void viewTeach(String teacherName) throws SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost/t";
		String username = "root";
		String password = "raamsr@18";
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		String sql = "SELECT fid,teacherName,subject,attendanceStatus,date FROM teacherAttendance where teacherName=?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, teacherName);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next() == false) { 
				System.out.println("NO DATA PRESENT"); 
				return;
			}
			do{
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5));
			}while(resultSet.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}