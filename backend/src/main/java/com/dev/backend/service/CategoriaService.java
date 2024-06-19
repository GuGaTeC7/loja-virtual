package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos(){
            return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria obj){
        obj.setDataCriacao(new Date());
        Categoria objNovo = categoriaRepository.saveAndFlush(obj);
        return objNovo;
    }

    public Categoria alterar(Categoria obj) {
        Categoria categoriaExistente = categoriaRepository.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaExistente.setNome(obj.getNome());
        categoriaExistente.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoriaExistente);
    }

    public void excluir(Long id) {
        Categoria obj = categoriaRepository.findById(id).get();
        categoriaRepository.delete(obj);
    }

}
