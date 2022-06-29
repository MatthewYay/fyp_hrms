<%
if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}
%>



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
	</style>
</head>
<body>

	<div class="main">
	

		<section class="signup">
			<div class="container">
			<a href="index.jsp"> <span class="iconify" style="float:right;margin:20px;" data-icon="zmdi:home" data-width="60"></span>
					 </a>
			
				<div class="signup-content">
					
					<div class="signup-form">
				
				
					
				
					
					
					
						<h2 class="form-title">Leave Request</h2>
					
						<form method="post" action="ApplyLeaveServlet" class="register-form"
							id="register-form">
							<div class="form-group">							
							
							<table>
							<tr> <td>Applicant</td> 
							<td><%=session.getAttribute("name")%></td></tr>
							
							<tr> <td>Leave Type</td> <td>
							<select class="classic" name="leavetype" id="leavetype">
									  <option value="1">Sick leave</option>
									  <option value="2">Casual leave</option>
									  <option value="3">Annual Leave</option>									 
									</select>
							
							</td></tr>
							
							<tr> <td>Leave Start Date</td>
							 <td><input type="date" id="startdate" name="startdate" > </td>
							 </tr>
							
								<tr> <td>Leave End Date</td>
							 <td><input type="date" id="enddate" name="enddate" > </td>
							 </tr>
							
							<tr> <td></td> 
							<td>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Apply Leave" />
							</div>
							</td></tr>							
							</table>
							</div>							
						</form>
					</div>
					<div class="signup-image" >
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>						
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