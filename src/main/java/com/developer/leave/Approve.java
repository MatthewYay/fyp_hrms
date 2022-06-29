package com.developer.leave;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.developer.common.Global;
import com.developer.model.LeaveRequest;

/**
 * Servlet implementation class Approve
 */
@WebServlet("/Approve")
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String leave_id=request.getParameter("id");
		
		Connection con=null;
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://"+ Global.serverName +":3306/"+ Global.databaseName +"?autoReconnect=true&serverTimezone=UTC&verifyServerCertificate=false&allowPublicKeyRetrieval=true&useSSL=false",Global.userName,Global.userPwd);
		PreparedStatement  pst=con.prepareStatement("update leave_application set status=1 where application_id=? ;");
		pst.setString(1, leave_id);	
		
		Boolean rs=pst.execute();
		if (rs) {			
			dispatcher = request.getRequestDispatcher("index.jsp");
		}else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("index.jsp");
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