package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.Doctor;
import encapsulate.PatientEnc;
import jDBC.DAO;

/**
 * Servlet implementation class ShowP
 */
@WebServlet("/ShowP")
public class ShowP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
			
			PrintWriter obj = response.getWriter();
			
			List<PatientEnc> list = DAO.ShowP();
			
			obj.print("<link rel=\"stylesheet\" href=\"Deffect.css\">");
			
			obj.print("<h1 >Patient Details</h1><hr>");
			
			obj.print("<table border='2px solid black'; width='100%' >");
			
			obj.print("<tr> <th>ID</th> <th>Name</th> <th>Email</th> <th>Mobile</th> <th>DOB</th> <th>Gender</th> <th>Edit</th> <th>Delete</th> <th>Appointmwnt Details</th> </tr>");
			
			for(PatientEnc dt: list)
				
		   obj.print("<tr><td>"+dt.getId()+"</td><td>"+dt.getName()+"</td><td>"+dt.getEmail()+"</td><td>"+dt.getMobile()+"</td><td>"+dt.getDOB()+"</td><td>"+dt.getGender()+"</td><td>"+"<a href='EditP?id="+dt.getId()+"'> Edit </a> </td> <td><a href='DeleteP?id="+dt.getId()+"'> delete</a></td> <td><a href='ShowPBooking?n="+dt.getName()+"'> View</a></td> </tr>");                                                                          
			
			obj.print("</table>");
			
			obj.print("<a href=\"AdminLogin.html\"><input type=\"submit\" id=\"bt\" value=\"LOG OUT\"></a>");
	}

}
