package loginpage;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servletpage1
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request,response);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		if(password.equals("kani"))
		{
			out.print("welcome"+name);
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
		}
		else
		{
			out.print("sorry, username or password error");
			//request.getParameter("login.html").include(request,response);\
			request.getRequestDispatcher("login.html").include(request,response);
		}               //value set to login page 
		out.close();
	}

		
	}

