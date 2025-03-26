<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title>success page</title>
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
			<%
			String username = (String)session.getAttribute("username");
			
			if(username != null && username != ""){
				%>
				<h3>Welcome back ,<%=username %> </h3>
				<a href="logout.jsp">Logout</a>
				<%
			}
			else {
				%>
				<h3>Session expired...</h3>
				<a href="index.jsp">Go back</a>
				<%
			}
			%>
		</div>
	</body>
</html>
