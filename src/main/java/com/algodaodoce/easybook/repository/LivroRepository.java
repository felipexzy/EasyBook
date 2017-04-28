package com.algodaodoce.easybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algodaodoce.easybook.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
