package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jDBC.DAO;

/**
 * Servlet implementation class AdminLoginControl
 */
@WebServlet("/AdminLoginControl")
public class AdminLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
	      PrintWriter obj= response.getWriter();
	      
	    String name=  request.getParameter("n");
	    
	    String pass=  request.getParameter("pass");
	    
	    boolean status=false;
	    
	    status=DAO.ALogin(name, pass);
	    
	    if(status)
	    {
	    	obj.print("<script>alert('Succussefully Login !!') </script>");
	    	RequestDispatcher rd=request.getRequestDispatcher("AdminView.html");
	    	rd.forward(request, response);
	    }
	    else
	    {
	    	obj.print("<script>alert('Username or Password is Invalid !!') </script>");
	    	RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.html");
	    	rd.include(request, response);
	    }
	}

}
