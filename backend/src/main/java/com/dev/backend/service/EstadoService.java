package com.dev.backend.service;

import java.util.List;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado obj) {
        Estado estadoExistente = estadoRepository.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Estado não encontrada"));
        estadoExistente.setNome(obj.getNome());
        estadoExistente.setSigla(obj.getSigla());
        estadoExistente.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estadoExistente);
    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }

}
