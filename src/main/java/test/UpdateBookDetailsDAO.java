package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBookDetailsDAO 
{
	public int k=0;
	public int update(BookBean bb)
	{
		try
		{
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update book5 set price=?,qty=? where code=?");
			ps.setInt(1, bb.getPrice());
			ps.setInt(2, bb.getQty());
			ps.setString(3, bb.getCode());
			k=ps.executeUpdate(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}

}
