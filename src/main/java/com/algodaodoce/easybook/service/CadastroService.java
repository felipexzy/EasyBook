package com.algodaodoce.easybook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.algodaodoce.easybook.entity.Permissao;
import com.algodaodoce.easybook.entity.Usuario;
import com.algodaodoce.easybook.repository.PermissaoRepository;
import com.algodaodoce.easybook.repository.UsuarioRepository;

@Service
public class CadastroService {

	@Autowired UsuarioRepository usuarioRepository;
	@Autowired PermissaoRepository permissaoRepository;
	
	public Usuario salvar(Usuario usuario){
		
		List<Permissao> permissoes = new ArrayList<>();
		permissoes.add(this.permissaoRepository.findOne(new Long(2)));
		
		usuario.setPermissoes(permissoes);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		
		return this.usuarioRepository.save(usuario);
	}

	public List<Usuario> listar() {
		
		return this.usuarioRepository.findAll();
	}
	
}
