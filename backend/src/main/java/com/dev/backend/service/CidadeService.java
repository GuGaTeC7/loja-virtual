package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }
    
    public Cidade inserir(Cidade obj){
        obj.setDataCriacao(new Date());
        Cidade objNovo = cidadeRepository.saveAndFlush(obj);
        return objNovo;
    }

    public Cidade alterar(Cidade obj) {
        Cidade cidadeExistente = cidadeRepository.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        cidadeExistente.setNome(obj.getNome());
        cidadeExistente.setEstado(obj.getEstado());
        cidadeExistente.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(cidadeExistente);
    }

    public void excluir(Long id) {
        Cidade obj = cidadeRepository.findById(id).get();
        cidadeRepository.delete(obj);
    }
}
