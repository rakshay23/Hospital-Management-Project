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
 * Servlet implementation class PdataController
 */
@WebServlet("/PdataController")
public class PdataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdataController() {
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
		
		String pass=request.getParameter("pass");
		
		PatientEnc pt=new PatientEnc(name,email,mob,dob,gen,pass);
		
		int K=DAO.InsertP(pt);
		
		if(K>0)
		{
			pw.print("<script>alert('Congradulations Successfully Registered..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("PLogin.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Sorry something went wrong..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("PRegister.html");
			rd.include(request, response);
		}
	}

}
