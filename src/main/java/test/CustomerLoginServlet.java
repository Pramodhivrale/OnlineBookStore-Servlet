package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/customerlog")
public class CustomerLoginServlet extends HttpServlet
{
	    private static final long serialVersionUID = 1L;

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	    {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String username = request.getParameter("uname");
	        String password = request.getParameter("pword");

	        // Check if username and password match a valid user
	        // For demonstration purposes, let's assume username is "admin" and password is "password"
	        if ("admin".equals(username) && "password".equals(password)) {
	            out.println("<html><body>");
	            out.println("<h2>Login Successful!</h2>");
	            out.println("<p>Welcome, " + username + "!</p>");
	            out.println("</body></html>");
	        } else {
	            out.println("<html><body>");
	            out.println("<h2>Login Failed!</h2>");
	            out.println("<p>Invalid username or password. Please try again.</p>");
	            out.println("</body></html>");
	        }
	    }
}



