package ss.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter pw = response.getWriter();
		
		//StringBuffer desiredURL = new StringBuffer("http://localhost:8080/SSTestProject/Login?user=user&pass=pass");
		
		//pw.print(request.getRequestURL());
	
		String desiredURL = "http://localhost:8080/SSTestProject/Login?user=user&pass=pass";
		String url = request.getRequestURL()+"?"+request.getQueryString();
		
		if ( desiredURL.equals(url) ) {
			pw.print("<html><head><title>Success</title></head></html>");
			pw.print("Success");
		}
		else {
			pw.print("<html><head><title>Incorrect Username or Password</title></head></html>");
			pw.print("Incorrect Username or Password");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
