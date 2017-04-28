package com.algodaodoce.easybook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	private String autor;
	
	private String descrição;
	
	private String isbn;
	
	@Column(columnDefinition = "blob")
	private byte[] imagem;
	
	private String editora;
	
	public Livro() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Livro(Long id, String nome, String autor, String descrição, String isbn, byte[] imagem, String editora) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.descrição = descrição;
		this.isbn = isbn;
		this.imagem = imagem;
		this.editora = editora;
	}
}
