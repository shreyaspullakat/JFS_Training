<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title>UserList</title>
		<style>
			.center {
				display: flex;
				flex-direction: column;
				align-items: center;
				padding-top: 50px;
				height: 100vh;
			}
		</style>
	</head>
	<body>
		<div class="center">
			<h3>All users</h3>
			<%@page import="java.sql.ResultSet"%>
			<%@page import="java.sql.Statement"%>
			<%@page import="java.sql.SQLException" %>
			<%@page import="java.sql.Connection" %>
			<%@page import="java.sql.DriverManager" %>
			<%@page import="com.mysql.jdbc.Driver" %>
			
			
			<table class="table table-sm table-bordered" style="width: 50%;">
				<thead>
					<tr>
						<th>User Name</th>
						<th>User Email</th>
						<th>User Password</th>
					</tr>
				</thead>
				<tbody>
					<%
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select * from users");
						
						while(rs.next()){
							
							String username = rs.getString("username");
							String email = rs.getString("email");
							String userpass = rs.getString("userpass");
					%>
							<tr>
								<td><%=username %></td>
								<td><%=email %></td>
								<td><%=userpass %></td>
							</tr>
					<% } 
						}
						catch (Exception e) {
							e.getStackTrace();
						}
					%>
				</tbody>
			</table>
		</div>
	</body>
</html>
