package com.developer.leave;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.developer.common.Global;

/**
 * Servlet implementation class ApplyLeaveServlet
 */


public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con=null;
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;		
		String leave_type=request.getParameter("leavetype");
		String start_date=request.getParameter("startdate");
		String end_date=request.getParameter("enddate");
		String staff_id= session.getAttribute("staff_id").toString();
			
	//	PrintWriter out=response.getWriter();
	//	out.print( session.getAttribute("staff_id"));				
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://"+ Global.serverName +":3306/"+ Global.databaseName +"?autoReconnect=true&serverTimezone=UTC&verifyServerCertificate=false&allowPublicKeyRetrieval=true&useSSL=false",Global.userName,Global.userPwd);
		
		PreparedStatement  pst=con.prepareStatement("INSERT INTO leave_application (staff_id,leave_type,leave_start,leave_end,status) values (?,?,?,?,?) ");
		pst.setString(1, staff_id);
		pst.setString(2, leave_type);
		pst.setString(3, start_date);
		pst.setString(4, end_date);
		pst.setString(5, "0");		
		
		Boolean rs=pst.execute();
		if (rs) {
			//session.setAttribute("name", rs.getString("staff_name"));	
			//session.setAttribute("admin_access", rs.getInt("admin_access"));	
			dispatcher = request.getRequestDispatcher("index.jsp");
		}else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("leave.jsp");
		}
		dispatcher.forward(request, response);
				
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}