package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddBookDetailsDAO 
{
	public int k=0;
	public int insert(BookBean bb)throws Exception
	{
		try
		{
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into book5 values(?,?,?,?,?)");
		     ps.setString(1, bb.getCode());
		     ps.setString(2, bb.getName());
			ps.setString(3, bb.getAuthoer());
				ps.setInt(4, bb.getPrice());
				ps.setInt(5, bb.getQty());
				k=ps.executeUpdate();
		     
		}
		catch(Exception e)
		{
			throw e;
			//e.printStackTrace();
		}
		return k;

}
}
