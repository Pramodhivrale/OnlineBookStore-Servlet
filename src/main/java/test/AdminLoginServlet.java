package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/adminlog")
@SuppressWarnings("serial")
public class AdminLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	   ServletException,IOException
	   {
		AdminBean ab=new AdminLoginDAO().login
				(req.getParameter("uname"), req.getParameter("pword"));
		
		if(ab==null)
		{
			req.setAttribute("msg", "Invalid Login Process");
			RequestDispatcher rd=req.getRequestDispatcher
					("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher
					("AdminLogin.jsp").forward(req, res);
			
		}
	   }
	

}
