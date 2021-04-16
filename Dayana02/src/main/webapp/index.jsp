<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>INICIO </title>
<link rel="icon" href="Imagenes/bank.ico">
<link rel="stylesheet" href="Style/style_index.css">
</head>

<body>
	<%
	String Usuario = request.getParameter("Usuario");
	String Pass = request.getParameter("Pass");

	if (Usuario == null) {
		Usuario = "";
		Pass = "";
	}
	%>

	<div class="login">
		<div class="login-triangle"></div>

		<h2 class="login-header">App Banco</h2>

		<form action="ControllerAcceso" method="post" class="login-container">
			<p>
				<input type="text" name="user" placeholder="User">
			</p>
			<p>
				<input type="password" name="pass" placeholder="Password">
			</p>
			<p>
				<input type="submit" value="Iniciar Sesion">
			</p>
		</form>
	</div>
</body>

</html>