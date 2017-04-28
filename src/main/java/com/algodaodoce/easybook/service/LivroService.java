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
		return this.livroRepository.findAll();
	}
	
	public Livro deletar(Long id){
		Livro livro = this.buscar(id);
		if(livro != null) this.livroRepository.delete(livro);
		return livro;
	}
}