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
import jDBC.DAO;

/**
 * Servlet implementation class ShowD
 */
@WebServlet("/ShowD")
public class ShowD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowD() {
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
		
		List<Doctor> list = DAO.ShowD();
		
		obj.print("<link rel=\"stylesheet\" href=\"Deffect.css\">");
		
		obj.print("<h1 >Doctor Details</h1><hr>");
		
		obj.print("<table border='2px solid black'; width='100%' >");
		
		obj.print("<tr> <th>ID</th> <th>Name</th> <th>Email</th> <th>Mobile</th> <th>DOB</th> <th>Gender</th> <th>Qualification</th> <th>Year of Exp</th> <th>Salary</th> <th>Edit</th> <th>Delete</th> <th>Work</th> </tr>");
		
		for(Doctor dt: list)
			
	   obj.print("<tr><td>"+dt.getId()+"</td><td>"+dt.getName()+"</td><td>"+dt.getEmail()+"</td><td>"+dt.getMob()+"</td><td>"+dt.getDob()+"</td><td>"+dt.getGender()+"</td><td>"+dt.getDeg()+"</td><td>"+dt.getYoe()+"</td><td>"+dt.getSalary()+"</td><td>"+"<a href='EditD?id="+dt.getId()+"'> edit </a> </td> <td><a href='DeleteD?id="+dt.getId()+"'> delete </a></td> <td><a href='Dschedule?n="+dt.getName()+"'> view </a></td> </tr>");                                                                           
		
		obj.print("</table>");
		
		obj.print("<a href=\"AdminLogin.html\"><input type=\"submit\" id=\"bt\" value=\"LOG OUT\"></a>");
	}

}
