package cargo;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps = con.prepareStatement ("select * from user_tbl where user_email=? and user_password=?");
			ps.setString(1, user_email);
			ps.setString(2, user_password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				User.setEmail(user_email);
				System.out.println("user is logged in..!!");
				response.sendRedirect("usermain.html");
			}
			else
			{
				System.out.println("Wrong User email and Password");
				response.sendRedirect("userlogin.html");	
			 
			}
					
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
