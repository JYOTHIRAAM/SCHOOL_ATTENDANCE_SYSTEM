package sample;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Teacher {
	private String teacherName;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public Teacher(String teacherName) {
		super();
		this.teacherName = teacherName;
	}
	public Teacher() {
		
	}
	public void addTeacher() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost/t";
        String username = "root";
        String password = "raamsr@18";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        String sql = "INSERT INTO teacher (teacherName) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, getTeacherName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public void teacherAttendance() throws SQLException {
		System.out.println("1.TO ADD TEACHER ENTER 'A' : ");
		System.out.println("2.TO ADD TEACHER ATTENDANCE ENTER 'TA' : ");
		System.out.println("3.TO VIEW TEACHER STATUS ENTER 'V' : ");
		System.out.println("4.TO MODIFY TEACHER STATUS ENTER 'M' : ");
		System.out.println("5.TO REMOVE TEACHER ENTER 'R' : ");
		Scanner scc=new Scanner(System.in);
		String x=scc.nextLine();
		x=x.toUpperCase();
		switch(x) {
		case "V":
			System.out.print("ENTER TEACHER NAME :");
			Scanner sc=new Scanner(System.in);
			String tName=sc.nextLine();
			sc.close();
			ViewTeacher vt=new ViewTeacher();
			vt.viewTeach(tName);
			break;
		case "TA":
			System.out.print("ENTER TEACHER NAME :");
			String teName=scc.nextLine();
			System.out.print("FACULTY ID: ");
			int fid=scc.nextInt();
			scc.nextLine();
			System.out.print("SUBJECT: ");
			String subject=scc.nextLine();
			System.out.print("ATTENDANCE STATUS: ");
			String attendanceStatus=scc.nextLine();
			System.out.print("DATE: ");
			String date=scc.nextLine();
//			scc.close();
			TeacherAttendance ta=new TeacherAttendance(fid,teName,subject,attendanceStatus,date);
			ta.addTeacherAttendance();
			break;
		case "A":
			System.out.print("ENTER TEACHER NAME :");
			Scanner in=new Scanner(System.in);
			String Name=in.nextLine();
			in.close();
			this.teacherName=Name;
			addTeacher();
			break;
		case "M":
			modifyTAttendance();
			break;
		case "R":
			deleteTAttendance();
			break;
			
		}
	}
	
	public void studentAttendance(String m) throws SQLException {
		if(m.equals("A")) {
			Scanner in=new Scanner(System.in);
			System.out.print("ENTER STUDENT ID: ");
			int studentId=in.nextInt();
			in.nextLine();
			System.out.print("ENTER STUDENT NAME: ");
			String studentName=in.nextLine();
			System.out.print("ENTER CLASS: ");
			String className=in.nextLine();
			System.out.print("ENTER SECTION: ");
			String section=in.nextLine();
			Student s=new Student(studentId,studentName,className,section);
			s.addStudent();
			
		}
		else {
			Scanner in=new Scanner(System.in);
			System.out.print("ENTER STUDENT ID: ");
			int studentId=in.nextInt();
			in.nextLine();
			System.out.print("ENTER STUDENT NAME: ");
			String studentName=in.nextLine();
			System.out.print("ENTER CLASS: ");
			String className=in.nextLine();
			System.out.print("ENTER SECTION: ");
			String section=in.nextLine();
			System.out.print("ENTER TEACHER ID: ");
			int tid=in.nextInt();
			in.nextLine();
			System.out.print("ENTER DATE: ");
			String date=in.nextLine();
			
//			LocalDate myObj = LocalDate.now();
//			String date=myObj.toString();
//			System.out.println(myObj);
			System.out.print("ENTER ATTENDANCE STATUS: ");
			String attendanceStatus=in.nextLine();
			StudentAttendance st=new StudentAttendance(tid,studentId,studentName,className,section,date,attendanceStatus);
			st.addStudentAttendance();
			
		}
	}
	public void modifyTAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("ENTER TEACHER NAME: ");
		String teacherName=in.nextLine();
		System.out.print("ENTER ATTENDANCE STATUS: ");
		String attendanceStatus=in.nextLine();
		in.close();
		TeacherAttendance st=new TeacherAttendance(teacherName,attendanceStatus);
		st.modifyTeacherAttendance();
			
	}
	public void deleteTAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("ENTER TEACHER NAME: ");
		String teacherName=in.nextLine();
		in.close();
		TeacherAttendance st=new TeacherAttendance(teacherName);
		st.deleteTeacherAttendance();
			
	}
	
	public void modifySAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("ENTER STUDENT ID: ");
		int studentId=in.nextInt();
		in.nextLine();
		System.out.print("ENTER ATTENDANCE STATUS: ");
		String attendanceStatus=in.nextLine();
		in.close();
		StudentAttendance st=new StudentAttendance(studentId,attendanceStatus);
		st.modifyStudentAttendance();
			
	}
	public void deleteSAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("ENTER STUDENT NAME: ");
		String studentName=in.nextLine();
		in.close();
		StudentAttendance st=new StudentAttendance(studentName);
		st.deleteStudentAttendance();
			
	}
	public void viewSAttendance()throws SQLException{
		ViewStudent v=new ViewStudent();
		v.viewStudentAttendance();
		
	}
	public void select() throws SQLException {		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.FOR STUDENT DETAILS ENTER S : ");
		System.out.print("2.FOR TEACHER DETAILS ENTER T : ");
		String s=sc.nextLine();
		String str=s.toUpperCase();
		if(str.equals("S")) {
			System.out.println("1.TO ADD STUDENT ENTER 'A' : ");
			System.out.println("2.TO ADD STUDENT ATTENDANCE ENTER 'SA' : ");
			System.out.println("3.TO MODIFY STUDENT ATTENDANCE ENTER 'M' : ");
			System.out.println("4.TO VIEW STUDENT ATTENDANCE ENTER 'V' : ");
			System.out.println("5.TO REMOVE STUDENT ENTER 'R' : ");
			String m=sc.nextLine();
			if(m.equals("M")) {
				modifySAttendance();
			}
			else if(m.equals("V")) {
				viewSAttendance();
			}
			else if(m.equals("A")||m.equals("SA")) {
				studentAttendance(m);
				
			}
			else if(m.equals("R")) {
				deleteSAttendance();
			}
			else {
				System.out.println("PLEASE ENTER VALID KEYWORDS");
				select();
			}
			
		}
		else if(str.equals("T")) {
			teacherAttendance();
		}
		else {
			System.out.println("PLEASE ENTER VALID KEYWORDS");
			select();
		}
	}
	
}