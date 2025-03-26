<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title>Login page</title>
		<style>
			.center {
				display: flex;
				flex-direction: column;
				justify-content: center;
				align-items: center;
				height: 100vh;
			}
		</style>
	</head>
	<body>
		<div class="center">
			<%@page import="java.sql.ResultSet"%>
			<%@page import="java.sql.PreparedStatement"%>
			<%@page import="java.sql.SQLException" %>
			<%@page import="java.sql.Connection" %>
			<%@page import="java.sql.DriverManager" %>
			<%@page import="com.mysql.jdbc.Driver" %>
			<% 
				try {
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					
					String url = "jdbc:mysql://localhost:3306/testdb";
					String name = "root";
					String pass = "root";
					
					Connection con = DriverManager.getConnection(url, name, pass);
					
					String email = request.getParameter("email");
					String userpass = request.getParameter("userpass");
					
					String query = "SELECT * FROM users WHERE email = ? AND userpass = ?;";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, email);
					ps.setString(2, userpass);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						session.setAttribute("userid", rs.getInt("userid"));
						session.setAttribute("username", rs.getString("username"));
						
						response.sendRedirect("Success.jsp");
					}
					else {
						%>
						<h3>User not found...</h3>
						<a href='index.jsp'>Login</a>
						<%
					}
				}
				catch (SQLException e){
					e.getStackTrace();
				}
			%>
		</div>
	</body>
</html>


