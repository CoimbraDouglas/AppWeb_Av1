package com.exemplo.av1.av1_empresa.service;

import com.exemplo.av1.av1_empresa.model.Funcionario;
import com.exemplo.av1.av1_empresa.repository.FuncionarioRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repo;

    public FuncionarioService(FuncionarioRepository repo) {
        this.repo = repo;
    }

    public Funcionario salvar(Funcionario f) { return repo.save(f); }
    public List<Funcionario> listar() { return repo.findAll(); }
    public Funcionario buscarPorId(Long id) { return repo.findById(id).orElse(null); }
    public void deletar(Long id) { repo.deleteById(id); }
}
