package log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Servlet implementation class login1
 */
@WebServlet("/login1")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation = request.getParameter("operation");
		login logiObject = new login();
		if (operation.equals("add")) 
		{		
			String firstname = request.getParameter("firstname");   
			String lastname = request.getParameter("lastname");
			String dob = request.getParameter("dob");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String cpassword = request.getParameter("c_password");
			// String timezome = request.getParameter("timezome");

			JSONObject result;
			try
			{
				result = logiObject.addlogin(firstname, lastname, dob, username, password, cpassword);
				response.getWriter().print(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}