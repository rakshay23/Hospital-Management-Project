package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jDBC.DAO;

/**
 * Servlet implementation class DeleteD
 */
@WebServlet("/DeleteD")
public class DeleteD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.setContentType("text/html");
		
		PrintWriter pw= response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		int status=DAO.deleteD(id);
		
		if(status>0)
		{
			pw.print("<script> alert('Data Successfully deleted')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("ShowD");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script> alert('Sorry something went wrong !!')</script>");
			RequestDispatcher rd= request.getRequestDispatcher("ShowD");
			rd.include(request, response);
		}
	}

	

}
