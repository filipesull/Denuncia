<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro de pessoas</title>
</head>
<body>
	<div>
		<h1>Cadastro de clientes</h1>
		<p>Insira as informações nos campos abaixo</p>
		<br>
	</div>
<form action="${pageContext.request.contextPath }/ClienteAddServlet" method="GET">
		<fieldset style="width: 400px; margin-bottom: 10px">
			<div>
				<label><strong>Nome</strong></label><br/>
				<input type="text" name="nome"
					id="nome">
			</div><br/>
			<div>
				<label><strong>CPF</strong></label>
				<br/> <input type="text" name="cpf"
					id="cpf">
			</div><br/>
			<div>
				<label><strong>Email</strong></label>
				<br/> <input type="email"
					name="email" id="email">
			</div><br/>
			<div class="campo">
				<label for="bairro"><strong>Bairro</strong></label><br/>
				 <input
					type="text" name="bairro" id="bairro">
			</div><br/>
			<div class="campo">
				<label for="cidade"><strong>Cidade</strong></label><br/>
				 <input
					type="text" name="cidade" id="cidade">
			</div><br/>
			<div class="campo">
				<label for="estado"><strong>Estado</strong></label>
				<br/> <input
					type="text" name="estado" id="estado">
			</div><br/>
			<div class="campo">
				<label for="número"><strong>Número</strong></label><br/>
				 <input
					type="number" name="número" id="número">
			</div>
		</fieldset>
		<div>
		<input type="button" value="Voltar" onclick="window.location.href='/denunciaWeb'"> 
			<button type="submit">Concluído</button>
		</div>
	</form>
</body>
</html>
