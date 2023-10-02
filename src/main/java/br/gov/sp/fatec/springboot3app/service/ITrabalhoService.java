package br.gov.sp.fatec.springboot3app.service;

import java.util.List;

import br.gov.sp.fatec.springboot3app.entity.Trabalho;

public interface ITrabalhoService {

    public Trabalho novoTrabalho(Trabalho trabalho);

    public List<Trabalho> buscarTodostrabalhos();

    public Trabalho buscarTrabalhoPorId(Long id);

}