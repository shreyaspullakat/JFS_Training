<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title>Landing page</title>
		<style>
			.center {
				display: flex;
				flex-direction: column;
				justify-content: center;
				align-items: center;
				height: 100vh;
			}
			form > input , form > div{
				margin: 5px;
			}
		</style>
	</head>
	<body>
		<div class="center">
			<h1>Login Page</h1>
			<form action="login.jsp" method="post">
				<input type="text" name="username" placeholder="User Name" required><br>
				<input type="email" name="email" placeholder="User Email" required><br>
				<input type="password" name="userpass" placeholder="User Password" required><br>
				<div>
					<button type="submit" class="btn btn-dark btn-sm">Login</button>
					<button type="reset" class="btn btn-dark btn-sm">Reset</button>
				</div>
			</form>
			<a href="register.jsp">Register</a>
		</div>
	</body>
</html>
