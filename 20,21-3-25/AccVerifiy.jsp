<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title>Verification</title>
		<style>
			.center {
				display: flex;
	            flex-direction: column;
	            align-items: center;
	            justify-content: center;
	            height: 100vh;
				}
		</style>
	</head>
	<body>
		<div class="center">
			<%@page import="java.sql.ResultSet"%>
			<%@page import="java.sql.PreparedStatement"%>
			<%@page import="java.sql.Connection"%>
			<%@page import="java.sql.SQLException"%>
			<%@page import="java.sql.DriverManager"%>
			<%@page import="com.mysql.jdbc.Driver" %>
			
			<%
				try {
					String url = "jdbc:mysql://localhost:3306/testdb";
					String name = "root";
					String pass = "root";
					
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					Connection con = DriverManager.getConnection(url, name, pass);
					
					String username = request.getParameter("username");
					String email = request.getParameter("email");
					String userpass = request.getParameter("userpass");
					
					String query1 = "SELECT * FROM users WHERE email = ?;";
					PreparedStatement ps = con.prepareStatement(query1);
					ps.setString(1, email);
					
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						%>
						<h3>User already present</h3>
						<a href="index.jsp">Login</a>
						<%
					}
					else {
						String query2 = "INSERT INTO users (username, email, userpass) VALUES ( ?, ?, ?);";
						ps = con.prepareStatement(query2);
						ps.setString(1, username);
						ps.setString(2, email);
						ps.setString(3, userpass);
						
						int rows = ps.executeUpdate();
						if(rows > 0){
							%>
							<h3>User added successfully</h3>
							<a href="index.jsp">Login</a>
							<%
						}
						else {
							%>
							<h3>Failed to add the user</h3>
							<a href="index.jsp">Login</a>
							<%
						}
						
					}
					
				}
				catch (SQLException e){
					e.printStackTrace();
				}
				
			%>
		</div>
	</body>
</html>


