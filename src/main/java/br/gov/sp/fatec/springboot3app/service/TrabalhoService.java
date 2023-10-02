package br.gov.sp.fatec.springboot3app.service;

 

import java.util.List;

import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatusCode;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.client.HttpStatusCodeException;

import org.springframework.web.server.ResponseStatusException;

 

import br.gov.sp.fatec.springboot3app.entity.Trabalho;

import br.gov.sp.fatec.springboot3app.repository.TrabalhoRepository;

 

@Service

public class TrabalhoService implements ITrabalhoService {

 

    @Autowired

    private TrabalhoRepository trabalhoRepo;

 

    @Transactional

    public Trabalho novoTrabalho(Trabalho trabalho) {

        if(trabalho == null ||

                trabalho.getTitulo() == null ||

                trabalho.getTitulo().isBlank() ||

                trabalho.getDescricao() == null ||

                trabalho.getDescricao().isBlank() ||

                trabalho.getGrupo() == null ||

                trabalho.getGrupo().isBlank() ||

                trabalho.getNota() == null ||

                trabalho.getJustificativa() == null ||

                trabalho.getJustificativa().isBlank()) {

            throw new IllegalArgumentException("Dados inválidos!");

        }

        try {

            trabalho = trabalhoRepo.save(trabalho);

        }

        catch(Exception e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao inserir trabalho!");

        }

        return trabalho;

    }

 

    public List<Trabalho> buscarTodostrabalhos() {

        return trabalhoRepo.findAll();

    }

 

    public Trabalho buscarTrabalhoPorId(Long id) {

        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);

        if(trabalhoOp.isEmpty()) {

            throw new IllegalArgumentException("Trabalho não encontrado!");

        }

        return trabalhoOp.get();

    }

}

