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
 * Servlet implementation class AddCargo
 */
public class AddCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCargo() {
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
		
		
		String source = request.getParameter("source");
		
		String destination = request.getParameter("destination");
		
		String arival_datetime = request.getParameter("arival_datetime");
		String departure_datetime = request.getParameter("departure_datetime");
		String capacity = request.getParameter("capacity");
		System.out.println(source);
		System.out.println(destination);
		try
		{
			Get.setsource(source);
			Get.setdestination(destination);
			Connection con = ConnectDB.connect();
			PreparedStatement ps = con.prepareStatement("insert into addcargo_tbl values(?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, source);
			ps.setString(3, destination);
			ps.setString(4, arival_datetime);
			ps.setString(5, departure_datetime);
			ps.setString(6, capacity);
			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println(i+" Added cargo Data successfully");
				response.sendRedirect("admin_main.html");
			}
			else
			{

				System.out.println("Data is not Added ...Failed..!!");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
