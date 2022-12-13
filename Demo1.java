import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

class Demo
{
	static final String query1 = "insert into user values(?,?)";
	static final String query2 = "select * from employee where ename LIKE (?)";
	static final String query3 = "select MAX(esalary) from employee";
	static final String query4 = "select count(*) from employee";
	static final String query5 = "select * from employee where deptno=(?)";
	static final String query6 = "delete from employee where city=(?)";
	static final String query7 = "update employee set esalary=(?) where edept=(?)";
	
	public static void main(String args[])
	{
		//SQLInjection
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/technorbit", "root", "root");
			
			if(conn != null)
			{
				System.out.println("Connection Established....");
			}
			else
			{
				System.out.println("Connection Not Established....");
			}
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe);
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle);
		}
		
		
		//
		try
		{
			ps = conn.prepareStatement(query7);
			stmt = conn.createStatement();
			/* Q.1
			System.out.println("Enter the Initial Character.....");
			String str = sc.next();
			ps.setString(1, str);
			rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println("EID :  " + rs.getInt(1) + " Ename :  " + rs.getString(2) + " Esalary :  " + rs.getInt(3) + " Edept :  " + rs.getString(4) + " DEPTNO :  " + rs.getInt(5));
			}
			*/
			
			/* Q.2
			rs = ps.executeQuery();
			rs.next();
			int sal = rs.getInt(1);
			System.out.println("MAX Salary :" + sal);
			*/
			
			/* Q.3
			rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			System.out.println("Number of Records :" + count);
			
			*/
			
			/* Q.4
			System.out.println("Enter the Department Number : ");
			String s = sc.next();
			int depno = Integer.parseInt(s);
			ps.setInt(1, depno);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println("EID :  " + rs.getInt(1) + " Ename :  " + rs.getString(2) + " Esalary :  " + rs.getInt(3) + " Edept :  " + rs.getString(4) + " DEPTNO :  " + rs.getInt(5));
			}
			*/
			
			/* Q.5
			System.out.println("Enter the City Name : ");
			String s = sc.next();
			ps.setString(1, s);
			
			int a = ps.executeUpdate();
			System.out.println(a);
			*/
			
			System.out.println("Enter Dept Name : ");
			String str = sc.next();
			
			String query = "select esalary from employee where edept=" + "'" + str + "'";
			rs = stmt.executeQuery(query);
			rs.next();
			int salary = rs.getInt(1);
			System.out.println(salary);
			
			System.out.println("Enter How Many percentage you want to Hike : ");
			float value = Float.parseFloat(sc.next());
			float value1 = (value/100); 
			float value2 = (salary * value1);
			int finalans = (int)(salary + value2);
			
			ps.setInt(1, finalans);
			ps.setString(2, str);
			
			int row = ps.executeUpdate();
			System.out.println(row);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		//finally block
		finally
		{
			try
			{
				ps.close();
			}
			catch(SQLException npe)
			{
				System.out.println("NULL POinter : " + npe);
			}
			
			try
			{
				conn.close();
			}
			catch(SQLException npe)
			{
				System.out.println("NULL POinter : " + npe);
			}
		}
		
		
		
		
		/* 2nd try catch
		try
		{
			ps = conn.prepareStatement(query1);
			
			
			System.out.println("Enter the User Name : ");
			String str1 = sc.next();
			
			System.out.println("Enter the Password : ");
			String str2 = sc.next();
			
			ps.setString(1, str1);
			ps.setString(2, str2);
			
			int row = ps.executeUpdate();
			System.out.println("No of ROW : " + row);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	*/
	

	}
	
}
