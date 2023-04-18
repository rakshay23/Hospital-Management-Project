package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.PatientEnc;
import jDBC.DAO;

/**
 * Servlet implementation class UpdateP
 */
@WebServlet("/UpdateP")
public class UpdateP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateP() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		   
		   String pass=request.getParameter("pass");
		   
		   PatientEnc df = new PatientEnc(id, name, email, mob, dob, gen, pass);
		   
		   int status= DAO.updateP(df);
		   
		   if(status>0)
		   {
			   pw.print("<script> alert('Data Succusssfully Updated')</script>");
			   RequestDispatcher rd= request.getRequestDispatcher("ShowP");
			   rd.include(request, response);
		   }
		   else
		   {
			   pw.print("<script> alert('Sorry something went wrong')</script>");
			   RequestDispatcher rd= request.getRequestDispatcher("EditP");
			   rd.include(request, response); 
		   }
	}


}
