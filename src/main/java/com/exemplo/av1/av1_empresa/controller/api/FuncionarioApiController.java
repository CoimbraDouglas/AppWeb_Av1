package com.exemplo.av1.av1_empresa.controller.api;

import com.exemplo.av1.av1_empresa.model.Funcionario;
import com.exemplo.av1.av1_empresa.service.FuncionarioService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioApiController {

    private final FuncionarioService service;

    public FuncionarioApiController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario f) {
        return service.salvar(f);
    }

    @GetMapping
    public List<Funcionario> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
        Funcionario f = service.buscarPorId(id);
        return f == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(f);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario f) {
        Funcionario existente = service.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        existente.setNome(f.getNome());
        existente.setEmail(f.getEmail());
        existente.setDataAdmissao(f.getDataAdmissao());
        existente.setDepartamento(f.getDepartamento());
        return ResponseEntity.ok(service.salvar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id) == null) return ResponseEntity.notFound().build();
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
