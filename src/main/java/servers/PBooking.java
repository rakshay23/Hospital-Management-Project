package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encapsulate.PBook;
import encapsulate.PatientEnc;
import jDBC.DAO;

/**
 * Servlet implementation class PBooking
 */
@WebServlet("/PBooking")
public class PBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PBooking() {
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
		
		String pb=request.getParameter("pb");
		
		String date=request.getParameter("date");
		
		String time=request.getParameter("time");
		
		PBook pk= new PBook(name, pb, date, time);
		
		int K=DAO.bookP(pk);
		
		if(K>0)
		{
			pw.print("<script>alert('Congradulations Successfully Booked..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("PLogin.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Sorry something went wrong..!!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("PatientIn.html");
			rd.include(request, response);
		}
	}

}
