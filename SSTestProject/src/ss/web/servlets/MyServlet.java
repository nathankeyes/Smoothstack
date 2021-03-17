package ss.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/welcome")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// basically a constructor
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");	
		PrintWriter pw = response.getWriter();
		
		// he copied his home.html file into a string and put it into print("")
		pw.print("<html><head><title>Success</title></head></html>");
		
		// RequestDispatcher rd = request.getRequestDispatcher("/path to file");
		// rd.forward(request, response);
		
		// auto generated
		// response.getWriter().append("Served at: ").append(request.getContextPath());


	}

	/** 
	 *  @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	  */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

	}

}
