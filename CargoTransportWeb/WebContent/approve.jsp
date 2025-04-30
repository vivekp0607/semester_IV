<%@page import="cargo.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	try
	{
		
		Connection con = ConnectDB.connect();
		int booking_id=Integer.parseInt(request.getParameter("booking_id"));
		String s="Approved";
		PreparedStatement ps = con.prepareStatement("update booking_tbl set booking_status=? where booking_id=?");
		ps.setString(1,s);
		ps.setInt(2,booking_id);
		int i = ps.executeUpdate();
		if(i>0)
		{
			System.out.println("Approve");
			response.sendRedirect("approveBooking.jsp");
		}
		else
		{
			System.out.println("Rejected");
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