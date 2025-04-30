package cargo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Usermainpage
 */
public class Usermainpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usermainpage() {
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
		String user_mobile = request.getParameter("user_mobile");
		String source = request.getParameter("source");
		String user_company = request.getParameter("user_company");
		String destination = request.getParameter("destination");
		String material = request.getParameter("material");
		String s="Pending";
		String quantity = request.getParameter("quantity");
		
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into booking_tbl values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,0);
			ps.setString(2,user_name);
			ps.setString(3,user_email);
			ps.setString(4,user_mobile);
			ps.setString(5,source);
			ps.setString(6,user_company);
			ps.setString(7,destination);
			ps.setString(8,material);
			ps.setString(9,s);
			ps.setString(10,quantity);
			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+"Data recorded successfully");
				response.sendRedirect("usermain.html");
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
