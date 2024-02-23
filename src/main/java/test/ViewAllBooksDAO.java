package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllBooksDAO 
{
	ArrayList<BookBean> al=new ArrayList<BookBean>();
	public ArrayList<BookBean>reterive()
	{
		try
		{
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from book5");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BookBean bb=new BookBean();
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthoer(rs.getString(3));
				bb.setPrice(rs.getInt(4));
				bb.setQty(rs.getInt(5));
				al.add(bb);
				
			}
			ps.setString(1, null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return al;
	}

}
