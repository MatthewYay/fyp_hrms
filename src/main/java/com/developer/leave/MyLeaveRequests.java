package com.developer.leave;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.developer.common.Global;
import com.developer.model.LeaveRequest;

/**
 * Servlet implementation class MyLeaveRequests
 */
public class MyLeaveRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		Connection con=null;
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		ArrayList<LeaveRequest> leavereList = new  ArrayList<LeaveRequest>();
		String staff_id=session.getAttribute("staff_id").toString();
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://"+ Global.serverName +":3306/"+ Global.databaseName +"?autoReconnect=true&serverTimezone=UTC&verifyServerCertificate=false&allowPublicKeyRetrieval=true&useSSL=false",Global.userName,Global.userPwd);
		PreparedStatement  pst=con.prepareStatement("SELECT * FROM leave_application where staff_id=? ;");
		pst.setString(1, staff_id);	
		ResultSet rs=pst.executeQuery();
		LeaveRequest lr;
		
		while(rs.next()) {
			lr=new LeaveRequest();
			lr.setStaff_id( rs.getInt("staff_id")  );
			lr.setLeavestart(rs.getDate("leave_start"));
			lr.setLeaveend(rs.getDate("leave_end"));
			lr.setLeavestatus(rs.getInt("status")  );
			lr.setLeavetypeid(rs.getInt("leave_type")  );
			leavereList.add(lr);
		}
	
		request.setAttribute("leaverelist", leavereList);	
		session.setAttribute("leaverelist", leavereList);	
			dispatcher = request.getRequestDispatcher("summary.jsp");
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