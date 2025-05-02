<%@page import="cargo.*"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Booking</title>
</head>
<body>
<%

	try
	{
		String user_name = request.getParameter("user_name");
		Connection con = ConnectDB.connect();
		PreparedStatement ps = con.prepareStatement("delete from booking_tbl where user_name=?");
		ps.setString(1,user_name);
		int i = ps.executeUpdate();
		if(i>0)
		{
			System.out.println("Deleted ");
			response.sendRedirect("viewCargo.jsp");
		}
		else
		{
			System.out.println("Not deleted");
			response.sendRedirect("viewCargo.jsp");
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

%>

</body>
</html>