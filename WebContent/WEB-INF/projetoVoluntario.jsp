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
			        <h2>PROJETOS</h2>
			    </div>
			    <div class="col-md-6">
			        <div class="input-group h2">
			            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar">
			            <span class="input-group-btn">
			                <button class="btn btn-primary" type="submit">
			                    <span class="glyphicon glyphicon-search"></span>
			                </button>
			            </span>
			        </div>
			    </div>
			    <div class="col-md-3">
			        <!-- <a ref="cadastroVoluntario.html" class="btn btn-primary pull-right h2"></a> -->
			    </div>
			</div>
		</div>
		<hr/>

		<div class="container">
			<div id="list" class="row">
    			<div class="table-responsive col-md-12">
        			<table class="table table-striped" cellspacing="0" cellpadding="0">
			            <thead>
			                <tr>
			                    <th>ID</th>
			                    <th>Nome Projeto</th>
			                    <th>ONG</th>
			                    <th class="actions">Ações</th>
			                 </tr>
			            </thead>
			            <tbody>
			 
			                <tr>
			                    <td>12</td>
			                    <td>Viver Bem</td>
			                    <td>Vidas</td>
			                    <td class="actions">
			                        <a class="btn btn-success btn-xs" href="#">Visualizar</a>
			                    </td>
			                </tr>
			 
			            </tbody>
			        </table>
     			</div>
 			</div>
		</div>

		<div class="container">
			<div id="list" class="row">
    			<div class="table-responsive col-md-4">
        			<label>Nome do Projeto:</label>
  	  				<p>Viver Bem</p>
  	  				<br>
  	  				<label>Areas de Atuação:</label>
  	  				<p>Saúde</p>
  	  				<br>
     			</div>
     			<div class="table-responsive col-md-4">
        			<label>Status do Projeto:</label>
  	  				<p>Ativo</p>
  	  				<br>
  	  				<label>Datas e Horarios de Trabalho:</label>
  	  				<p>(fazer a parte que recebe os dados)</p>
  	  				<br>
     			</div>
     			<div class="table-responsive col-md-4">
        			<label>Nome da ONG:</label>
  	  				<p>Bem Viver</p>
  	  				<br>
					<input class="btn btn-warning btn-md" type="submit" name="carregarONG" value="Visualizar ONG">
     			</div>
 			</div>
		</div>

		<hr/>

		<div class="container">
			<div id="list" class="row">
				<div class="table-responsive col-md-4">
					<input class="btn btn-primary btn-md" type="submit" name="candidatar" value="Candidatar-se">
				</div>
				<div class="table-responsive col-md-4">
					<input class="btn btn-danger btn-md" type="submit" name="sairDoProjeto" value="Sair do Projeto">
				</div>
			</div>
		</div>


		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>