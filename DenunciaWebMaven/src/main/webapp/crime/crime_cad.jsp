<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro de crimes</title>
</head>
<body>
	<div>
		<h1>Cadastro de tipos de crime</h1>
		<p>Insira as informações nos campos abaixo</p>
		<br>
	</div>
<form action="${pageContext.request.contextPath }/CrimeAddServlet" method="GET">
		<fieldset style="width: 400px; margin-bottom: 10px">
			<div>
				<label><strong>Descrição</strong></label><br/>
				<input type="text" name="descricao"
					id="descricao">
			</div>
		</fieldset>
		<div>
		<input type="button" value="Voltar" onclick="window.location.href='/denunciaWeb'"> 
			<button type="submit">Concluído</button>
		</div>
	</form>
</body>
</html>
