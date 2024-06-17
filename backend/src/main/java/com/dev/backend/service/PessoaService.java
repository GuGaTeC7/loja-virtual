package com.dev.backend.service;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import com.dev.backend.util.CpfValidator;
import com.dev.backend.util.EmailValidator;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa) {
        if (!CpfValidator.isValidCPF(pessoa.getCpf())) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        if (!EmailValidator.isValidEmail(pessoa.getEmail())) {
            throw new IllegalArgumentException("Email inválido!");
        }
        pessoa.setDataCriacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public Pessoa alterar(Pessoa obj) {
        if (!CpfValidator.isValidCPF(obj.getCpf())) {
            throw new IllegalArgumentException("CPF inválido!");
        }

        if (!EmailValidator.isValidEmail(obj.getEmail())) {
            throw new IllegalArgumentException("Email inválido!");
        }

        Pessoa pessoaExistente = pessoaRepository.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoaExistente.setNome(obj.getNome());
        pessoaExistente.setCpf(obj.getCpf());
        pessoaExistente.setEmail(obj.getEmail());
        pessoaExistente.setSenha(obj.getSenha());
        pessoaExistente.setEndereco(obj.getEndereco());
        pessoaExistente.setCep(obj.getCep());
        pessoaExistente.setCidade(obj.getCidade());
        pessoaExistente.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoaExistente);
    }

    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }
}
