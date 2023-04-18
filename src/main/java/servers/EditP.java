package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.PatientEnc;
import jDBC.DAO;

/**
 * Servlet implementation class EditP
 */
@WebServlet("/EditP")
public class EditP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditP() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
         response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		PatientEnc df= DAO.EditP(id);
		
		pw.print("<form  action='UpdateP' method='get'> ");
		
		pw.print("<link rel=\"stylesheet\" href=\"update.css\">");
		
		pw.print("<h1 >Update Patient Details</h1><hr>");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+df.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+df.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='em' value='"+df.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Mobile:</td> <td><input type='text' name='mob' value='"+df.getMobile()+"'/></td></tr>");
	   	pw.print("<tr><td>DOB: </td> <td><input type='text' name='dob' value='"+df.getDOB()+"'/></td></tr>");
	   	pw.print("<tr><td>Gender: </td> <td><input type='text' name='gen' value='"+df.getGender()+"'/></td></tr>");
	   	pw.print("<tr><td>Password: </td> <td><input type='text' name='pass' value='"+df.getPassword()+"'/></td></tr>");
	   	
	   	pw.print("<tr><td><input type=\"submit\" id=\"bt\" value=\"UPDATE\"></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
		pw.print("<a href=\"AdminLogin.html\"><input type=\"submit\" id=\"bt\" value=\"LOG OUT\"></a>");
	}

	
	

}
