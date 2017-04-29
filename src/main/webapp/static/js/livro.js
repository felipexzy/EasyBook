$(document).ready(function(){
	
	$("#imagemBase").on("change", readFile);
	
	$("#form-livro").hide();
	
	$("#btn-cancelar").click(function(){
	   limpar();
	});

	$("#btn-cadastrar").click(function(){
	    $("#form-livro").show();
	});
	
	$('#btn-salvar').on('click', function(){
		var url = 'livro';
		//var imagemBase64 = $('#imagem').val();
		//var clip = imagemBase64.split(",");
		//console.log(imagemBase64)
		//$('#imagem').val(clip[1]);
		var dadosLivro = $('#form-livro').serialize();
		
		if($('#id').val()){
			$('tr[data-id="'+$('#id').val()+'"]').remove();
		}
		
		$.post(url, dadosLivro)
			.done(function(livro){
				$('#tabela').last().append(
		                '<tr data-id="' + livro.id + '">' +
		                    '<td>' + livro.nome + '</td>' +
		                    '<td>' + livro.isbn + '</td>' +
		                    '<td>' + livro.autor + '</td>' +
		                    '<td>' + livro.editora + '</td>' +
		                    '<td>' + livro.descricao + '</td>' +
		                    '<td>' + '<input type="button" onclick="editar(this)" value="Editar" class="btn btn-warning btn-editar"/>' + '</td>' +
		                    '<td>' + '<input type="button" onclick="remover(this)" id="btn-deletar" value="Deletar" class="btn btn-danger"/>' + '</td>' +
		                '</tr>'
		            );
				$.bootstrapGrowl('Salvo com sucesso', {
					  ele: 'body', // which element to append to
					  type: 'success', // (null, 'info', 'danger', 'success')
					  offset: {from: 'top', amount: 20}, // 'top', or 'bottom'
					  align: 'right', // ('left', 'right', or 'center')
					  width: 250, // (integer, or 'auto')
					  delay: 4000, // Time while the message will be displayed. It's not equivalent to the *demo* timeOut!
					  allow_dismiss: true, // If true then will display a cross to close the popup.
					  stackup_spacing: 10 // spacing between consecutively stacked growls.
					});
			})
			.fail(function(erro){
				$.bootstrapGrowl('Erro ao salvar!' + erro.responseJSON.message, {
					  ele: 'body', // which element to append to
					  type: 'danger', // (null, 'info', 'danger', 'success')
					  offset: {from: 'top', amount: 20}, // 'top', or 'bottom'
					  align: 'right', // ('left', 'right', or 'center')
					  width: 250, // (integer, or 'auto')
					  delay: 4000, // Time while the message will be displayed. It's not equivalent to the *demo* timeOut!
					  allow_dismiss: true, // If true then will display a cross to close the popup.
					  stackup_spacing: 10 // spacing between consecutively stacked growls.
					});
				
			})
			.always(function(){
				limpar();
			});
	});	

});


function readFile() {
	  
	  if (this.files && this.files[0]) {
	    
	    var FR = new FileReader();
	    
	    FR.addEventListener("load", function(e) {
	      document.getElementById("id_imagem").src = e.target.result;
	      //var imagemConvertida = e.target.result;
	     var a =  $('#imagem').val(e.target.result);
	    }); 
	    
	    FR.readAsDataURL(this.files[0]);
	  }  
}

function limpar(){
	$('#id').val('');
	$('#nome').val('');
	$('#isbn').val('');
	$('#autor').val('');
	$('#editora').val('');
	$('#descricao').val('');
	$("#form-livro").hide();
}

function editar(evento){
	var id = $(evento).parents('tr').data('id');
	var url = 'livro/'+id;
	
	$.get(url)
		.success(function(livro){
			
			$('#id').val(livro.id);
			$('#nome').val(livro.nome);
			$('#isbn').val(livro.isbn);
			$('#autor').val(livro.autor);
			$('#editora').val(livro.editora);
			$('#descricao').val(livro.descricao);
			$("#form-livro").show();		
	});
}



function remover(evento){
	var id = $(evento).parents('tr').data('id');
	var url = 'livro/'+id;
	
	$.ajax({
		url : url,
		type: 'DELETE',
	    success: function(result) {
	    	$('tr[data-id="'+id+'"]').remove();
	    	$.bootstrapGrowl('Deletado Com success', {
				  ele: 'body', // which element to append to
				  type: 'success', // (null, 'info', 'danger', 'success')
				  offset: {from: 'top', amount: 20}, // 'top', or 'bottom'
				  align: 'right', // ('left', 'right', or 'center')
				  width: 250, // (integer, or 'auto')
				  delay: 4000, // Time while the message will be displayed. It's not equivalent to the *demo* timeOut!
				  allow_dismiss: true, // If true then will display a cross to close the popup.
				  stackup_spacing: 10 // spacing between consecutively stacked growls.
				});
	    }
	});
}
