package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.Doctor;
import encapsulate.PatientEnc;
import jDBC.DAO;


@WebServlet("/EditD")
public class EditD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditD() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		Doctor df= DAO.EditD(id);
		
		pw.print("<form  action='UpdateD' method='get'> ");
		
	     pw.print("<link rel=\"stylesheet\" href=\"update.css\">");
	     
	     pw.print("<h1 >Update Doctor Details</h1><hr>");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+df.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+df.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='em' value='"+df.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Mobile:</td> <td><input type='text' name='mob' value='"+df.getMob()+"'/></td></tr>");
	   	pw.print("<tr><td>DOB: </td> <td><input type='text' name='dob' value='"+df.getDob()+"'/></td></tr>");
	   	pw.print("<tr><td>Gender: </td> <td><input type='text' name='gen' value='"+df.getGender()+"'/></td></tr>");
	   	pw.print("<tr><td>Qualification: </td> <td><input type='text' name='deg' value='"+df.getDeg()+"'/></td></tr>");
	   	pw.print("<tr><td>Year of Exp: </td> <td><input type='text' name='yoe' value='"+df.getYoe()+"'/></td></tr>");
	   	pw.print("<tr><td>Salary: </td> <td><input type='text' name='sal' value='"+df.getSalary()+"'/></td></tr>");
	   	
	    pw.print("<tr><td><input type=\"submit\" id=\"bt\" value=\"UPDATE\"></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
		
		pw.print("<a href=\"AdminLogin.html\"><input type=\"submit\" id=\"bt\" value=\"LOG OUT\"></a>");
	}

	
}
