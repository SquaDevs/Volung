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
		 	</div>
		</nav>

		<br>

		<div id="main" class="container">
			<h2 class="page-header">Cadastrar Gestor</h2>
		</div>

		<div id="main" class="container">
			<form action="gestorController.do" method="post">
  				<div class="row">
              <div class="form-group col-md-3">
              </div>
  	  				<div class="form-group col-md-6">
  	  					<label>Nome Gestor:</label>
  	  					<input type="text" name="nomeGestor" class="form-control" placeholder="Digite o nome do gestor">
  	  					<br>
  	  					<label>CPF:</label>
  	  					<input type="number" name="cpfGestor" class="form-control" placeholder="Digite o cpf domgestor">
  	  					<br>
  	  					<label>Email:</label>
  	  					<input type="email" name="email" class="form-control" placeholder="Digite o email do gestor">
  	  					<br>
  	  					<label>Senha:</label>
  	  					<input type="password" name="senha" class="form-control" placeholder="Digite a senha">
  	  					<br>
  	  				</div>
  	  			</div>
  	  			<hr/>
  	  			<div class="row">
              <div class="form-group col-md-3">
                
              </div>
  	  				<div class="form-group col-md-6 text-center">
  	  					<button type="submit" class="btn btn-primary">Cadastrar-se</button>
  	  				</div>
  	  			</div>
  	  		</form>
		</div>

		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>