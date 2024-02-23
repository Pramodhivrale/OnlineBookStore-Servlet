package test;

import static test.DbInfo.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	public static Connection con=null;
	private DbConnection() {}
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,upass);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
	}

}
