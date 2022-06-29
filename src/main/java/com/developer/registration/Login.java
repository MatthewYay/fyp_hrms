package com.developer.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.developer.common.Global;
/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uemail=request.getParameter("username");
		String upwd=request.getParameter("password");
		Connection con=null;
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		
	con = DriverManager.getConnection("jdbc:mysql://"+ Global.serverName +":3306/"+ Global.databaseName +"?autoReconnect=true&serverTimezone=UTC&verifyServerCertificate=false&allowPublicKeyRetrieval=true&useSSL=false",Global.userName,Global.userPwd);
		
	// con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms_database?autoReconnect=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false","root","1234");
	//con = DriverManager.getConnection("jdbc:mysql://database-1.cjemoshbfjmx.us-west-2.rds.amazonaws.com:3306/HRMS_database?autoReconnect=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false","admin","Matthew31!");
		
		PreparedStatement  pst=con.prepareStatement("select * from staff where email = ? and password = ?");
		pst.setString(1, uemail);
		pst.setString(2, upwd);
		
		ResultSet rs=pst.executeQuery();
		if (rs.next()) {
			session.setAttribute("name", rs.getString("staff_name"));	
			session.setAttribute("staff_id", rs.getString("staff_id"));
			session.setAttribute("admin_access", rs.getInt("admin_access"));	
			dispatcher = request.getRequestDispatcher("index.jsp");
		}else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
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