package sample;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void role() throws SQLException {	
		System.out.print("ENTER THE ROLE(TEACHER or STUDENT) : ");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String str=s.toLowerCase();
		if(str.equals("teacher")) {
			Teacher t=new Teacher();
			t.select();
			sc.close();
		}
		else if(str.equals("student")){
			Scanner in=new Scanner(System.in);
			System.out.print("ENTER YOUR NAME: ");
			String studentName=in.nextLine();
			ViewStudent v=new ViewStudent(studentName);
			v.vStudent();
		}
		else {
			System.out.println("PLEASE ENTER CORRECT KEYWORD");
			role();
		}
	}
	public static void main(String args[]) throws SQLException {
		role();
	}
}