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
 * Servlet implementation class UpdateD
 */
@WebServlet("/UpdateD")
public class UpdateD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		   
		   PrintWriter pw= response.getWriter();
		   
		   int id=Integer.parseInt(request.getParameter("id"));
		   
		   String name=request.getParameter("name");
		   
		   String email=request.getParameter("em");
		   
		   String mob=request.getParameter("mob");
		   
		   String dob=request.getParameter("dob");
		   
		   String gen=request.getParameter("gen");
		   
		   String doj=request.getParameter("deg");
		   
		   int yoe=Integer.parseInt(request.getParameter("yoe"));
		   
		   double sal=Double.parseDouble(request.getParameter("sal"));
		   
		   Doctor df= new Doctor(id, name, email, mob, dob, gen, doj, yoe, sal);
		   
		   int status= DAO.updateD(df);
		   
		   if(status>0)
		   {
			   pw.print("<script> alert('Data Succusssfully Updated')</script>");
			   RequestDispatcher rd= request.getRequestDispatcher("ShowD");
			   rd.include(request, response);
		   }
		   else
		   {
			   pw.print("<script> alert('Sorry something went wrong')</script>");
			   RequestDispatcher rd= request.getRequestDispatcher("EditD");
			   rd.include(request, response); 
		   }
	}


}
