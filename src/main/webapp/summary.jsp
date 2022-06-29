<%
if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}
%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.developer.model.LeaveRequest" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Leave Request</title>

<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<link rel="stylesheet" href="css/style.css">

<style>
	tr{
	margin:10px;
	border-bottom:1px solid #ccc;
	}
	td1{
	white-space: nowrap;
	}
	
	table {
   width: 100%;
   border-collapse: collapse;
   border: 1px solid black;
}
th {
   height: 50px;
   border: 1px solid black;
}
td {
   border: 1px solid black;
}
	
.btn {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius:5%;
}	
	
	</style>
</head>
<body>

	<div class="main">
	

		<section class="signup">
			<div class="container">
	
		
			
			<a href="index.jsp"> <span class="iconify" style="float:right;margin:20px;" data-icon="zmdi:home" data-width="60"></span>
					 </a>
					 
					 	<a class="btn" href="leave.jsp" style="float:right;margin:20px;">Leave Request</a>
			
			
				<div class="signup-content">
					
					<div class="signup-form">					
					
						<h2 class="form-title">My Leave Requests</h2>	
		
					
				<% ArrayList<LeaveRequest> leavereq = (ArrayList)request.getAttribute("leaverelist"); %>	
					<table class="table">		
					<thead>
					<tr><th>Leave Type</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Status</th>
					</tr>
					
					</thead>
					<tbody>
					
					
				<% for (int i = 0; i < leavereq.size(); i++) { LeaveRequest lr1 = leavereq.get(i); out.print("<tr><td>" + lr1.getLeavetype() + "</td><td>" +  String.valueOf(lr1.getLeavestart()) + "</td><td>" +String.valueOf(lr1.getLeaveend()) + "</td><td>" + lr1.getLeavestatusmsg()+    "</td></tr>");} %>
				</tbody>
			
							</table>
						
						
					
						<form method="" action="" class="register-form"
							id="register-form">
							<div class="form-group">	
							
								
						
							
							
							
							</div>							
						</form>
					</div>
					
				</div>
			</div>
		</section>

	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	
<script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>


</body>
</html>