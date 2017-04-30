package com.algodaodoce.easybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algodaodoce.easybook.entity.Livro;
import com.algodaodoce.easybook.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired LivroService livroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> livro(){
		
		return new ResponseEntity<List<Livro>>(livroService.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Livro> salvar(Livro livro) {
		
		return new ResponseEntity<Livro>(this.livroService.salvar(livro),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable Long id){
		
		return new ResponseEntity<Livro>(this.livroService.buscar(id),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Livro> deletar(@PathVariable Long id){
		
		return new ResponseEntity<Livro>(this.livroService.deletar(id),HttpStatus.OK);
	}
}
