<html>
<head>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="pragma" content="no-cache">
	<title>Favorite Websites</title>
	<style>
		.menu-head {font-size: 10pt; font-weight: bold; color: black; }
		.menu-item {font-size: 10pt;  color: black }
    </style>
</head>

<body>
<%@ page import="databeans.UserBean" %>

<table cellpadding="4" cellspacing="0">

	<!-- Spacer row -->
	<tr>
		<td bgcolor="#99FF99" style="font-size:5px">&nbsp;</td>
		<td colspan="2" style="font-size:5px">&nbsp;</td>
	</tr>
	
	<tr>
		<td bgcolor="#99FF99" valign="top" height="500">
			<!-- Navigation bar is one table cell down the left side -->
            <p align="left">
<%
    UserBean user = (UserBean) session.getAttribute("user");
	if (user == null) {
%>
				<span class="menu-item"><a href="login.do">Login</a></span><br/>
				<span class="menu-item"><a href="register.do">Register</a></span><br/>
<%
    } else {
%>
				<span class="menu-head"><%=user.getFirstName()%> <%=user.getLastName()%></span><br/>
				<span class="menu-item"><a href="manage.do">Manage Your Favorites</a></span><br/>
				<span class="menu-item"><a href="changepwd.do">Change Password</a></span><br/>
				<span class="menu-item"><a href="logout.do">Logout</a></span><br/>
				<span class="menu-item">&nbsp;</span><br/>
				
<%
    }    
	if (request.getAttribute("userList")!=null){
		%><h3>View these users' favorite sites:</h3><%
	for (UserBean u : (UserBean[])request.getAttribute("userList")) {
%>
			    <span class="menu-item">
					<a href="list.do?userID=<%=u.getUserID()%>">
						<%=u.getFirstName()%> <%=u.getLastName()%>
					</a>
				</span>
				<br/>
<%
		}
	}
    
%>
			</p>
		</td>
		
		<td>
			<!-- Padding (blank space) between navbar and content -->
		</td>
		<td  valign="top">

	
		
		
		

		
