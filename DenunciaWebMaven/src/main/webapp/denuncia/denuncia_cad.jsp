<!doctype html>
<%@page import="java.util.ArrayList"%>
<%@page import="br.projetodenunciaweb.entidade.Crime"%>
<%@page import="br.projetodenunciaweb.servicos.ServicoCrime"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>CADASTRO DE DENUNCIAS</title>
</head>
<body class="bg-light">

	<div class="container">
		<main>
			<div class="py-5 text-center">
				<h2>CADASTRO DE DENUNCIAS</h2>
				<p class="lead">Nessa tela você deve inserir as informações da
					sua denúncia.</p>

			</div>

			<div class="row g-5">

				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">Denuncia</h4>
					<form class="needs-validation"
						action="<%=request.getContextPath()%>/DenunciaSalvarServlet" method="get"
						novalidate>
						<div class="row g-3">
							<div class="row g-3">
								<div class="col-sm-6">
									<label for="local" class="form-label">LOCAL</label><br> <input
										type="text" class="form-control" id="local" name="local"
										placeholder="local" value="" required>
									<div class="invalid-feedback">Insira o local do ocorrido</div>
								</div>
							</div>
							<div class="col-sm-6">
								<label for="data_Hora" class="form-horizontal">DATA E
									HORA</label><br> <input type="datetime-local"
									class="form-horizontal" id="data_Hora" name="dataHora"
									placeholder="data_Hora" value="" required>
								<div class="invalid-feedback">Insira a data e a hora</div>
							</div>



							<div class="col-md-5">
								<label for="tipoViolenciaL" class="form-label">TIPO DE
									CRIME PRATICADO</label><br> 
									<select id="tipoViolenciaL" name="tipoViolencia">
									<option>Selecione...</option>
									<%
									ServicoCrime crimeServico = new ServicoCrime();
									ArrayList<Crime> crimes = new ArrayList<Crime>();
									crimes = crimeServico.listarCrimes();

									for (Crime e : crimes) {
									%><option>
										<%=e.getDescricao()%>
									</option>
									<%
									}
									%>
								</select>
								<div class="invalid-feedback">Insira o tipo do crime
									praticado!</div>
							</div>



							<div class="col-md-5">
								<label for="etniaF" class="form-label">ETNIA DO AGRESSOR</label><br>
								<select class="form-select" id="etniaL" name="etnia" required>
									<option value="">Selecione...</option>
									<c:forEach items="${listEtnias}" var="etniaF">
										<option value="${etniaF}">${etniaF}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Insira a etnia do agressor!</div>
							</div>



							<div class="col-md-5">
								<label for="grauL" class="form-label">GRAU DE
									PROXIMIDADE DO AGRESSOR COM A VÍTIMA</label><br>
									<select
									class="form-select" id="grauL" name="proximidade" required>
									<option value="">Selecione...</option>
									<c:forEach items="${listGrauProximidade}" var="grauF">
										<option value="${grauF}">${grauF}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Insira a proximidade do
									agressor com a vítima!</div>
							</div>

							<div class="col-md-5">
								<label for="alturaL" class="form-label">ALTURA DO
									AGRESSOR</label><br>
									 <select class="form-select" id="alturaL" name="altura"
									required>
									<option value="">Selecione...</option>
									<c:forEach items="${listTipoAltura}" var="alturaF">
										<option value="${alturaF}">${alturaF}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Insira a altura do agressor!</div>
							</div>

							<hr class="my-4">
							<input type="button" value="Voltar"
								onclick="window.location.href='/denunciaWeb'">
							<button class="w-50 btn btn-primary btn-lg" type="submit">Salvar
								Cadastro</button>
					</form>
				</div>
			</div>
	</div>
	</main>
</body>
</html>