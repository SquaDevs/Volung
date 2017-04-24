$(document).ready(function(){
	
	$('#submitSearch').click(function(){
		$.ajax({
			type : 'GET',
			url : 'osController.do?acao=buscaTodos',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			success : function(resultado) {
				var listaOs = jQuery.parseJSON(resultado);
				
				$('#ongs tbody').empty();
				
				for(var i=0; i < listaOs.length; i++){
					$('#ongs tbody').append(
						'<tr><td name="id">'+ listaOs[i].id +'</td>'+
							'<td name="nome">'+ listaOs[i].nome +'</td>'+
							'<td name="telefone">'+ listaOs[i].telefone +'</td>'+
							'<td name="situacao">'+ listaOs[i].situacao +'</td>'+
							'<td class="actions">'+
	                        	'<button class="btn btn-success btn-xs">Visualizar</button>'+
		                    '</td></tr>'
					);
					
				}
			},
		});
	});
	
	$('tbody').on("click", "td.actions button", function() {
		var id = $(this).parent().parent().children('td[name=id]').text();
		
		$.ajax({
			type : 'GET',
			url : 'osController.do?acao=busca',
			data : {id: id},
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			success : function(resultado) {
				var os = jQuery.parseJSON(resultado);
				
				$('#nome').text(os.nome);
				$('#razaoSocial').text(os.razaoSocial);
				$('#cnpj').text(os.cnpj);
				$('#endereco').text(os.endereco);
				$('#telefone').text(os.telefone);
				$('#email').text(os.email);
				$('#dataInicio').text(os.dataInicio);
				$('#situacao').text(os.situacao);
				
				var nome = $('#nome').text();
				var idOs = $('td[name=nome]:contains('+nome+')').parent().children('td[name=id]').text();
				
				$.ajax({
					type : 'GET',
					url : 'projetoController.do?acao=buscaOngProj',
					data  : {idOs: idOs},
					headers : {
						Accept : "application/json; charset=utf-8",
						"Content-Type" : "application/json; charset=utf-8"
					},
					success : function(resultado) {
						var listaProj = jQuery.parseJSON(resultado);
						
						$('select.form-control').empty();
						
						for(var i=0; i < listaProj.length; i++){
							
							$('select.form-control').append(
								'<option>'+listaProj[i].nome+'</option>'
							);
						}
						
					},
				});
			},
		});
	});
	
});