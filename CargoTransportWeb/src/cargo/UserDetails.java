package cargo;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDetails
 */
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
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
		
		Connection con = ConnectDB.connect();
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		String user_mobile = request.getParameter("user_mobile");
		String user_company = request.getParameter("user_company");
		String user_address = request.getParameter("user_address");
		
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into user_tbl values(?,?,?,?,?,?)");
			ps.setString(1, user_name);
			ps.setString(2, user_email);
			ps.setString(3, user_password);
			ps.setString(4, user_mobile);
			ps.setString(5, user_company);
			ps.setString(6, user_address);
			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"Data recorded successfully");
				response.sendRedirect("userlogin.html");
			}
			else
			{
				System.out.println("something went wrong");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
