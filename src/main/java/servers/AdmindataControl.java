package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.Admin;
import encapsulate.PatientEnc;
import jDBC.DAO;

/**
 * Servlet implementation class AdmindataControl
 */
@WebServlet("/AdmindataControl")
public class AdmindataControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmindataControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
          response.setContentType("text/html");
		
		PrintWriter pw= response.getWriter();
		
		String name=request.getParameter("n");
		
		String email=request.getParameter("em");
		
		String dob=request.getParameter("dob");
		
		String pass=request.getParameter("pass");
		
		Admin ad=new Admin(name, email, dob, pass);
		
		int K = DAO.InsertA(ad);
		
		if(K>0)
		{
			pw.print("<script>alert('Congradulations Successfully Registered..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("AdminLogin.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Sorry something went wrong..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("AdminRegister.html");
			rd.include(request, response);
		}
	}

}
