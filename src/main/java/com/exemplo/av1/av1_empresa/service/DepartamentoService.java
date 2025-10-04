package com.exemplo.av1.av1_empresa.service;

import com.exemplo.av1.av1_empresa.model.Departamento;
import com.exemplo.av1.av1_empresa.repository.DepartamentoRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repo;

    public DepartamentoService(DepartamentoRepository repo) {
        this.repo = repo;
    }

    public Departamento salvar(Departamento d) { return repo.save(d); }
    public List<Departamento> listar() { return repo.findAll(); }
    public Departamento buscarPorId(Long id) { return repo.findById(id).orElse(null); }
    public void deletar(Long id) { repo.deleteById(id); }
}
