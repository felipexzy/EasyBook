<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Livros</title>
	<style type="text/css">
		@IMPORT url("static/bootstrap/css/bootstrap.min.css");
		@IMPORT url("static/bootstrap/css/bootstrap-theme.min.css");

</style>
</head>
<body>

	<section class="container">
		<button type="button" id="btn-cadastrar" class="btn btn-primary">
				Cadastrar
		</button>
		<form id="form-livro" action="" method="post">
			<input type="hidden" id="id" name="id"/>
			<input type="hidden" id="imagem" name="imagem"/>
			<div>
				<label for="imagemBase">Imagem: </label>
				<input type="file" id="imagemBase" name="imagemBase" class="form-control" accept="image/*"/>
					<img  src = "data: image / *; base64,"  id="id_imagem" height="50px" width="50px"/>
			</div>
			
			<div>
				<label for="nome">Nome: </label>
				<input type="text" id="nome" name="nome" class="form-control" required="required"/>
			</div>
			<div>
				<label for="isbn">ISBN: </label>
				<input type="text" id="isbn" name="isbn" class="form-control"/>
			</div>
			<div>
				<label for="autor">Autor: </label>
				<input type="text" id="autor" name="autor" class="form-control"/>
			</div>
			<div>
				<label for="nome">Editora: </label>
				<input type="text" id="editora" name="editora" class="form-control"/>
			</div>
			<div>
				<label for="nome">Descrição: </label>
				<input type="text" id="descricao" name="descricao" class="form-control"/>
			</div>
		
			<input type="button" id="btn-salvar" value="Salvar" class="btn btn-primary"/>
			<input type="button" id="btn-cancelar" value="Cancelar" class="btn btn-default"/>
		</form>
		<table class="table table-hover table-condensed table-striped " id="tabela">
			<thead>
				<tr>
					<th>Nome</th>
					<th>ISBN</th>
					<th>Autor</th>
					<th>Editora</th>
					<th>Descrição</th>
					<th>Imagem</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${livros}" var="livro">
					<tr data-id="${livro.id}">
						<td>${livro.nome}</td>
						<td>${livro.isbn}</td>
						<td>${livro.autor}</td>
						<td>${livro.editora}</td>
						<td>${livro.descricao}</td>
						<td><img  src = "data: image / *; base64,${livro.imagem64}" height="50px" width="50px"/></td>
						<td><input type="button" onclick="editar(this)" id="btn-editar" value="Editar" class="btn btn-warning"/></td>
						<td><input type="button" onclick="remover(this)" id="btn-deletar" value="Deletar" class="btn btn-danger"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<script type="text/javascript" src="static/js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.bootstrap-growl.min.js"></script>
	<script type="text/javascript" src="static/js/livro.js"></script>
</body>
</html>