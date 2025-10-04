package com.exemplo.av1.av1_empresa.controller.mvc;

import com.exemplo.av1.av1_empresa.model.Departamento;
import com.exemplo.av1.av1_empresa.service.DepartamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoMvcController {

    private final DepartamentoService service;

    public DepartamentoMvcController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("departamentos", service.listar());
        return "departamentos/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "departamentos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/{id}/editar")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("departamento", service.buscarPorId(id));
        return "departamentos/form";
    }

    @PostMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/departamentos";
    }
}
