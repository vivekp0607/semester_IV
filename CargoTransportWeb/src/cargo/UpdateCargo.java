package cargo;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCargo
 */
public class UpdateCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCargo() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try{
			Connection con = ConnectDB.connect();
//			String source=Get.getsource();
//			String destination=Get.getdestination();
			String no = request.getParameter("no");
			int sr_no = Integer.parseInt(no);
			String departure_datetime = request.getParameter("departure_datetime");
			String arival_datetime = request.getParameter("arival_datetime"); 
			
			System.out.println(departure_datetime);
			System.out.println(arival_datetime);
			
			
        	
        	
        		PreparedStatement ps = con.prepareStatement("update addcargo_tbl set departure_datetime=? ,arival_datetime=? where sr_no=? ");
        		
        		ps.setString(1,departure_datetime);
        		ps.setString(2, arival_datetime);
        		ps.setInt(3, sr_no);
        		
        		System.out.println(departure_datetime);
        		System.out.println(arival_datetime);
        		
        		int i = ps.executeUpdate();
        		System.out.println(i);
        		if(i>0)
        		{
        			response.sendRedirect("admin_main.html");
        		}else
        		{
        			System.out.println("Failed to update");
        			response.sendRedirect("failed.html");
        		}
        		
        	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	

	


