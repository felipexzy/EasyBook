package com.algodaodoce.easybook.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
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
	
		for(Livro livro : livros){
			byte[] base64 = Base64.encodeBase64(livro.getImagem());
			String valor = null;
			try {
				valor = new String(base64, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			livro.setImagem64(valor);
		}
		
		return livros;
	}
	
	public Livro deletar(Long id){
		Livro livro = this.buscar(id);
		if(livro != null) this.livroRepository.delete(livro);
		return livro;
	}
}
