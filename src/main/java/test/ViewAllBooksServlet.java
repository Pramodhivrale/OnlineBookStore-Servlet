package test;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/view1")
public class ViewAllBooksServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	   ServletException,IOException
	   {
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session expired...<br>");
			RequestDispatcher rd=req.getRequestDispatcher
					("Home.jsp");
			rd.forward(req, res);	
		}
		else
		{
			ArrayList<BookBean> al=new ViewAllBooksDAO().reterive();
			hs.setAttribute("alist", al);
			RequestDispatcher rd=req.getRequestDispatcher
					("ViewAllBooks.jsp");
			rd.forward(req, res);
			
		}
	   }

}
