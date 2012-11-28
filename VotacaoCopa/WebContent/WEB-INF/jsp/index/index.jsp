<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
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
              <li class="active"><a href="<c:url value="/"/>">Home</a></li>
              <li><a href="votacao">Votar</a></li>
              <li><a href="resultados">Resultados</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    <div id="erros">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li><span class="label label-important">${error.category } ${error.message }</span></li>
			</c:forEach>
		</ul>
	</div>
    <h3><img  src="img/mascote.jpg">BEM VINDO AO SITE DE VOTAÇÃO DO MASCOTE DA COPA DE 2014</h3> 
    
    tecnologias usadas Vraptor, Hibernate, Mockito, Junit e SimpleCaptcha. Tela: Bootstrap e Jquery 
	<script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>