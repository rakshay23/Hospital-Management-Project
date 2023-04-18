package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.DBook;
import encapsulate.Doctor;
import jDBC.DAO;

/**
 * Servlet implementation class Dschedule
 */
@WebServlet("/Dschedule")
public class Dschedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dschedule() {
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
		
		String name=request.getParameter("n");
		
		List<DBook> ob = DAO.ShowDschedule(name);
		
		obj.print("<link rel=\"stylesheet\" href=\"Deffect.css\">");
		
		obj.print("<h1 >Doctor Work Details</h1><hr>");
		
		obj.print("<table border='2px solid black'; width='100%' >");
		
		obj.print("<tr> <th>UserName</th> <th>Date</th> <th>In Time</th> <th>Out Time</th> <th>Total Patient Checked</th> </tr>");
		
		for(DBook dt: ob)
			
	   obj.print("<tr><td>"+dt.getName()+"</td><td>"+dt.getDate()+"</td><td>"+dt.getIn()+"</td><td>"+dt.getOut()+"</td><td>"+dt.getNp()+"</td> </tr>");                                                                           
		
		obj.print("</table>");
		
		obj.print("<a href=\"AdminLogin.html\"><input type=\"submit\" id=\"bt\" value=\"LOG OUT\"></a>");
		
       	
	}

}
