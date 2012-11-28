<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultados</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
	      <div class="navbar-inner">
	        <div class="container">
	          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </a>
	          <div class="brand">Votação do Mascote da Copa</div>
	          <div class="nav-collapse collapse">
	            <ul class="nav">
	              <li><a href="<c:url value="/"/>">Home</a></li>
	              <li><a href="votacao">Votar</a></li>
	              <li class="active"><a href="resultados">Resultados</a></li>
	            </ul>
	          </div><!--/.nav-collapse -->
	        </div>
	      </div>
	    </div>
<table>
		<thead>
			<tr>
				<th>NOME</th>
				<th>VOTOS</th>
				<th>PORCENTAGEM</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mascoteTOList}" var="mascote">
				<tr>
					<td>${mascote.nome }</td>
					<td>${mascote.votos }</td>
					<td>${mascote.percVotos }%</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>