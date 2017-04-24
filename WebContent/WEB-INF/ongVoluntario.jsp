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
			    		<li><a href="perfilVoluntario.html">Perfil</a></li>
			    		<li><a href="ongVoluntario.html">ONGs</a></li>
			    		<li><a href="projetoVoluntario.html">Projetos</a></li>
			   		</ul>
			  	</div>
		 	</div>
		</nav>

		<br>

		<div id="main" class="container">
			<h2 class="page-header">Nome Voluntario</h2>
		</div>

		<div id="main" class="container">
			<div id="top" class="row">
			    <div class="col-md-3">
			        <h2>ONGs</h2>
			    </div>
			    <div class="col-md-6">
			        <div class="input-group h2">
			            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar">
			            <span class="input-group-btn">
			                <button id="submitSearch" class="btn btn-primary" type="submit">
			                    <span class="glyphicon glyphicon-search"></span>
			                </button>
			            </span>
			        </div>
			    </div>
			</div>
		</div>
		<hr/>

		<div class="container">
			<div id="list" class="row">
			    <div class="table-responsive col-md-12">
			        <table id="ongs" class="table table-striped" cellspacing="0" cellpadding="0">
			            <thead>
			                <tr>
			                    <th>ID</th>
			                    <th>Nome ONG</th>
			                    <th>Telefone</th>
			                    <th>Status</th>
			                    <th class="actions">Ações</th>
			                 </tr>
			            </thead>
			            <tbody>
			            </tbody>
			         </table>
			     </div>
 			</div>
		</div>

		<hr/>

		<div class="container">
			<div id="list" class="row">
			    <div class="table-responsive col-md-4">
			    	<label>Nome da ONG:</label>
  	  				<p id="nome"></p>
  	  				<br>
  	  				<label>Razão Social:</label>
  	  				<p id="razaoSocial"></p>
  	  				<br>
  	  				<label>CNPJ:</label>
  	  				<p id="cnpj"></p>
  	  				<br>
  	  				<label>Endereço:</label>
  	  				<p id="endereco"></p>
  	  				<br>
  	  			</div>
			    <div class="table-responsive col-md-4">
					<label>Telefone:</label>
  	  				<p id="telefone"></p>
  	  				<br>
  	  				<label>Email:</label>
  	  				<p id="email"></p>
  	  				<br>
  	  				<label>Data Inicio das Atividades:</label>
  	  				<p id="dataInicio"></p>
  	  				<br>
  	  				<label>Status da ONG:</label>
  	  				<p id="situacao"></p>
  	  				<br>
  	  			</div>
  	  			<div class="table-responsive col-md-4">
  	  				<label>Lista de Projetos:</label>
  	  				<br>
  	  				<select class="form-control">
					</select>
					<br>
					<br>
					<input id="btnProj" class="btn btn-warning btn-md" type="button" name="carregarProjeto" value="Visualizar Projeto">

  	  			</div>
 			</div>
		</div>


		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/buscaOng.js"></script>
	</body>
</html>