package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.Doctor;
import jDBC.DAO;

/**
 * Servlet implementation class DoctordataControl
 */
@WebServlet("/DoctordataControl")
public class DoctordataControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctordataControl() {
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
		
		String mob=request.getParameter("mob");
		
		String dob=request.getParameter("dob");
		
		String gen=request.getParameter("gen");
		
		String deg=request.getParameter("deg");
		
		int yoe=Integer.parseInt(request.getParameter("yoe"));
		
		double sal=Double.parseDouble(request.getParameter("sal"));
		
		String pass=request.getParameter("pass");
		Doctor se=new Doctor(name, email, mob, dob, gen, deg, yoe, sal, pass);
		    
		   int K= DAO.InsertD(se);
		   
		if(K>0)
		{
			pw.print("<script>alert('Congradulations Successfully Registered..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("DLogin.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Sorry something went wrong..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("DRegister.html");
			rd.include(request, response);
		}
	}

}
