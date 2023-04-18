package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.DBook;
import encapsulate.PBook;
import jDBC.DAO;

/**
 * Servlet implementation class ShowPBooking
 */
@WebServlet("/ShowPBooking")
public class ShowPBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPBooking() {
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
		
		List<PBook> li = DAO.PBookingShow(name);
		
		obj.print("<link rel=\"stylesheet\" href=\"Deffect.css\">");
		
		obj.print("<h1 >Patient Booking Details</h1><hr>");
		
		obj.print("<table border='2px solid black'; width='100%' >");
		
		obj.print("<tr> <th>Name</th> <th>Problem</th> <th>Date</th> <th>Time</th>  </tr>");
		
		for(PBook dt: li)
			
	   obj.print("<tr><td>"+dt.getName()+"</td><td>"+dt.getProblme()+"</td><td>"+dt.getDate()+"</td><td>"+dt.getTime()+"</td> </tr>");                                                                           
		
		obj.print("</table>");
		
		obj.print("<a href=\"AdminLogin.html\"><input type=\"submit\" id=\"bt\" value=\"LOG OUT\"></a>");
		
	}

	
}
