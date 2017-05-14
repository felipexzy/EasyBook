package com.algodaodoce.easybook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algodaodoce.easybook.entity.Livro;
import com.algodaodoce.easybook.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired LivroRepository livroRepository;
	
	public Livro salvar(Livro livro){
		
		return this.livroRepository.save(livro);
	}
	
	public Livro buscar(Long id){
		
		return this.livroRepository.getOne(id);
	}
	
	public List<Livro> listar(){
		
		List<Livro> livros = livroRepository.findAll();
		
		return livros;
	}
	
	public List<Livro> listarPorNome(String nome){
		return this.livroRepository.listarPorNome(nome);
	}
	
	public Livro deletar(Livro l){
		Livro livro = this.buscar(l.getId());
		if(livro != null) this.livroRepository.delete(livro);
		return livro;
	}
}
