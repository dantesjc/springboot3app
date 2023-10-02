package br.gov.sp.fatec.springboot3app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3app.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{

    @Query("select t from Trabalho t where t.titulo = ?1 AND t.nota > 1")
    public Optional<Trabalho> buscarPorTitulo(String titulo);
}
