package com.exemplo.av1.av1_empresa.controller.api;

import com.exemplo.av1.av1_empresa.model.Departamento;
import com.exemplo.av1.av1_empresa.service.DepartamentoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoApiController {

    private final DepartamentoService service;

    public DepartamentoApiController(DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public Departamento criar(@RequestBody Departamento dept) {
        return service.salvar(dept);
    }

    @GetMapping
    public List<Departamento> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
        Departamento d = service.buscarPorId(id);
        return d == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(d);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizar(@PathVariable Long id, @RequestBody Departamento dept) {
        Departamento existente = service.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        existente.setNome(dept.getNome());
        existente.setLocalizacao(dept.getLocalizacao());
        return ResponseEntity.ok(service.salvar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id) == null) return ResponseEntity.notFound().build();
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
