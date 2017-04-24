<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>VOLUNG</title>

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
			    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			    		<span class="sr-only">Toggle navigation</span>
			    		<span class="icon-bar"></span>
			    		<span class="icon-bar"></span>
			    		<span class="icon-bar"></span>
			   		</button>
		   		<a class="navbar-brand" href="index.html">VOLUNG</a>
		  		</div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
              <li><a href="perfilGestor.html">Perfil</a></li>
              <li><a href="ongGestor.html">ONG</a></li>
              <li><a href="projetosGestor.html">Projetos</a></li>
              <li><a href="voluntariossGestor.html">Voluntarios</a></li>
            </ul>
          </div>
		 	</div>
		</nav>

		<br>

		<div id="main" class="container">
			<h2 class="page-header">Perfil Gestor</h2>
		</div>

		<div id="main" class="container">
			<form action="index.html">
  				<div class="row">
  	  				<div class="form-group col-md-6">
  	  					<label>Nome Completo:</label>
  	  					<p>${gestor.nome}</p>
  	  					<label>Email:</label>
  	  					<p>${gestor.email}</p>
  	  					<label>CPF:</label>
  	  					<p>${gestor.cpf}</p>
  	  					<label>Senha:</label>
  	  					<p>********</p>
  	  					<br>
  	  				</div>
				  </div>
				<hr/>
				<div class="row">
          <div class="form-group col-md-6">
            <p>.</p>
          </div>
					<div class="form-group col-md-6">
						<button type="submit" class="btn btn-warning">Editar Perfil</button>
					</div>
				</div>
			</form>
        </div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>