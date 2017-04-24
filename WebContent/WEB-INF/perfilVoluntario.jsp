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
                        <li><a href="voluntarioController.do?acao=per">Perfil</a></li>
                        <li><a href="voluntarioController.do?acao=ong">ONGs</a></li>
                        <li><a href="voluntarioController.do?acao=pro">Projetos</a></li>
                    </ul>
              </div>
		 	</div>
		</nav>

		<br>

        <div id="main" class="container">
          <h2 class="page-header">Perfil Voluntario</h2>
        </div>

		<div id="main" class="container">
			<form action="index.html">
  				<div class="row">
  	  				<div class="form-group col-md-5">
  	  					<label>Nome Completo:</label>
  	  					<p>${voluntario.nome}</p>
  	  					<label>Endereço:</label>
  	  					<p>${voluntario.endereco}</p>
  	  					<label>Telefone:</label>
  	  					<p>${voluntario.telefone}</p>
  	  					<label>Email:</label>
  	  					<p>${voluntario.email}</p>
  	  					<label>Data de Nascimento:</label>
  	  					<p>${voluntario.dataNascimento}</p>
  	  					<label>CPF:</label>
  	  					<p>${voluntario.cpf}</p>
  	  					<label>Sexo</label>
  	  					<p>${voluntario.genero}</p>
  	  					<label>Senha:</label>
  	  					<p>********</p>
  	  					<br>
  	  				</div>
  	  				<div class="form-group col-md-3">
  	  					<div class="list-group">
    	  					<h4><label>Áreas de Atuação</label></h4>
    	  					<c:forEach var="area" items="${voluntario.listaDeAreas}">
    	  						<p>${area.nome}</p>
    	  					</c:forEach>
		                	<br>
		                  	<br>
		                  	<h4><label>Situação</label></h4>
	  	  	  				<p>${voluntario.situacao}</p>
		                  	<br>
	  	  				</div>
  	  				</div>
  	  				<div class="form-group col-md-4">
  	  					<h4><label>Dias e Horários Disponíveis</label></h4>
  	  					<p>(fazer a parte que recebe os dados)</p>
  	  					<br>
  	  					<br>
  	  				</div>
				</div>
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