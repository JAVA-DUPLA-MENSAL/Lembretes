package com.example.lembretes.repository;

import com.example.lembretes.entity.Lembretes;
import com.example.lembretes.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    @Query(value = "SELECT p FROM Pessoa p where p.nome = :nome")
    List<Pessoa> findPessoaByNome(@Param("nome")final String nome);


}
