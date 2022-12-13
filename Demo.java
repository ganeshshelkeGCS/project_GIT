import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class Demo
{
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	static String query1 = "insert into BankCustomer values(?,?,?,?,?,?)";
	static String query2 = "select * from BankCustomer where depositDate <> (?,?)";   // and depositDate < ?";
	static String query3 = "select * from BankCustomer where depositDate > '2000-01-11' and depositDate < '2022-01-21'";
	
	public static void main(String args[]) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/technorbit", "root", "root");
			
			if(conn == null)
			{
				System.out.println("Connection NOT Establish....");
			}
			else
			{
				System.out.println("Conection Establish....");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			Scanner sc = new Scanner(System.in);
			
			ps = conn.prepareStatement(query2);
			
			// Date
			System.out.println("Enter the deposit Date ....");
			String str1 = sc.next();
			
			System.out.println("Enter the withdraw Date ....");
			String str2 = sc.next();
			
			java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("dd-MM-yyyy");
			java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("dd-MM-yyyy");
			
			java.util.Date ud1 = sdf1.parse(str1);
			java.util.Date ud2 = sdf2.parse(str2);
			
			long l1 = ud1.getTime();
			long l2 = ud2.getTime();
			
			java.sql.Date sd1 = new java.sql.Date(l1);
			java.sql.Date sd2 = new java.sql.Date(l2);
			System.out.println(sd1);
			System.out.println(sd2);
			
			ps.setDate(1, sd1);
			ps.setDate(2, sd2);
			
			/*
			ps.setInt(1, 12355);
			ps.setString(2, "Ganesh");
			ps.setInt(3, 3400);
			ps.setInt(4, 400);
			ps.setDate(5, sd1);
			ps.setDate(6, sd2);
			
			int row = ps.executeUpdate();
			
			System.out.println("Data Stored successfully... : " + row);
			*/
			
			rs = ps.executeQuery(query2);
			while(rs.next())
			{
				System.out.println(rs.getInt(1) +" "+rs.getString(2) +" "+ rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getDate(6));
			}
			
		}
		catch(SQLException sqle)
		{
			System.out.println("SqlException : " + sqle);
		}
		catch(Exception e)
		{
			System.out.println("Exception : " + e);
		}
		
	}
}
