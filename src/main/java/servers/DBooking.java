package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.DBook;
import encapsulate.PBook;
import jDBC.DAO;

/**
 * Servlet implementation class DBooking
 */
@WebServlet("/DBooking")
public class DBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBooking() {
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
		
		String date=request.getParameter("date");
		
		String in=request.getParameter("in");
		
		String out=request.getParameter("out");
		
		String pc=request.getParameter("pc");
		
		DBook db= new DBook(name, date, in, out, pc);
		
		int K=DAO.scheduleD(db);
		
		if(K>0)
		{
			pw.print("<script>alert('Data Successesfully Submitted..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("DLogin.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Sorry something went wrong..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("DoctorIn.html");
			rd.include(request, response);
		}
	}

}
