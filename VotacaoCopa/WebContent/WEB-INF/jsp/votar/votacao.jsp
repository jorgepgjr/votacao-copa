<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Votação</title>
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
</head>
<body>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.min.js"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="brand">Votação do Mascote da Copa</div>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="<c:url value="/"/>">Home</a></li>
						<li class="active"><a href="<c:url value="/votacao"/>">Votar</a></li>
						<li><a href="<%=request.getContextPath()%>/resultados">Resultados</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
		<div id="erros">
			<ul>
				<c:forEach items="${errors}" var="error">
					<li><span class="label label-important">${error.category } - ${error.message }</span></li>
				</c:forEach>
			</ul>
		</div>	
		<c:if test="${not empty mensagem}">
			<span class="label label-success"> ${mensagem}</span>
		</c:if>
		<h1>Copa do Mundo 2014</h1>
		<h5>Escolha o melhor nome para o mascote</h5>
		<form action="<%=request.getContextPath()%>/votar/votar" method="post">
			<input type="radio" name="mascoteTO.nome" value="Amijubi"checked="checked">Amijubi<br> 
			<input type="radio"	name="mascoteTO.nome" value="Fuleco">Fuleco<br> 
			<input type="radio" name="mascoteTO.nome" value="Zuzeco">Zuzeco
			<img src="<c:url value="/stickyImg"/>"  id="captchaImage"/> <br>
			<input type="text" name="mascoteTO.captcha" value="" class="required"/>
			<button type="submit">Votar!</button>
		</form>

	</div>
	<!-- /container -->

</body>
</html>