package test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	   ServletException,IOException
	   {
		  HttpSession hs=req.getSession(false);
		  if(hs==null)
		  {
			  req.setAttribute("msg", "Session expired");
			  RequestDispatcher rd=req.getRequestDispatcher
					  ("Home.jsp");
			  rd.forward(req, res);
		  }
		  else
		  {
			  String bCode=req.getParameter("bcode");
			  @SuppressWarnings("unchecked")
			ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("alist");
			  BookBean bb= null;
			  Iterator<BookBean> it=al.iterator();
			  while(it.hasNext())
			  {
				  bb=it.next();
				  if(bCode.equals(bb.getCode()))
				  {
					  break;
				  }
			  }
			  req.setAttribute("bbean", bb);
			  req.getRequestDispatcher("EditBookDetails.jsp").forward(req, res);
			
		  }

}
}
