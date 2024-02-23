package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddBookDetailsServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	   ServletException,IOException
	   {
		try
		{
			HttpSession hs=req.getSession(false);
			  if(hs==null)
			  {
				  req.setAttribute("msg", "Session expierd");
				  RequestDispatcher rd=req.getRequestDispatcher
						  ("Home.jsp");
				  rd.forward(req, res);
			  }
			  else
			  {
				  BookBean bb=new BookBean();
				  bb.setCode(req.getParameter("code"));
				  bb.setName(req.getParameter("name"));
				  bb.setAuthoer(req.getParameter("authoer"));
				  bb.setPrice(Integer.parseInt(req.getParameter("price")));
				  bb.setQty(Integer.parseInt(req.getParameter("qty")));
				  int k=new AddBookDetailsDAO().insert(bb);
				  if(k>0)
				  {
					  req.setAttribute("msg", "Books Updated Succesfully..<br>");
					  
				  }
				  RequestDispatcher rd=req.getRequestDispatcher
						  ("AddBookDetails.jsp");
				  rd.forward(req, res);
			  }	  
		}
		catch(Exception e)
		  {
			  req.setAttribute("msg", "Book Details Allrady Available..");
			  req.getRequestDispatcher("Error.jsp").forward(req, res);
		  }
		  
}
}
